package products;

//Helping class for Category class keeps information bout Products itself
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
	public String getName() {
		return name;
	}
	public int getBarcode() {
		return barcode;
	}
	public double getPrice() {
		return this.price;
	}

}
