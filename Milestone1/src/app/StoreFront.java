package app;

import java.util.ArrayList;

/**
 * handles purchasing SalableProducts from an InventoryManager
 */
public class StoreFront {
	/**
	 * associated InventoryManager for this store
	 */
	private InventoryManager inventoryManager;
	
	/**
	 * constructs a StoreFront with a blank InventoryManager
	 */
	public StoreFront() {
		inventoryManager = new InventoryManager();
	}
	
	/**
	 * constructs a StoreFront with a given InventoryManager
	 */
	public StoreFront(ArrayList<SalableProduct> products) {
		inventoryManager = new InventoryManager();
		inventoryManager.setSalableProducts(products);
	}
	
	/**
	 * @return the inventoryManager
	 */
	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}

	/**
	 * @param inventoryManager the inventoryManager to set
	 */
	public void setInventoryManager(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
	}

	/**
	 * initializes the inventory for StoreFront
	 * @param storeInventory inventory to use for initialization
	 */
	public void initializeStore(ArrayList<SalableProduct> storeInventory) {
		this.inventoryManager.setSalableProducts(storeInventory);
	}
	
	/**
	 * removes correct quantity of product instance from inventory
	 * @param product product instance to remove quantity from inventory
	 * @param quantity quantity of product instance to remove from inventory
	 */
	public void purchaseProduct(String product, int quantity) {
		for (int i = 0; i < inventoryManager.getSalableProducts().size(); i++) {
			if(inventoryManager.getSalableProducts().get(i).getName().equals(product)) {
				// in cases of purchasing directly through the store, make sure quantity is valid
				if(quantity > inventoryManager.getSalableProducts().get(i).getQuantity()) {
					System.out.println("Only " + inventoryManager.getSalableProducts().get(i).getQuantity()
							+ " " + product + "(s) left. No purchase made.");
					return;
				}
				
				// remove inventory from InventoryManager
				inventoryManager.getSalableProducts().get(i).setQuantity(
						inventoryManager.getSalableProducts().get(i).getQuantity() - quantity);
				
				System.out.println(quantity + " " + product + "(s) purchased");
				return;
			}
		}
	}
	
	/**
	 * returns correct quantity of product instance to inventory
	 * @param product product instance to return quantity to inventory
	 * @param quantity quantity of product instance to return to inventory
	 */
	public void cancelPurchase(String product, int quantity) {
		for (int i = 0; i < inventoryManager.getSalableProducts().size(); i++) {
			if(inventoryManager.getSalableProducts().get(i).getName().equals(product)) {
				inventoryManager.getSalableProducts().get(i).setQuantity(
						inventoryManager.getSalableProducts().get(i).getQuantity() + quantity);
				System.out.println(quantity + " " + product + "(s) returned");
				return;
			}
		}
	}
	
}
