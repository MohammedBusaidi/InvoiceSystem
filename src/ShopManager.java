import java.util.*;

public class ShopManager {
	Scanner shopScanner = new Scanner(System.in);
	
    private String shopName;
    private String shopAddress;
    private List<InvoiceItem> items;
    private int tel;
    private int fax;
    private String email;
    private String website;
    static ArrayList<Invoice> invoice = new ArrayList<Invoice>();
    static ArrayList<Product> products = new ArrayList<Product>();
   
    public String getShopName() {
        return shopName;
    }
    
    public List<InvoiceItem> getItems() {
        return items;
    }
    
    public String getShopAddress() {
        return shopAddress;
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

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

  
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }
    
    
    public void setInvoice(int tel, int fax, String email, String website) {
    	this.tel = tel;
    	this.fax = fax;
    	this.email = email;
    	this.website = website;
    }

    
    public String getHeader() {
        String header = "----------------------------------------\n";
        header += "|                                        |\n";
        header += "| Tel: " + tel + "                    |\n";
        header += "| Fax: " + fax + "                    |\n";
        header += "| Email: " + email + "            |\n";
        header += "| Website: " + website + "           |\n";
        header += "|                                        |\n";
        header += "----------------------------------------\n";
        return header;
    }
    public void addItem(InvoiceItem item) {
        items.add(item);
    }

    public void removeItem(InvoiceItem item) {
        items.remove(item);
    }


}
