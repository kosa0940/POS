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

	//Adds Products to shoop list
	public void addProductToShoppingCart(Product p)
	{
		if(p.getName().equals("error")==false){
		if ( products.contains(p))
		{
			p.incrementQuantity();
		}
		else
		{
			products.add(p);
		}
		sumOfPrices+=p.getPrice();
		}
	}

	public double getSumOfPrices() {
		return sumOfPrices;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	
}
