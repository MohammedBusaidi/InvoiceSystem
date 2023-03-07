import java.util.*;

public class ShopManager {
	Scanner shopScanner = new Scanner(System.in);
	
    private String shopName;
    private List<InvoiceItem> items;
    private int tel;
    private int fax;
    private String email;
    private String website;
    static ArrayList<Invoice> invoice = new ArrayList<Invoice>();
    static ArrayList<Product> products = new ArrayList<Product>();
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
    }
    
	public void addItem() {
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
		System.out.println("Item Added!");
   
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
    		System.out.println("=======================================");
    	}
    }
}
