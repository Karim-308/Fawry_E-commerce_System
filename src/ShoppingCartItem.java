public class ShoppingCartItem {
    private Item item;
    private int quantity;

    public ShoppingCartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() { return item; }
    public int getQuantity() { return quantity; }
} 