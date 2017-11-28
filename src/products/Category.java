package products;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Category {

	private static final AtomicInteger count = new AtomicInteger(0); 
	private int idCategory;
	
	public ArrayList<Product> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}


	private String nameOfCategory;
	private String description;
	private ArrayList<Product> products = new ArrayList<>();
	
	
	public Category(int idCategory, String nameOfCategory, String description) {
		idCategory = count.incrementAndGet(); 
		this.nameOfCategory = nameOfCategory;
		this.description = "None";
	}
	
	
	public Category(String nameOfCategory) {
	
		idCategory = count.incrementAndGet(); 
		this.nameOfCategory = nameOfCategory;
		this.description = "None";
	}
	
	
	
	public Category(int idCategory, String nameOfCategory) {
		super();
		this.idCategory = idCategory;
		this.nameOfCategory = nameOfCategory;
	}
	
	

	
	public void addNewProductProduct(Product prod){
		products.add(prod);
	}
	
	
	
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameOfCategory() {
		return nameOfCategory;
	}
	public void setNameOfCategory(String nameOfCategory) {
		this.nameOfCategory = nameOfCategory;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public void getAllElements(){
		
		for (Product item : products) {   

			System.out.println(item.getName());
		}

	}
	
	public void getElementFromCategory(){
		
		for (Product item : products)
		{
			System.out.println(item.getName());
		}


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
