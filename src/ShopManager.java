import java.util.*;

public class ShopManager {
    private String shopName;
    private String shopAddress;
    private List<Item> items;

    public ShopManager() {
        this.items = new ArrayList<>();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void updateItem(Item item) {
        // Find the index of the item in the list
        int index = items.indexOf(item);

        if (index != -1) {
            // Replace the item with the updated item
            items.set(index, item);
        }
    }
}
