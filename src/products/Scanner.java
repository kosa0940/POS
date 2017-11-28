package products;

import Csv.IGetDataBaseContent;

import java.util.ArrayList;

public class Scanner {
	private ReadCsvFile rcf;
	private ArrayList<Product> products;
	private boolean barcodeFound;

	private ArrayList<Category> categories = new ArrayList<>();
	public Scanner(ReadCsvFile rcf) {
		this.rcf = rcf;
	}
	public boolean isBarcodeFound() {
		return barcodeFound;
	}

	//Searching for barcode match in my dataBase now stored which im placing in products array and it's searched category
	// after category, return a product
	public Product searchBarcode(int barcode)
	{
		barcodeFound=false;
		categories = rcf.getCategories();
		Product p = null;
		for (Category item : categories)
		{
			products = item.getProducts();
			
			for ( int i=0; i<products.size(); i++)
			{
				if ( barcode == products.get(i).getBarcode()  )
				{
					System.out.println("Znaleziono " + products.get(i).getName());
					p = products.get(i);
					barcodeFound=true;
					break;
				}
			
			}
		}
		if(barcodeFound==false) {System.out.println("Nie znaleziono produktu");
		p = new Product(0,"error",0,0);

		}
		return p;
	}
}
