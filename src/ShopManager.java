import java.util.*;
import java.beans.Statement;
import java.io.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.time.LocalDate;

public class ShopManager {
	Scanner shopScanner = new Scanner(System.in);

	private String shopName;
	private int tel;
	private int fax;
	private String email;
	private String website;

	private float totalSales;
	static ArrayList<Product> products = new ArrayList<Product>();
	static ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	static ArrayList<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();

	public String getShopName() {
		return shopName;
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

		try (FileWriter writer = new FileWriter("Invoice.txt", true)) {
			writer.write("=========================\n");
			writer.write("Shop Name: " + shopName + "\n");
			writer.write("=========================\n");
			writer.close();
			System.out.println("SHOP NAME SAVED!");
		} catch (Exception e) {
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
		tel = telInput;
		System.out.print("Fax: ");
		int faxInput = shopScanner.nextInt();
		fax = faxInput;
		System.out.print("Email: ");
		String emailInput = shopScanner.next();
		email = emailInput;
		System.out.print("Website: ");
		String websiteInput = shopScanner.next();
		website = websiteInput;
		setInvoice(tel, fax, email, website);

		try (FileWriter writer = new FileWriter("Invoice.txt", true)) {
			writer.write(String.format("%20s %20s %20s %20s\n", "Tel", "Fax", "Email", "Website"));
			writer.write(
					"=================================================================================================\n");
			writer.write(String.format("%20s %20s %20s %20s\n", tel, fax, email, website));
			writer.write(
					"=================================================================================================\n");
			writer.close();
			System.out.println("INVOICE HEADER SAVED!");
		} catch (Exception e) {
			System.out.println("ERROR!");
			e.printStackTrace();
		}

	}

	public void reportStat() {
		int noOfProducts;
		int noOfInvoices;
		float totalSales = 0;
		for (Invoice i : invoices) {
			totalSales += i.getTotalAmount();
		}
		noOfProducts = products.size();
		noOfInvoices = products.size();
		this.totalSales = totalSales;
		System.out.println("=======================================");
		System.out.println("No Of Items: ");
		System.out.println(noOfProducts);
		System.out.println("No of Invoices: ");
		System.out.println(noOfInvoices);
		System.out.println("Total Sales: ");
		System.out.println(totalSales);
		System.out.println("=======================================");
	}

	public void addItem() {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Connection con = null;
		boolean addItemLoop = true;
		Product newProduct = null;
		InvoiceItem newInvoiceItem = null;
		while (addItemLoop) {
			newProduct = new Product();
			newInvoiceItem = new InvoiceItem();
			System.out.println("=======================================");
			System.out.println("Enter item ID: ");
			int addIdInput = shopScanner.nextInt();
			newProduct.setId(addIdInput);
			System.out.println("Enter item Name: ");
			String addNameInput = shopScanner.next();
			newProduct.setName(addNameInput);
			System.out.println("Enter item Price: ");
			double addPriceInput = shopScanner.nextDouble();
			newProduct.setPrice(addPriceInput);
			System.out.println("Enter the Quantity: ");
			float addQuantityInput = shopScanner.nextFloat();
			newInvoiceItem.setProduct(newProduct);
			newInvoiceItem.setQuantity(addQuantityInput);
			System.out.println("=======================================");

			System.out.println("Do you want to add more Items?");
			String itemOption = shopScanner.next();
			if (itemOption.equalsIgnoreCase("Y") || itemOption.equalsIgnoreCase("yes")) {
			} else if (itemOption.equalsIgnoreCase("N") || itemOption.equalsIgnoreCase("no")) {
				addItemLoop = false;
			} else {
				System.out.println("Invalid Input");
			}
			// to store the products in a list.
			products.add(newProduct);
			invoiceItems.add(newInvoiceItem);
		}
		try (FileWriter writer = new FileWriter("Invoice.txt", true)) {
			writer.write(String.format("%20s %20s %20s  %20s\n", "ID", "Name", "Price", "Quantity"));
			writer.write(
					"=================================================================================================\n");
			for (int i = 0; i < products.size(); i++) {
				for (int j = 0; j < invoiceItems.size(); j++) {
				writer.write(String.format("%20s %20s %20s %20s\n", 
						products.get(i).getId(), 
						products.get(i).getName(),
						products.get(i).getPrice(),
						invoiceItems.get(j).getQuantity()
						));
				}
			
			writer.write(
					"=================================================================================================\n");
			}
			writer.close();
			System.out.println("iTEMS SAVED!");
		} catch (Exception e) {
			System.out.println("ERROR!");
			e.printStackTrace();
		}
		try {
            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);

            con = DriverManager.getConnection(url, user, pass);

            java.sql.Statement st = con.createStatement();
            
            String sql1 = "CREATE TABLE addItems ("	           
    	            + "Item_ID INTEGER primary key,"
    	            + "Item_Name varchar(20) not null,"
    	            + "Item_Price INTEGER,"
    	            + " );"
    	            ;
            st.executeUpdate(sql1);
            System.out.println("created successfully");
            
            String sqlValues1 = "insert into addItems values("
            		+ ""+ newProduct.getId() 
            		+ ",'" 
            		+ newProduct.getName() 
            		+ "'," 
            		+ "'" 
            		+ newProduct.getPrice() 
            		+ ");";
            st.executeUpdate(sqlValues1);

        } catch (Exception ex) {
            System.err.println(ex);
        }
	}

	public void removeItem() {
		System.out.println("Enter item ID you want to delete: ");
		int removeIdInput = shopScanner.nextInt();
		for (int i = 0; i < products.size(); i++) {
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
		for (Product i : products) {
			if (changeIdInput == i.getId()) {
				System.out.println("Enter the new price: ");
				newPriceInput = shopScanner.nextInt();
				products.get(products.indexOf(i)).setPrice(newPriceInput);
				idExists = true;
				break;
			}

		}
		if (idExists) {
			System.out.println("Price Changed! The new price is: " + newPriceInput);
		} else {
			System.out.println("Invalid ID!");
		}
	}

	public void printAllItems() {
		System.out.println("All Items: ");
		System.out.println("=======================================");
		for (int i = 0; i < products.size(); i++) {
			for(int j = 0; j < invoiceItems.size(); j++) {
			System.out.println("Product Id: ");
			System.out.println(products.get(i).getId());
			System.out.println("Product Name: ");
			System.out.println(products.get(i).getName());
			System.out.println("Product Price: ");
			System.out.println(products.get(i).getPrice());
			System.out.println("Quantity: ");
			System.out.println(invoiceItems.get(j).getQuantity());
			System.out.println("Total Price: ");
			System.out.println(invoiceItems.get(j).getTotalAmount());
			System.out.println("=======================================");
		}}
	}

	Scanner invoiceSc = new Scanner(System.in);
	
	

	public void createInvoice() {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Connection con = null;
		boolean invoiceLoop = true;
		Invoice newInvoice = null;
		while (invoiceLoop) {
			newInvoice = new Invoice();
			System.out.println("=======================================");
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
			newInvoice.setInvoiceDate(invoiceDate);
			System.out.println("=======================================");
			System.out.println("Do you want to add another invoice?");
			String invoiceOption = invoiceSc.next();
			if (invoiceOption.equalsIgnoreCase("Y") || invoiceOption.equalsIgnoreCase("yes")) {
			} else if (invoiceOption.equalsIgnoreCase("N") || invoiceOption.equalsIgnoreCase("no")) {
				invoiceLoop = false;
			} else {
				System.out.println("Invalid Input");
			}
			// to store the invoices in a list.
			invoices.add(newInvoice);
		}
		// Save to File
		try (FileWriter writer = new FileWriter("Invoice.txt", true)) {
			writer.write(String.format("%20s %20s %20s %20s\n", "InvoiceNumber", "Full Name", "Phone Number", "Date"));
			writer.write(
					"=================================================================================================\n");
			for (int i = 0; i < invoices.size(); i++) {
				writer.write(String.format("%20s %20s %20s %20s\n", invoices.get(i).getInvoiceNumber(),
						invoices.get(i).getName(), invoices.get(i).getPhoneNumber(), invoices.get(i).getInvoiceDate()));
			}
			writer.write(
					"=================================================================================================\n");
			writer.close();
			System.out.println("INVOICE SAVED!");
		} catch (Exception e) {
			System.out.println("ERROR!");
			e.printStackTrace();
		}

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			java.sql.Statement st = con.createStatement();

			String sql = "CREATE TABLE createInvoice (" + "Invoice_Number INTEGER primary key,"
					+ "Full_Name varchar(20) not null," + "phone_number INTEGER," + "Date date" + " );";
			st.executeUpdate(sql);
			System.out.println("created successfully");

			String sqlValues = "insert into invoices values(" + "" + newInvoice.getInvoiceNumber() + ",'"
					+ newInvoice.getName() + "'," + "'" + newInvoice.getPhoneNumber() + LocalDate.now() + ");";
			st.executeUpdate(sqlValues);

		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public Invoice printInvoice() {
		System.out.println("===== Invoice Details =====");
		System.out.println("=================================================");
		for (int i = 0; i < invoices.size(); i++) {
			System.out.println("Invoice Number: ");
			System.out.println(invoices.get(i).getInvoiceNumber());
			System.out.println("Name: ");
			System.out.println(invoices.get(i).getName());
			System.out.println("Phone Number: ");
			System.out.println(invoices.get(i).getPhoneNumber());
			System.out.println("Number Of Items: ");
			System.out.println(invoices.get(i).getItems());
			System.out.println("Total Balance: ");
			System.out.println(invoices.get(i).getTotalAmount());
			System.out.println("Paid Amount: ");
			System.out.println(invoices.get(i).getPaidAmount());
			System.out.println("Balance: ");
			System.out.println(invoices.get(i).getBalance());
			System.out.println("=================================================");
		}
		return null;
	}

	public Invoice searchInoive() {
		System.out.println("Enter the invoice number to show all details: ");
		int searchInput = invoiceSc.nextInt();
		for (int i = 0; i < invoices.size(); i++) {
			if (searchInput == invoices.get(i).getInvoiceNumber()) {
				System.out.println("=======================================");
				System.out.println("Name: " + invoices.get(i).getName());
				System.out.println("Phone Number: " + invoices.get(i).getPhoneNumber());
				System.out.println("Total Balance: " + invoices.get(i).getTotalAmount());
				System.out.println("=======================================");
			}
		}
		return null;
	}
}
