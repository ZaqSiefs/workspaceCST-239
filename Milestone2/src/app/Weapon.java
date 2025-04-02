package app;

/**
 * Weapon product to be bought and sold
 */
public class Weapon extends SalableProduct {
	/**
	 * Value of Weapon damage
	 */
	private int damage;
	
	/**
	 * Constructs Weapon object with given name, description, price, quantity, and damage;
	 * @param name name of Weapon item
	 * @param description description of Weapon item
	 * @param price price of Weapon item
	 * @param quantity quantity of Weapon item
	 * @param damage damage of Weapon item
	 */
	public Weapon(String name, String description, double price, int quantity, int damage) {
		super(name, description, price, quantity);
		this.damage = damage;
	}

	/**
	 * Gets damage value
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * Sets damage value
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
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
		Weapon product = (Weapon)other;
		return(super.equals(other) && this.damage == product.damage);
	}
	
	/**
	 * Converts Weapon data to a String
	 */
	@Override
	public String toString() {
		return super.toString() + "Damage: " + this.damage + "\n";
	}
}
