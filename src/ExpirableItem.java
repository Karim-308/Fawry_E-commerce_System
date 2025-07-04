public abstract class ExpirableItem extends Item {
    protected boolean expiredStatus;

    public ExpirableItem(String itemName, double itemPrice, int availableQuantity, boolean expiredStatus) {
        super(itemName, itemPrice, availableQuantity);
        this.expiredStatus = expiredStatus;
    }

    @Override
    public boolean hasExpired() {
        return expiredStatus;
    }
} 