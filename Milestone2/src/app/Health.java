package app;

/**
 * Health product to be bought and sold
 */
public class Health extends SalableProduct {
	/**
	 * Value of Health regeneration
	 */
	private int regeneration;

	/**
	 * Constructs Health item with given name, description, price, quantity, and regeneration values
	 * @param name name of Health item
	 * @param description description of Health item
	 * @param price price of Health item
	 * @param quantity quantity of Health item
	 * @param regeneration regeneration value of Health item
	 */
	public Health(String name, String description, double price, int quantity, int regeneration) {
		super(name, description, price, quantity);
		this.regeneration = regeneration;
	}

	/**
	 * Gets regeneration value
	 * @return the regeneration
	 */
	public int getRegeneration() {
		return regeneration;
	}

	/**
	 * Sets regeneration value
	 * @param regeneration the regeneration to set
	 */
	public void setRegeneration(int regeneration) {
		this.regeneration = regeneration;
	}

	@Override
	/**
	 * Compares Weapon to passed object
	 * @param other other object being compared
	 * @return returns true if objects are the same, false if not
	 */
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
		Health product = (Health)other;
		return(super.equals(other) && this.regeneration == product.regeneration);
	}
	
	/**
	 * Converts Health data to a String
	 */
	@Override
	public String toString() {
		return super.toString() + "Damage: " + this.regeneration + "\n";
	}
}
