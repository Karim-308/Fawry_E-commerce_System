import java.util.*;

public class CheckoutService {
    private static final double SHIPPING_FEE_PER_ITEM = 30.0;

    public static void checkout(Customer customer, ShoppingCart cart) {
        if (cart.isEmpty()) {
            System.err.println("Error: Cart is empty");
            return;
        }
        double subtotal = 0;
        double shipping = 0;
        List<Deliverable> deliverables = new ArrayList<>();
        for (ShoppingCartItem cartItem : cart.getCartItems()) {
            Item item = cartItem.getItem();
            int qty = cartItem.getQuantity();
            if (qty > item.getAvailableQuantity()) {
                System.err.printf("Error: %s is out of stock\n", item.getItemName());
                return;
            }
            if (item.hasExpired()) {
                System.err.printf("Error: %s is expired\n", item.getItemName());
                return;
            }
            subtotal += item.getItemPrice() * qty;
            if (item.requiresShipping()) {
                for (int i = 0; i < qty; i++) {
                    deliverables.add((Deliverable)item);
                }
                shipping += SHIPPING_FEE_PER_ITEM * qty;
            }
        }
        double total = subtotal + shipping;
        if (customer.getWalletBalance() < total) {
            System.err.println("Error: Insufficient balance");
            return;
        }
        if (!deliverables.isEmpty()) {
            ShippingService.ship(deliverables);
        }
        System.out.println("** Checkout receipt **");
        for (ShoppingCartItem cartItem : cart.getCartItems()) {
            System.out.printf("%-18s %.0f\n",
                cartItem.getQuantity() + "x " + cartItem.getItem().getItemName(),
                cartItem.getItem().getItemPrice() * cartItem.getQuantity()
            );
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f\n", subtotal);
        System.out.printf("Shipping         %.0f\n", shipping);
        System.out.printf("Amount           %.0f\n", total);
        customer.deductFromBalance(total);
        for (ShoppingCartItem cartItem : cart.getCartItems()) {
            cartItem.getItem().decreaseQuantity(cartItem.getQuantity());
        }
        System.out.printf("Customer balance after payment: %.0f\n", customer.getWalletBalance());
        cart.clear();
    }
} 