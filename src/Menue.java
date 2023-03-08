import java.util.*;
public class Menue {
	Scanner menueSc = new Scanner(System.in);
	static ShopManager shopManager = new ShopManager();
	Invoice invoice = new Invoice();
	void  showMenue() {
		
		boolean menueLoop = true;
	    while(menueLoop) {
	    	HashMap<Integer, String> menuOptions = new HashMap<Integer, String>();
	        menuOptions.put(1, "Manage Shop Settings");
	        menuOptions.put(2, "Manage Shop Items");
	        menuOptions.put(3, "Create New Invoice");
	        menuOptions.put(4, "Statistics");
	        menuOptions.put(5, "All Invoices");
	        menuOptions.put(6, "Search");
	        menuOptions.put(7, "Program Statistics");
	        menuOptions.put(8, "Exit");
	        
	        int choice = 0;
	        
	        while (choice != 8) {
	            System.out.println("==== Groceries Shop Management System ====");
	            for (int i = 1; i <= 8; i++) {
	                System.out.println(i + ". " + menuOptions.get(i));
	            }
	            System.out.println("==========================================");
	            System.out.print("Enter your choice: ");
	            choice = menueSc.nextInt();
      
	    	  switch(choice) {
		      	case 1:
		      		shopSettingsCount = shopSettingsCount +1;
		      		showSubShopSetting();
		      		break;
		      	
		      	case 2:
		      		shopItemCount = shopItemCount + 1;
		      		showSubShopItem();
		      		break;
		
		      	case 3:
		      		newInvoiceCount = newInvoiceCount + 1;
		      		shopManager.createInvoice();
		          	break;
		          	
		      	case 4:
		      		statCount = statCount + 1;
		      		shopManager.reportStat();
		          	break;
		          	
		      	case 5:
		      		allInvoicesCount = allInvoicesCount + 1;
		      		shopManager.printInvoice();
		          	break;
		          	
		      	case 6:
		      		searchCount = searchCount + 1;
		      		shopManager.searchInoive();
		      		
		          	break;
		          	
		      	case 7:
		      		programStatCount = programStatCount + 1;
		      		programStat();
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
				case 1:
					loadDataCount = loadDataCount +1;
					//load data
					break;
				case 2:
					setShopNameCount = setShopNameCount +1;
					System.out.println("Enter Shop Name: ");
					String shopNameInput = userSc.next();
					shopManager.setShopName(shopNameInput);
					break;
				case 3:
					setInvoiceHeaderCount = setInvoiceHeaderCount + 1;
					shopManager.setInvoice();
					break;
				case 4: 
					goBackCount1 = goBackCount1 + 1;
					subShopSettingLoop = false;
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
				addItemsCount = addItemsCount + 1;
				shopManager.addItem();
				break;
			case 2:
				removeItemsCount = removeItemsCount + 1;
				shopManager.removeItem();
				break;
			case 3:
				changeItemPriceCount = changeItemPriceCount + 1;
				shopManager.changePrice();
				break;
			case 4:
				reportAllItemsCount = reportAllItemsCount + 1;
				shopManager.printAllItems();
				break;
			case 5: 
				goBackCount2 = goBackCount2 + 1;
				subShopItemLoop = false;
				break;
			}
		}
	}
	
	int shopSettingsCount = 0;
	int loadDataCount = 0;
	int setShopNameCount = 0;
	int setInvoiceHeaderCount = 0;
	int goBackCount1 = 0;
	int shopItemCount = 0;
	int addItemsCount = 0;
	int removeItemsCount = 0;
	int changeItemPriceCount = 0;
	int reportAllItemsCount = 0;
	int goBackCount2 = 0;
	int newInvoiceCount = 0;
	int statCount = 0;
	int allInvoicesCount = 0;
	int searchCount = 0;
	int programStatCount = 0;
	
	
	public void programStat() {
	
	System.out.println("Manage Shop Settings ---> " + shopSettingsCount);
	System.out.println("		Load Data ---> " + loadDataCount);
	System.out.println("		Set Shop Name ---> " + setShopNameCount);
	System.out.println("		Set Invoice Header ---> " + setInvoiceHeaderCount);
	System.out.println("		Go Back ---> " + goBackCount1);
	System.out.println("Manage Shop Items ---> " + shopItemCount);
	System.out.println("		Add Items ---> " + addItemsCount);
	System.out.println("		Remove Items ---> " + removeItemsCount);
	System.out.println("		Change Item Price ---> " + changeItemPriceCount);
	System.out.println("		Report All Items ---> " + reportAllItemsCount);
	System.out.println("		Go Back ---> " + goBackCount2);
	System.out.println("Create New Invoice ---> " + newInvoiceCount);
	System.out.println("Statistics ---> " + statCount);
	System.out.println("All Invoices ---> " + allInvoicesCount);
	System.out.println("Search ---> " + searchCount);
	System.out.println("Program Statistics ---> " + programStatCount);
}
		
}
