package products;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;

import java.util.ArrayList;

public class ReadCsvFile{
	File file;
	private String nameOfCategory = "";
	private ArrayList<Category> categories;

	StringBuilder sb = new StringBuilder();

	public ReadCsvFile(File file) {
		this.file = file;

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

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

					//System.out.println(barcode);

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

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	public void getAllElementsFromCategories() {

		for (Category item : categories) {

			item.getAllElements();
		}

	}

}