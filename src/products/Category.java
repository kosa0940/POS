package products;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Category {

	private static final AtomicInteger count = new AtomicInteger(0);
	private int idCategory;
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	private String nameOfCategory;
	private String description;
	private ArrayList<Product> products = new ArrayList<>();


	public Category(String nameOfCategory) {
	
		idCategory = count.incrementAndGet(); 
		this.nameOfCategory = nameOfCategory;
		this.description = "None";
	}

	public void addNewProductProduct(Product prod){
		products.add(prod);
	}

	public String getNameOfCategory() {
		return nameOfCategory;
	}

	public String toString() {
		if (description == null)
		{
			return "Category name=" + nameOfCategory + "\n  Description : None" ;
		}
		else
			return "Category name=" + nameOfCategory + "\n  Description :"
			+ description;
	}
	
}
