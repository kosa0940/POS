package products;

public class Product {

	private int quantity;
	private String name; 
	private int barcode; 
	private Double price;

	


	
	public Product(int barcode, String name, double price, int quantity) {
		super();
		this.quantity = quantity;
		this.name = name;
		this.barcode = barcode;
		this.price = price;
	}
	
	public Product(int barcode, String name, double price) {
		super();
		this.quantity = 1;
		this.name = name;
		this.barcode = barcode;
		this.price = price;
	}
	
	
	

	
	
	public void incrementQuantity()
	{
		 quantity++;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	} 
	
	
	
	
	
}
