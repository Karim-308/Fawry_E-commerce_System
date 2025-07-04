public abstract class Item {
    protected String itemName;
    protected double itemPrice;
    protected int availableQuantity;

    public Item(String itemName, double itemPrice, int availableQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.availableQuantity = availableQuantity;
    }

    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }
    public int getAvailableQuantity() { return availableQuantity; }
    public void decreaseQuantity(int qty) { this.availableQuantity -= qty; }

    public abstract boolean hasExpired();
    public abstract boolean requiresShipping();
} 