public class Main {
    public static void main(String[] args) {
        // 1. Normal Checkout (valid products, enough balance)
        System.out.println("\n--- Scenario 1: Normal Checkout ---");
        Cheese cheese = new Cheese("Cheese", 100, 10, false, 400);
        TV tv = new TV("TV", 5000, 3, 8000);
        Customer customer1 = new Customer("Ali", 10000);
        ShoppingCart cart1 = new ShoppingCart();
        try {
            cart1.add(cheese, 2);
            cart1.add(tv, 1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        CheckoutService.checkout(customer1, cart1);

        // 2. Out of Stock
        System.out.println("\n--- Scenario 2: Out of Stock ---");
        ShoppingCart cart2 = new ShoppingCart();
        try {
            cart2.add(tv, 10); // Only 2 left after previous scenario
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        CheckoutService.checkout(customer1, cart2);

        // 3. Expired Product
        System.out.println("\n--- Scenario 3: Expired Product ---");
        Cheese expiredCheese = new Cheese("Old Cheese", 80, 5, true, 400);
        ShoppingCart cart3 = new ShoppingCart();
        try {
            cart3.add(expiredCheese, 1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        CheckoutService.checkout(customer1, cart3);

        // 4. Insufficient Balance
        System.out.println("\n--- Scenario 4: Insufficient Balance ---");
        Customer poorCustomer = new Customer("Bob", 100);
        ShoppingCart cart4 = new ShoppingCart();
        try {
            cart4.add(tv, 1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        CheckoutService.checkout(poorCustomer, cart4);

        // 5. Only Non-Shippable Products
        System.out.println("\n--- Scenario 5: Only Non-Shippable Products ---");
        Mobile mobile = new Mobile("Mobile", 2000, 10);
        ScratchCard scratchCard = new ScratchCard("ScratchCard", 50, 20);
        ShoppingCart cart5 = new ShoppingCart();
        try {
            cart5.add(mobile, 1);
            cart5.add(scratchCard, 2);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        CheckoutService.checkout(customer1, cart5);

        // 6. Empty Cart
        System.out.println("\n--- Scenario 6: Empty Cart ---");
        ShoppingCart cart6 = new ShoppingCart();
        CheckoutService.checkout(customer1, cart6);
    }
} 