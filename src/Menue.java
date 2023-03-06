import java.util.*;
public class Menue {
	Scanner menueSc = new Scanner(System.in);
	ShopManager shopManager = new ShopManager();
	void  showMenue() {
     boolean menueLoop = true;
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
      while(menueLoop) {
    	  switch(choice) {
	      	case 1: showManageShopMenue();
	      		break;
	      	
	      	case 2:
	      		break;
	
	      	case 3:
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
	}}
	
	void showManageShopMenue() {
		Scanner userInput = new Scanner(System.in);
		boolean shopMenueLoop = true;
		while (shopMenueLoop) {
			System.out.println("1. Load Data");
			System.out.println("2. Set Shop Name");
			System.out.println("3. Set Invoice Header");
			System.out.println("4. Go Back");
		
			int shopMenueInput = menueSc.nextInt();
		
			if(shopMenueInput == 1) {
			}
			else if (shopMenueInput == 2) {
				System.out.println("Enter Shop Name: ");
				shopManager.setShopName(null);
				
			}
			else if (shopMenueInput == 3) {
				
			}
			else if (shopMenueInput == 4) {
				shopMenueLoop = false;
			}
		}
	}
	         
		
}
