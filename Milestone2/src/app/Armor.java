package app;

/**
 * Armor product to be bought and sold
 */
public class Armor extends SalableProduct {
	/**
	 * Value of Armor protection
	 */
	private int protection;
	
	/**
	 * Constructs Armor object with given name, description, price, quantity, and protection values
	 * @param name name of Armor item
	 * @param description description of armor item
	 * @param price price of Armor item
	 * @param quantity quantity of Armor item
	 * @param protection protection value of Armor item
	 */
	public Armor(String name, String description, double price, int quantity, int protection) {
		super(name, description, price, quantity);
		// TODO Auto-generated constructor stub
		this.protection = protection;
	}

	/**
	 * Gets protection value
	 * @return the protection
	 */
	public int getProtection() {
		return protection;
	}

	/**
	 * Sets protection value
	 * @param protection the protection to set
	 */
	public void setProtection(int protection) {
		this.protection = protection;
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
		Armor product = (Armor)other;
		return(super.equals(other) && this.protection == product.protection);
	}
	
	/**
	 * Converts Armor data to a String
	 */
	@Override
	public String toString() {
		return super.toString() + "Damage: " + this.protection + "\n";
	}
}
