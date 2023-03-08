import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class ShopManager {
	Scanner shopScanner = new Scanner(System.in);
	
    private String shopName;
    private List<InvoiceItem> items;
    private int tel;
    private int fax;
    private String email;
    private String website;
    static ArrayList<Product> products = new ArrayList<Product>();
	public ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	Product newProduct = new Product();
   
    public String getShopName() {
        return shopName;
    }
    
    public List<InvoiceItem> getItems() {
        return items;
    }
    
    public int getTel() {
        return tel;
    }
    
    public int getFax() {
    	return fax;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public String getWebsite() {
    	return website;
    }
    
    public String getInvoice() {
		return "Tel: " + tel + "\nFax: " + fax + "\nEmail: " + email + "\nWebsite: " + website;
	}

    public void setShopName(String shopName) {
    	
    	try (FileWriter writer = new FileWriter("ShopName.txt", true)) {
    		writer.write("=========================\n");
    		writer.write("Shop Name: " + shopName + "\n");
    		writer.write("=========================\n");
    		 writer.close();
 	        System.out.println("SHOP NAME SAVED!");
    	}catch(Exception e) {
	    	System.out.println("ERROR!");
	        e.printStackTrace();
    	}
        this.shopName = shopName;
    }
    
    public void setTel(int tel) {
    	this.tel = tel;
    }
    
    public void setFax(int fax) {
    	this.fax = fax;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setWebsite(String website) {
    	this.website = website;
    }
  
    public void setInvoice(int tel, int fax, String email, String website) {
    	this.tel = tel;
    	this.fax = fax;
    	this.email = email;
    	this.website = website;
    }

    public void setInvoice() {
	    System.out.println("Enter information:");
	    System.out.print("Tel: ");
	    int telInput = shopScanner.nextInt();
	    System.out.print("Fax: ");
	    int faxInput = shopScanner.nextInt();
	    System.out.print("Email: ");
	    String emailInput = shopScanner.next();
	    System.out.print("Website: ");
	    String websiteInput = shopScanner.next();
	    setInvoice(telInput, faxInput, emailInput, websiteInput);
	   
	   try (FileWriter writer = new FileWriter("InvoiceHeader.txt", true)) {
		   writer.write(String.format("%20s %20s %20s %20s\n", "Tel", "Fax", "Email", "Website"));
		   writer.write("=======================================================================================\n");
		   writer.write(String.format("%20s %20s %20s %20s\n",
				   telInput, faxInput, emailInput, websiteInput
				   ));
		   writer.write("=======================================================================================\n");
   		 writer.close();
	        System.out.println("INVOICE HEADER SAVED!");
   	}catch(Exception e) {
	    	System.out.println("ERROR!");
	        e.printStackTrace();
   	}

    }
    
	public void addItem() {
		boolean addItemLoop = true;
		while (addItemLoop) {
		System.out.println("Enter item ID: ");
		int addIdInput = shopScanner.nextInt();
		newProduct.setId(addIdInput);
		System.out.println("Enter item Name: ");
		String addNameInput = shopScanner.next();
		newProduct.setName(addNameInput);
		System.out.println("Enter item Price: ");
		double addPriceInput = shopScanner.nextDouble();
		newProduct.setPrice(addPriceInput);
		products.add(newProduct);
		System.out.println("Enter Quantity: ");
		float addQuantity = shopScanner.nextFloat();
		newProduct.setQunatity(addQuantity);
		System.out.println("Do you want to add more Items?");
		String itemOption = shopScanner.next();
			if (itemOption.equalsIgnoreCase("Y") || itemOption.equalsIgnoreCase("yes")) {
			}
			else if(itemOption.equalsIgnoreCase("N") || itemOption.equalsIgnoreCase("no")) {
				addItemLoop = false;
			}
			else {
				System.out.println("Invalid Input");
			}
		try (FileWriter writer = new FileWriter("Items.txt", true)) {
			   writer.write(String.format("%20s %20s %20s %20s\n", "ID", "Name", "Price", "Quantity"));
			   writer.write("====================================================================================\n");
			   for (int j = 0; j < products.size(); j++) {
			   writer.write(String.format("%20s %20s %20s %20s\n",
				    		products.get(j).getId(),
				    		products.get(j).getName(),
				    		products.get(j).getPrice(),
				    		products.get(j).getQuantity()
					   ));
			   }
			   writer.write("====================================================================================\n");
	   		 writer.close();
		        System.out.println("iTEMS SAVED!");
	   	}catch(Exception e) {
		    	System.out.println("ERROR!");
		        e.printStackTrace();
	   	}
		}
   
    }

    public void removeItem() {
    	System.out.println("Enter item ID you want to delete: ");
		int removeIdInput = shopScanner.nextInt();
		for(int i = 0; i< products.size(); i++) {
			if (removeIdInput == products.get(i).getId()) {
				products.remove(i);
				System.out.println("Item Removed!");
				break;
			}
		}
    }
    
    public void changePrice() {
    	System.out.println("Enter item ID you want to change the Price: ");
    	int changeIdInput = shopScanner.nextInt();
    	boolean idExists = false;
    	int newPriceInput = 0;
    	for (Product i: products) {
    		if (changeIdInput == i.getId()) {
    			System.out.println("Enter the new price: ");
    			newPriceInput = shopScanner.nextInt();
    			products.get(products.indexOf(i)).setPrice(newPriceInput);
    			idExists = true;
    			break;
    		}
    		
    	}
    	if (idExists) {
    		System.out.println("Price Changed! The new price is: " + newPriceInput );
    	}
    	else {
			System.out.println("Invalid ID!");
		}
    }
    
    public void printAllItems() {
    	System.out.println("All Items: ");
    	System.out.println("=======================================");
    	for (int i = 0; i < products.size(); i++) {
    		System.out.println(products.get(i).getId()); 
    		System.out.println(products.get(i).getName());
    		System.out.println(products.get(i).getPrice()); 
    		System.out.println(products.get(i).getQuantity()); 
    		System.out.println("=======================================");
    	}
    }
    
    Scanner invoiceSc = new Scanner(System.in);
    public void createInvoice() {
        Invoice newInvoice = new Invoice();
    	boolean invoiceLoop = true;
    	while (invoiceLoop) {
    	System.out.println("Enter customer InvoiceNumber: ");
    	int customerNInput = invoiceSc.nextInt();
    	newInvoice.setInvoiceNumber(customerNInput);
    	System.out.println("Enter customer Full Name: ");
    	String customerNameInput = invoiceSc.next();
    	newInvoice.setName(customerNameInput);
    	System.out.println("Enter customer phone number: ");
		int customerPhoneNInput = invoiceSc.nextInt();
		newInvoice.setPhoneNumber(customerPhoneNInput);
		LocalDate invoiceDate = LocalDate.now();
		System.out.println("Do you want to another invoice?");
		String invoiceOption = invoiceSc.next();
			if (invoiceOption.equalsIgnoreCase("Y") || invoiceOption.equalsIgnoreCase("yes")) {
			}
			else if(invoiceOption.equalsIgnoreCase("N") || invoiceOption.equalsIgnoreCase("no")) {
				invoiceLoop = false;
			}
			else {
				System.out.println("Invalid Input");
			}
			//to store the invoices in a list.
			invoices.add(newInvoice);
		//Save to File
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
    
    public Invoice printInvoice() {
    	System.out.println("Invoice Details: \n");
    	System.out.println("================================================= \n");
    	for (int i = 0; i < invoices.size(); i++) {
    		System.out.println("Invoice Number");
    		System.out.println(invoices.get(i).getInvoiceNumber());
    		System.out.println("Name: ");
        	System.out.println(invoices.get(i).getName());
        	System.out.println("Phone Number: ");
        	System.out.println(invoices.get(i).getPhoneNumber());
        	System.out.println("Total Balance: ");
        	System.out.println(invoices.get(i).getTotalAmount());
        	System.out.println("================================================= \n");
    	}
    	return null;
    }
    
    public Invoice searchInoive() {
    	System.out.println("Enter the invoice number to show all details: ");
    	int searchInput = invoiceSc.nextInt();
    	for (int i =0; i < invoices.size(); i++) {
    		if (searchInput == invoices.get(i).getInvoiceNumber()) {
    			System.out.println("Name: " + invoices.get(i).getName());
        		System.out.println("Phone Number" + invoices.get(i).getPhoneNumber());
        	}
    	}
		return null;
	}
}
