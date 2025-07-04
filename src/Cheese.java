public class Cheese extends ExpirableItem implements Deliverable {
    private double itemWeight;

    public Cheese(String itemName, double itemPrice, int availableQuantity, boolean expiredStatus, double itemWeight) {
        super(itemName, itemPrice, availableQuantity, expiredStatus);
        this.itemWeight = itemWeight;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getItemWeight() {
        return itemWeight;
    }
} 