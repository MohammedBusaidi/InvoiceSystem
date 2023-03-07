
import java.time.LocalDate;
import java.util.*;
public class Invoice {
	
	Scanner invoiceInput = new Scanner(System.in);
	private int invoiceNumber;
	private String Name;
	private int phoneNumber;
	private Date invoiceDate;
	ArrayList<InvoiceItem> items = new ArrayList<InvoiceItem>();
    private double paidAmount;
    
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

    public int getItems() {
        return items.size();
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
    
    public void createInvoice() {
    	System.out.println("Enter customer InvoiceNumber: ");
    	int customerNInput = invoiceInput.nextInt();
    	setInvoiceNumber(customerNInput);
    	System.out.println("Enter customer Full Name: ");
    	String customerNameInput = invoiceInput.next();
    	setName(customerNameInput);
    	System.out.println("Enter customer phone number: ");
		int customerPhoneNInput = invoiceInput.nextInt();
		setPhoneNumber(customerPhoneNInput);
		LocalDate invoiceDate = LocalDate.now();
		System.out.println("=======================================");
		System.out.println(customerNInput);
		System.out.println(customerNameInput);
		System.out.println(customerPhoneNInput);
		System.out.println(invoiceDate);
		System.out.println("=======================================");
		
    }
}
