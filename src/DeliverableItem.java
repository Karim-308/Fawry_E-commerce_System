public abstract class DeliverableItem extends Item implements Deliverable {
    protected double itemWeight;

    public DeliverableItem(String itemName, double itemPrice, int availableQuantity, double itemWeight) {
        super(itemName, itemPrice, availableQuantity);
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