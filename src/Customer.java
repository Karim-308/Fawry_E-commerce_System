public class Customer {
    private String customerName;
    private double walletBalance;

    public Customer(String customerName, double walletBalance) {
        this.customerName = customerName;
        this.walletBalance = walletBalance;
    }

    public String getCustomerName() { return customerName; }
    public double getWalletBalance() { return walletBalance; }
    public void deductFromBalance(double amount) { this.walletBalance -= amount; }
} 