import java.io.*;
public class loadFromFile {
	static ShopManager addItems = new ShopManager();
	public void loadFromFile(String filename) {
		 try {
		        BufferedReader reader = new BufferedReader(new FileReader(filename));
		        String line = null;
		        while ((line = reader.readLine()) != null) {
		            String[] fields = line.split(",");
		            String itemId = fields[0];
		            String itemName = fields[1];
		            double itemPrice = Double.parseDouble(fields[2]);
		            int itemQuantity = Integer.parseInt(fields[3]);

		            Item item = new Item(itemId, itemName, itemPrice, itemQuantity);
		            addItems.addItem(item);
		        }
		        reader.close();
		    } catch (IOException e) {
		        System.err.println("Error loading items from file: " + e.getMessage());
		    }
		
	}
	
}
