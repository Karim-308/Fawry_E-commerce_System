public class ScratchCard extends Item {
    public ScratchCard(String itemName, double itemPrice, int availableQuantity) {
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