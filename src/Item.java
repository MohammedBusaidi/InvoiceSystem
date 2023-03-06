
public class Item {
	    private Product product;
	    private float quantity;
	    
	    public String getProductName() {
	    	return product.getName();
	    }
	    
	    public int getProductId() {
	    	return product.getId();
	    }
	    
	    public double getProductPrice() {
	    	return product.getPrice();
	    }
	    
	    public float getQuantity() {
	        return quantity;
	    }

	    public double getTotalAmount() {
	        return product.getPrice() * quantity;
	    }
	    
	    public void setProduct(Product product) {
	    	this.product = product;
	    }
	    
	    public void setQuantity(float quantity) {
	    	this.quantity = quantity;
	    }
}


