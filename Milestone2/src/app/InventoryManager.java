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
	 * Gets inventory of SalableProducts
	 * @return the salableProducts
	 */
	public ArrayList<SalableProduct> getSalableProducts() {
		return salableProducts;
	}

	/**
	 * Sets inventory of SalableProducts
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
			if (this.salableProducts.get(i).equals(salableProduct)) {
				System.out.println(salableProduct.getName() + " already in inventory. Please update quantity.");
				return;
			}
		}
		
		this.salableProducts.add(salableProduct);
		return;
	}
	
	/**
	 * completely removes a salableProduct from inventory 
	 * @param salableProduct name of salableProduct to remove from inventory
	 */
	public void removeProduct(SalableProduct salableProduct) {
		for(int i = 0; i < this.salableProducts.size(); i++) {
			if (this.salableProducts.get(i).equals(salableProduct)) {
				this.salableProducts.remove(i);
				System.out.println(salableProduct.getName() + " removed from inventory.");
				return;
			}
		}
		
		System.out.println("Product not in inventory.");
		return;
	}
	
	/**
	 * updates the quantity of an existing salableProduct in inventory
	 * @param salableProduct name of product to adjust the quantity of
	 * @param quantity quantity to update product with
	 */
	public void updateQuantity(SalableProduct salableProduct, int quantity) {
		if(quantity < 0) {
			System.out.println("Cannot insert quantity less than 0");
			return;
		}
		
		for(int i = 0; i < this.salableProducts.size(); i++) {
			if (this.salableProducts.get(i).equals(salableProduct)) {
				this.salableProducts.get(i).setQuantity(quantity);
				System.out.println("Product " + salableProduct.getName() + " quantity changed to " + quantity + ".");
				return;
			}
		}
		
		System.out.println(salableProduct.getName() + " not in inventory.");
		return;
	}
	
	/**
	 * Converts SalableProduct data to a String
	 */
	@Override
	public String toString() {
		if(this.salableProducts.get(0).equals(null)) {
			return "Inventory is empty";
		}
		
		String output = this.salableProducts.get(0).toString();
		for(int i = 1; i < this.salableProducts.size(); i++) {
			output = output + "\n" + this.salableProducts.get(i).toString();
		}
		return output;
	}
}
