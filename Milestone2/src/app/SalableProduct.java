package app;

import java.text.DecimalFormat;

/**
 * General product to be stored and sold by StoreFront
 */
public class SalableProduct {
	/**
	 * Decimal formatter for toString method
	 */
	private static DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * product name
	 */
	private String name;
	
	/**
	 * product description
	 */
	private String description;
	
	/**
	 * product price (in USD)
	 */
	private double price;
	
	/**
	 * product quantity
	 */
	private int quantity;
	
	/**
	 * Constructs SalableProduct object with given name, description, price, and quantity
	 * @param name product name
	 * @param description product description
	 * @param price product price (in USD)
	 * @param quantity product quantity
	 */
		public SalableProduct(String name, String description, double price, int quantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * Gets name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets description
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets price
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets price
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets quantity
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets quantity
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	
	/**
	 * Compares SalableProduct to passed object
	 * @param other other object being compared
	 * @return returns true if objects are the same, false if not
	 */
	@Override
	public boolean equals(Object other) {
		if(other == this) {
			return true;
		}
		if(other == null) {
			return false;
		}
		if(getClass() != other.getClass()) {
			return false;
		}
		SalableProduct product = (SalableProduct)other;
		return(this.name == product.name && this.description == product.description && this.price == product.price);
	}
	
	/**
	 * Converts SalableProduct data to a String
	 */
	@Override
	public String toString() {
		return "Name: " + this.name + "\nDescription: " + this.description 
				+ "\nPrice: $" + df.format(price) + "\nQuantity: " + this.quantity + "\n";
	}
}

