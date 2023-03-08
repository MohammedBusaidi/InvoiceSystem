
import java.util.*;
public class Invoice {
	
	static Scanner invoiceInput = new Scanner(System.in);
	private int invoiceNumber;
	private String Name;
	private int phoneNumber;
	private Date invoiceDate;
    private double paidAmount;
    ArrayList<InvoiceItem> items = new ArrayList<InvoiceItem>();
	

    
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getName() {
        return Name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public double getTotalAmount() {
    	double totalAmount = 0;
    	for (InvoiceItem i : items) {
    		totalAmount += i.getTotalAmount();
    	}
        return totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getBalance() {
        return getPaidAmount() - getTotalAmount();
    }
    
    public int getItems() {
		return items.size();
	}
    
    public void setInvoiceNumber(int invoiceNumber) {
    	this.invoiceNumber = invoiceNumber;
    }
    
    public void setName(String Name) {
    	this.Name = Name;
    }
    public void setPhoneNumber(int phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }
    public void setInvoiceDate(Date invoiceDate) {
    	this.invoiceDate = invoiceDate;
    }
    public boolean setPaidAmount(double paidAmount) {
    	if(paidAmount >= getTotalAmount()) {
    		this.paidAmount = paidAmount;
    		return true;
    	} else {return false;}
    }
    
    
		
    
    
}
