public class TV extends DeliverableItem {
    public TV(String itemName, double itemPrice, int availableQuantity, double itemWeight) {
        super(itemName, itemPrice, availableQuantity, itemWeight);
    }

    @Override
    public boolean hasExpired() {
        return false;
    }
} 