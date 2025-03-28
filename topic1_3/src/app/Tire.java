package app;

public class Tire {
	/**
	 * Default psi set in the tire constructor
	 */
	final static int DEFAULT_TIRE_PSI = 35;
	
	/**
	 * This tires pressure in pounds per square inch (psi)
	 */
	private int psi;
	
	/**
	 * Constructs Tire with the default psi
	 */
	public Tire() {
		this.psi = DEFAULT_TIRE_PSI;
	}

	/**
	 * @param psi
	 */
	public Tire(int psi) {
		this.psi = psi;
	}

	/**
	 * @return the psi
	 */
	public int getPsi() {
		return psi;
	}

	/**
	 * @param psi the psi to set
	 */
	public void setPsi(int psi) {
		if(psi < 0 || psi > 199) {
			System.out.println("ERROR: Tire psi cannot exceed 199 or fall below 0");
			return;
		}
		this.psi = psi;
	}
	

}
