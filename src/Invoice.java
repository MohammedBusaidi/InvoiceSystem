import java.util.*;
public class Invoice {
	private int invoiceNumber;
	private String customerFullName;
	private String phoneNumber;
	private Date invoiceDate;
	private List<Item> items;
	private double totalAmount;
    private double paidAmount;
    private double balance;
    
    public Invoice(
    		int invoiceNumber, 
    		String customerFullName, 
    		String phoneNumber, 
    		Date invoiceDate, 
    		List<Item> items, 
    		double totalAmount, 
    		double paidAmount, 
    		double balance
    		){
        this.invoiceNumber = invoiceNumber;
        this.customerFullName = customerFullName;
        this.phoneNumber = phoneNumber;
        this.invoiceDate = invoiceDate;
        this.items = items;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.balance = balance;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
