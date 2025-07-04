public class Biscuits extends ExpirableItem implements Deliverable {
    private double itemWeight;

    public Biscuits(String itemName, double itemPrice, int availableQuantity, boolean expiredStatus, double itemWeight) {
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