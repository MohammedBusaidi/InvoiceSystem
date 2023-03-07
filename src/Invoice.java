
import java.io.FileWriter;
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
    	boolean invoiceLoop = true;
    	while (invoiceLoop) {
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
		System.out.println("Do you want to another invoice?");
		String invoiceOption = invoiceInput.next();
			if (invoiceOption.equalsIgnoreCase("Y") || invoiceOption.equalsIgnoreCase("yes")) {
			}
			else if(invoiceOption.equalsIgnoreCase("N") || invoiceOption.equalsIgnoreCase("no")) {
				invoiceLoop = false;
			}
			else {
				System.out.println("Invalid Input");
			}
    	
//		System.out.println("=======================================");
//		System.out.println(customerNInput);
//		System.out.println(customerNameInput);
//		System.out.println(customerPhoneNInput);
//		System.out.println(invoiceDate);
//		System.out.println("=======================================");
		
		try (FileWriter writer = new FileWriter("Invoices.txt", true)) {
			writer.write(String.format("%20s %20s %20s %20s\n", "InvoiceNumber", "Full Name", "Phone Numer", "Date"));
			writer.write("=================================================================================================\n");
			writer.write(String.format("%20s %20s %20s %20s\n",
					customerNInput, customerNameInput, customerPhoneNInput, invoiceDate
					));
    		writer.write("=================================================================================================\n");
    		 writer.close();
 	        System.out.println("INVOICE SAVED!");
    	}catch(Exception e) {
	    	System.out.println("ERROR!");
	        e.printStackTrace();
    	}
    	}
		
    }
}
