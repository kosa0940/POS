package Shopping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import products.Product;
import java.io.*;
import java.util.StringTokenizer;

public class Receipt {

	ShoppingCart sc;
	String now;
	
	private ArrayList<Product> products = new ArrayList<>();
	private StringBuilder sb = new StringBuilder();
	public Receipt(ShoppingCart sc)
	{
		this.sc=sc;
	}
	public String readyReceipt;
	
	//Preparing receipte look
	public void prepareRecepit()
	{
		products = sc.getProducts();
		Date date = new Date();
		sb.append("\t\tPawel Kosnica sp. z. o. o.\n\t\t02-776 Warszawa\n\t\tStrzeleckiego 4\36\n\t\tImpaq\n\t\tNIP 012-314-2134-32\n \n\t" + date.toString() + "\n \n \n\t\tPodsumowanie\n \n");
		for ( Product i : products)
		{
			sb.append("\n\tNazwa produktu: " + i.getName() + "\tCena: "  +  i.getPrice());
		}
		double roundOff = Math.round(sc.getSumOfPrices() * 100.0) / 100.0;
		sb.append("\n\nLaczna suma zakupow: " + roundOff + " zl.");
		readyReceipt = sb.toString();
	}
	
	public String getReceipt()
	{
		return sb.toString();
	}

	//Saving txt receipt on hdd
	public void saveReceipt(){

		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy-HH-mm-ss");
			Date now = new Date();
			PrintWriter pr = new PrintWriter(dateFormat.format(now)+".txt");
			StringTokenizer st = new StringTokenizer(getReceipt().toString(),"\n");
			while(st.hasMoreTokens()){
				pr.print(st.nextToken());
				pr.println(" ");
			}
			pr.close();
		}catch(IOException e){e.getMessage();}
	}

}
