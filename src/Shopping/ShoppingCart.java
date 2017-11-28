package Shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import products.Product;

public class ShoppingCart {

	private double sumOfPrices =0.0;
	public ArrayList<Product> products = new ArrayList<>();
	public ShoppingCart() {
	
	}

	
	
	/*
	 *  
	 * sprawdzenie czy nowo dodawany produkt znajduej sie juz w liscie produktow
	 *  JESLI TAK - to inkrementujemy po prostu jego ilosc,a cena jest wyliczana automatycznie 
	 *  czyli dla tego przypadku bedzie p.incrementQuantity()
	 *  JESLI NIE - dodajemy normalnei produkt do shopping cart
	 */
	public void addProductToShoppingCart(Product p)
	{
		if(p.getName().equals("error")==false){
		if ( products.contains(p))
		{
			p.incrementQuantity();
			//sumOfPrices = p.getQuantity()*p.getPrice();
		}
		else
		{
			products.add(p);
			//sumOfPrices += p.getPrice();
		}
		sumOfPrices+=p.getPrice();
		}
	}




	public double getSumOfPrices() {
		return sumOfPrices;
	}


	public void setSumOfPrices(double sumOfPrices) {
		this.sumOfPrices = sumOfPrices;
	}


	public ArrayList<Product> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
	
	
}
