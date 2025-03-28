package app;

/**
 * General product to be stored and sold by StoreFront
 */
public class SalableProduct {
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
	 * constructs SalableProduct with given name, description, price, and quantity
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
