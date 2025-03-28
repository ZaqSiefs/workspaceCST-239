package app;

public class Engine {
	/**
	 * the on/off status
	 */
	private boolean isOn;
	
	/**
	 * Constructs Engine with default off status
	 */
	public Engine() {
		this.isOn = false;
	}
	
	/**
	 * Constructs Engine with given on/off status
	 */
	public Engine(boolean isOn) {
		this.isOn = isOn;
	}

	/**
	 * @return the on/off status
	 */
	public boolean isOn() {
		return isOn;
	}
	
	/**
	 * turns engine on
	 */
	public void turnOn() {
		this.isOn = true;
	}
	
	/**
	 * turns engine off
	 */
	public void turnOff() {
		this.isOn = false;
	}
}
