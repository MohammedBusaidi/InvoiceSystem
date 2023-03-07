import java.util.*;
public class Menue {
	Scanner menueSc = new Scanner(System.in);
	ShopManager shopManager = new ShopManager();
	Invoice invoice = new Invoice();
	void  showMenue() {
		
		boolean menueLoop = true;
	    while(menueLoop) {
	    	System.out.println("==== Groceries Shop Management System ====");
		    System.out.println("1. Manage Shop Settings");
		    System.out.println("2. Manage Shop Items");
		    System.out.println("3. Create New Invoice ");
		    System.out.println("4. Statistics");
		    System.out.println("5. All Invoices");
		    System.out.println("6. Search ");
		    System.out.println("7. Program Statistics");
		    System.out.println("8. Exit");
		    System.out.println("==========================================");
		    System.out.print("Enter your choice: ");
      
	      int choice = menueSc.nextInt();
	    	  switch(choice) {
		      	case 1:
		      		showSubShopSetting();
		      		break;
		      	
		      	case 2:
		      		showSubShopItem();
		      		break;
		
		      	case 3:
		      		createInvoice();
		          	break;
		          	
		      	case 4:
		          	break;
		          	
		      	case 5:
		          	break;
		          	
		      	case 6:
		          	break;
		          	
		      	case 7:
		          	break;
		          	
		      	case 8:
		      		System.out.println("Are you sure you want to exit?");
		      		String exitOption = menueSc.next();
		      		if(exitOption.equalsIgnoreCase("Y") || exitOption.equalsIgnoreCase("yes")) {
		      			System.out.println("GOOD BYE");
		      			menueLoop = false;
		      			break;
					}
		      		else if(exitOption.equalsIgnoreCase("N") || exitOption.equalsIgnoreCase("no")) {
		      			showMenue();
	      		}
	      }
		}
	   }
	Scanner userSc = new Scanner(System.in);
	void showSubShopSetting() {
		boolean subShopSettingLoop = true;
		while (subShopSettingLoop) {
			System.out.println("1. Load Data");
			System.out.println("2. Set Shop Name");
			System.out.println("3. Set Invoice Header");
			System.out.println("4. Go Back");
		
			int shopSettingInput = userSc.nextInt();
			switch(shopSettingInput) {
				case 1://load data
					break;
				case 2:
					System.out.println("Enter Shop Name: ");
					String shopNameInput = userSc.next();
					shopManager.setShopName(shopNameInput);
					break;
				case 3: shopManager.setInvoice();
					break;
				case 4: subShopSettingLoop = false;
					break;
			}
		}
	}
	
	void showSubShopItem() {
		boolean subShopItemLoop = true;
		while(subShopItemLoop) {
			System.out.println("1. Add Items");
			System.out.println("2. Delete Items");
			System.out.println("3. Change Item Price");
			System.out.println("4. Report All Items");
			System.out.println("5. Go Back");
			
			int shopItemInput = userSc.nextInt();
		
			
			switch(shopItemInput) {
			case 1:
				shopManager.addItem();
				break;
			case 2:
				shopManager.removeItem();
				break;
			case 3:
				shopManager.changePrice();
				break;
			case 4:
				shopManager.printAllItems();
				break;
			case 5: subShopItemLoop = false;
				break;
			}
		}
	}
	
	void createInvoice() {
		invoice.createInvoice();
	}
	         
		
}
