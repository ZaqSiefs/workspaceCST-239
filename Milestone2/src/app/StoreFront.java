package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * handles purchasing SalableProducts from an InventoryManager
 */
public class StoreFront {
	/**
	 * buffer scanner to take input from the user
	 */
	private static Scanner userInput = new Scanner(System.in);
	
	/**
	 * InventoryManager for this store
	 */
	private InventoryManager inventoryManager;
	
	/**
	 * Constructs StoreFront object with a blank InventoryManager
	 */
	public StoreFront() {
		inventoryManager = new InventoryManager();
	}
	
	/**
	 * Constructs StoreFront object with given given InventoryManager
	 * @param products products in inventory
	 */
	public StoreFront(ArrayList<SalableProduct> products) {
		inventoryManager = new InventoryManager();
		inventoryManager.setSalableProducts(products);
	}
	
	/**
	 * Gets InventoryManager
	 * @return the inventoryManager
	 */
	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}

	/**
	 * Sets InventoryManager
	 * @param inventoryManager the inventoryManager to set
	 */
	public void setInventoryManager(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
	}

	/**
	 * Initializes the inventory for StoreFront
	 * @param storeInventory inventory to use for initialization
	 */
	public void initializeStore(ArrayList<SalableProduct> storeInventory) {
		this.inventoryManager.setSalableProducts(storeInventory);
	}
	
	/**
	 * Removes correct quantity of product instance from inventory
	 * @param product product instance to remove quantity from inventory
	 * @param quantity quantity of product instance to remove from inventory
	 */
	public void purchaseProduct(String product, int quantity) {
		for (int i = 0; i < inventoryManager.getSalableProducts().size(); i++) {
			if(inventoryManager.getSalableProducts().get(i).getName().equals(product)) {
				// make sure quantity is valid
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
	public void sellProduct(String product, int quantity) {
		for (int i = 0; i < inventoryManager.getSalableProducts().size(); i++) {
			if(inventoryManager.getSalableProducts().get(i).getName().equals(product)) {
				inventoryManager.getSalableProducts().get(i).setQuantity(
						inventoryManager.getSalableProducts().get(i).getQuantity() + quantity);
				System.out.println(quantity + " " + product + "(s) returned");
				return;
			}
			else {
				System.out.println("Sorry, we do not purchase that item.");
			}
		}
	}
	
	/**
	 * main method to run user interface
	 * @param args args for main
	 */
	public static void main(String[] args) {
		// Create products and add to inventory
		SalableProduct product1 = new Weapon("Axe", "Two handed, melee", 20.67, 3, 10);
		SalableProduct product2 = new Weapon("Sword", "One handed, melee", 13.99, 13, 5);
		SalableProduct product3 = new Armor("Full Plate", "Heavy Armor, Clumsy", 99.99, 1, 4);
		SalableProduct product4 = new Armor("Leather Guard", "Light Armor, Silent", 45.33, 6, 2);
		SalableProduct product5 = new Health("Medium Healing Potion", "Consumable", 75.89, 2, 15);
		SalableProduct product6 = new SalableProduct("Adventuring Gear", "Gear for adventuring", 5.25, 20);
		ArrayList<SalableProduct> inventory = new ArrayList<SalableProduct>();
		inventory.add(product1);
		inventory.add(product2);
		inventory.add(product3);
		inventory.add(product4);
		inventory.add(product5);
		inventory.add(product6);
		
		// Create store with inventory
		StoreFront store = new StoreFront(inventory);
		
		// User interface
		int userChoice = 0;
		int userQuantity = 0;
		String userProduct = null;
		
		System.out.println("Welcome to the shop!");
		while(true) {
			System.out.println("What would you like to do?");
			System.out.println("(1) Purchase Item");
			System.out.println("(2) Sell Item");
			System.out.println("(3) Exit");
			userChoice = userInput.nextInt();
			userInput.nextLine();
			
			// Handle improper input
			if(userChoice < 1 || userChoice > 3) {
				System.out.println("Invalid input. Please select a number from 1 to 3.");
				continue;
			}
			if(userChoice == 1) {
				System.out.println("What item would you like to purchase?");
				System.out.println(store.inventoryManager.toString());
				userProduct = userInput.nextLine();
				System.out.println("How many?");
				userQuantity = userInput.nextInt();
				userInput.nextLine();
				store.purchaseProduct(userProduct, userQuantity);
				continue;
			}
			if (userChoice == 2) {
				System.out.println("What item would you like to sell?");
				System.out.println(store.inventoryManager.toString());
				userProduct = userInput.nextLine();
				System.out.println("How many?");
				userQuantity = userInput.nextInt();
				userInput.nextLine();
				store.sellProduct(userProduct, userQuantity);
				continue;
			}
			if (userChoice == 3) {
				System.out.println("Thanks for shopping!");
				break;
			}
		}
	}
}
