package products;

import java.io.*;
import java.util.ArrayList;

public class ReadCsvFile{


	 File file;
	private String nameOfCategory = "";
	private ArrayList<Category> categories;

	public ReadCsvFile(File file) {
		this.file = file;

	}
//Reads my csv DataBase
	public void readMyCsvFile() {

		ArrayList<String> helpItems = new ArrayList<>();
		categories = new ArrayList<>();
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		int lines = 0;

		try {

			br = new BufferedReader(new FileReader(file.getPath()));
			while ((line = br.readLine()) != null) {

				if (lines > 0) {

					String[] country = line.split(csvSplitBy);
					String categoryName = country[0];
					String barcode = country[2];
					String name = country[1];
					String price = country[3];

					if (helpItems.contains(categoryName)) {
						nameOfCategory = categoryName;
					} else {

						Category c = new Category(categoryName);
						categories.add(c);
						nameOfCategory = categoryName;
						helpItems.add(categoryName);

					}

					Product p = new Product(Integer.parseInt(barcode), name, Double.parseDouble(price));

					for (Category item : categories) {

						if (nameOfCategory.equals(item.getNameOfCategory())) {
							item.addNewProductProduct(p);
							break;
						}
					}

				}
				lines++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

}