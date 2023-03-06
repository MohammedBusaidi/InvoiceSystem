
public class InvoiceItem {

	    private Product product;
	    private float quantity;
	    
	    public Product getProductName() {
	    	return product;
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

