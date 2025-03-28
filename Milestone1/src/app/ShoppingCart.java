package app;

import java.util.ArrayList;

/**
 * temporarily stores SalableProducts for User to purchase
 */
public class ShoppingCart {
	/**
	 * list of SalableProducts temporarily stored in ShoppingCart
	 */
	private ArrayList<SalableProduct> items;
	
	/**
	 * StoreFront associated with this ShoppingCart
	 */
	private StoreFront storeFront;
	
	/**
	 * total cost of all SalableProducts in cart
	 */
	private double totalCost;
	
	/**
	 * constructs a ShoppingCart with given StoreFront
	 * @param storeFront storeFront to set
	 */
	public ShoppingCart(StoreFront storeFront) {
		this.items = new ArrayList<SalableProduct>();
		this.storeFront = storeFront;
		this.totalCost = 0.0;
	}
	
	/**
	 * adds one instance of salableProduct to cart
	 * @param salableProduct salable product to add to cart
	 */
	public void addItem(String salableProduct) {

		int inventoryStockQty = 0;
		int inventoryIndex = -1;
		boolean productExists = false;
		SalableProduct newProduct = null;
		
		// ensure product exists and has inventory
		for(int i = 0; i < storeFront.getInventoryManager().getSalableProducts().size(); i++) {
			if(storeFront.getInventoryManager().getSalableProducts().get(i).getName().equals(salableProduct)) {
				inventoryStockQty = storeFront.getInventoryManager().getSalableProducts().get(i).getQuantity();
				inventoryIndex = i;
				productExists = true;
				break;
			}
		}
		if (!productExists) {
			System.out.println(salableProduct + " is not in inventory");
			return;
		}
		if (inventoryStockQty <= 0) {
			System.out.println(salableProduct + " is out of stock");
			return;
		}
				
		// check if product is already in cart
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(salableProduct)) {
				// check if inventory has item
				if (items.get(i).getQuantity() == inventoryStockQty) {
					System.out.println(salableProduct + " is out of stock");
					return;
				}
				
				items.get(i).setQuantity(items.get(i).getQuantity() + 1);
				System.out.println(salableProduct + " added to cart. Qty: " + items.get(i).getQuantity());
				totalCost += storeFront.getInventoryManager().getSalableProducts().get(inventoryIndex).getPrice(); 
				return;
			}
		}
		
		// if product is not already in cart, create and add product to cart.
		newProduct = new SalableProduct(salableProduct, 
				storeFront.getInventoryManager().getSalableProducts().get(inventoryIndex).getDescription(),
				storeFront.getInventoryManager().getSalableProducts().get(inventoryIndex).getPrice(),
				1);
		items.add(newProduct);
		totalCost += storeFront.getInventoryManager().getSalableProducts().get(inventoryIndex).getPrice();
		System.out.println(salableProduct + " added to cart. Qty: 1");
	}
	
	public void removeItem(String salableProduct) {
		// check if item is in cart
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(salableProduct)) {
				// check if only 1 instance of product left. If so, remove product from items
				if(items.get(i).getQuantity() == 1) {
					totalCost -= items.get(i).getPrice();
					items.remove(i);
					System.out.println(salableProduct + " removed from cart.");
					return;
				}
				
				// if more than 1 instance of product in cart, decrement.
				totalCost -= items.get(i).getPrice();
				items.get(i).setQuantity(items.get(i).getQuantity() - 1);
				
				System.out.println(items.get(i).getQuantity() 
						+ " instance(s) left of " + salableProduct + " in cart.");
				return;
			}
		}
		
		// if no instance is in cart, let user know
		System.out.println("No instance of " + salableProduct + " in cart.");
	}
	
	/**
	 * remove correct quantity from store inventory and empty cart
	 */
	public void checkout() {
		for(int i = items.size() - 1; i >= 0; i--) {
			storeFront.purchaseProduct(items.get(i).getName(), items.get(i).getQuantity());		
			items.remove(i);
		}
		System.out.printf("Grand total: $%.2f\n", totalCost);
		totalCost = 0.0;
	}
}
