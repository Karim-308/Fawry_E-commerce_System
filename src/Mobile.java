public class Mobile extends Item {
    public Mobile(String itemName, double itemPrice, int availableQuantity) {
        super(itemName, itemPrice, availableQuantity);
    }

    @Override
    public boolean hasExpired() {
        return false;
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }
} 