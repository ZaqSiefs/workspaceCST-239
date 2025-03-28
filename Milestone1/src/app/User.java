package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * User class that handles the logic for setting up the project and the user interface
 */
public class User {
	/**
	 * buffer scanner to take input from the user
	 */
	private static Scanner userInput = new Scanner(System.in);
	
	/**
	 * main function that runs the User interface
	 */
	public static void main(String[] args) {
		// Create products
		SalableProduct product1 = new SalableProduct("Cookie box", "12 Chocolate chip cookies", 10.99, 3);
		SalableProduct product2 = new SalableProduct("Milk", "Gallon of 2% milk", 4.30, 2);
		SalableProduct product3 = new SalableProduct("Eggs", "Carton of 12 eggs", 5.59, 1);
		
		// Create product list and add products to list
		ArrayList<SalableProduct> list = new ArrayList<SalableProduct>();
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		// Create store and initialize with list
		StoreFront store = new StoreFront(list);
		
		// Create shopping cart and associate it with the store
		ShoppingCart cart = new ShoppingCart(store);
		
		// Prompt user
		int userChoice = 0;
		int userQuantity = 0;
		String userProduct = null;
		while(true) {
			System.out.println("What would you like to do?");
			System.out.println("(1) Add an item to cart");
			System.out.println("(2) Remove an item from cart");
			System.out.println("(3) Checkout cart");
			System.out.println("(4) Purchase item directly from store");
			System.out.println("(5) Quit");
			userChoice = userInput.nextInt();
			userInput.nextLine();
			
			// Handle improper input
			if(userChoice < 1 || userChoice > 5) {
				System.out.println("Invalid input. Please select a number from 1 to 5.");
				continue;
			}
			if(userChoice == 1) {
				System.out.println("What item would you like to add to cart?");
				userProduct = userInput.nextLine();
				cart.addItem(userProduct);
				continue;
			}
			if (userChoice == 2) {
				System.out.println("What item would you like to remove from cart?");
				userProduct = userInput.nextLine();
				cart.removeItem(userProduct);
				continue;
			}
			if (userChoice == 3) {
				System.out.println("Checking out");
				cart.checkout();
				continue;
			}
			if (userChoice == 4) {
				System.out.println("What item would you like to purchase?");
				userProduct = userInput.nextLine();
				System.out.println("How many of these items would you like to purchase?");
				userQuantity = userInput.nextInt();
				userInput.nextLine();
				store.purchaseProduct(userProduct, userQuantity);
				continue;
			}
			if (userChoice == 5) {
				System.out.println("Thanks for shopping!");
				break;
			}
		}
	}

}
