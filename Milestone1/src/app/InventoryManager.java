package app;

import java.util.ArrayList;

/**
 * Manages inventory for the StoreFront
 */
public class InventoryManager {
	/**
	 * inventory of SalableProducts 
	 */
	private ArrayList<SalableProduct> salableProducts;
	
	/**
	 *  constructs new InventoryManager
	 */
	public InventoryManager() {
		salableProducts = new ArrayList<SalableProduct>();
	}
	
	/**
	 * constructs new InventoryManager with given inventory of salable products
	 * @param salableProducts given inventory of salable products
	 */
	public InventoryManager(ArrayList<SalableProduct> salableProducts) {
		this.salableProducts = salableProducts;
	}
	
	/**
	 * @return the salableProducts
	 */
	public ArrayList<SalableProduct> getSalableProducts() {
		return salableProducts;
	}

	/**
	 * @param salableProducts the salableProducts to set
	 */
	public void setSalableProducts(ArrayList<SalableProduct> salableProducts) {
		this.salableProducts = salableProducts;
	}

	/**
	 * puts a new salableProduct into inventory
	 * @param salableProduct new salableProduct to add to inventory
	 */
	public void stockProduct(SalableProduct salableProduct) {
		for(int i = 0; i < this.salableProducts.size(); i++) {
			if (this.salableProducts.get(i).getName().equals(salableProduct.getName())) {
				System.out.println(salableProduct.getName() + " already in inventory. Please update quantity.");
				return;
			}
		}
		
		this.salableProducts.add(salableProduct);
		return;
	}
	
	/**
	 * completely removes a salableProduct from inventory 
	 * @param product name of salableProduct to remove from inventory
	 */
	public void removeProduct(String product) {
		for(int i = 0; i < this.salableProducts.size(); i++) {
			if (this.salableProducts.get(i).getName().equals(product)) {
				this.salableProducts.remove(i);
				System.out.println(product + " removed from inventory.");
				return;
			}
		}
		
		System.out.println("Product not in inventory.");
		return;
	}
	
	/**
	 * updates the quantity of an existing salableProduct in inventory
	 * @param product name of product to adjust the quantity of
	 * @param quantity quantity to update product with
	 */
	public void updateQuantity(String product, int quantity) {
		if(quantity < 0) {
			System.out.println("Cannot insert quantity less than 0");
			return;
		}
		
		for(int i = 0; i < this.salableProducts.size(); i++) {
			if (this.salableProducts.get(i).getName().equals(product)) {
				this.salableProducts.get(i).setQuantity(quantity);
				System.out.println("Product " + product + " quantity changed to " + quantity + ".");
				return;
			}
		}
		
		System.out.println(product + " not in inventory.");
		return;
	}
}
