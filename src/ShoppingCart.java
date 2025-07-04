import java.util.*;

public class ShoppingCart {
    private List<ShoppingCartItem> cartItems = new ArrayList<>();

    public void add(Item item, int quantity) throws IllegalArgumentException {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (quantity > item.getAvailableQuantity()) throw new IllegalArgumentException("Not enough stock for " + item.getItemName());
        if (item.hasExpired()) throw new IllegalArgumentException(item.getItemName() + " is expired");
        for (ShoppingCartItem cartItem : cartItems) {
            if (cartItem.getItem() == item) {
                int newQty = cartItem.getQuantity() + quantity;
                if (newQty > item.getAvailableQuantity()) throw new IllegalArgumentException("Not enough stock for " + item.getItemName());
                cartItems.set(cartItems.indexOf(cartItem), new ShoppingCartItem(item, newQty));
                return;
            }
        }
        cartItems.add(new ShoppingCartItem(item, quantity));
    }

    public List<ShoppingCartItem> getCartItems() {
        return Collections.unmodifiableList(cartItems);
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void clear() {
        cartItems.clear();
    }
} 