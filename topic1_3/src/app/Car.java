package app;

public class Car {
	/**
	 * default number of tires on the car
	 */
	final static int CAR_TIRE_COUNT = 4;
	
	/**
	 * default maximum speed of car
	 */
	final static int MAX_SPEED = 60;
	
	/**
	 * tires on the car
	 */
	private Tire[] tires;
	
	/**
	 * engine in the car
	 */
	private Engine engine;
	
	/**
	 * speed of the Car in miles per hour
	 */
	private int speed;
	
	/**
	 * constructs a Car with 4 tires, an engine that is off, and parked 
	 */
	public Car() {
		tires = new Tire[CAR_TIRE_COUNT];
		for(int i = 0; i < CAR_TIRE_COUNT; i++) {
			tires[i] = new Tire();
		}
		engine = new Engine();
		speed = 0;
	}
	
	/**
	 * constructs a Car with given tires and engine
	 * @param tires
	 * @param engine
	 */
	public Car(Tire[] tires, Engine engine) {
		if(tires.length != CAR_TIRE_COUNT) {
			System.out.println("ERROR: Car must have " + CAR_TIRE_COUNT + " tires.");
			return;
		}
		
		this.tires = tires;
		this.engine = engine;
		
		// cannot create a car that is already moving
		speed = 0;
	}

	/**
	 * @return the tires
	 */
	public Tire[] getTires() {
		return tires;
	}

	/**
	 * @param tires the tires to set
	 */
	public void setTires(Tire[] tires) {
		this.tires = tires;
	}

	/**
	 * @return the engine
	 */
	public Engine getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		if(this.getEngine().isOn() == false) {
			System.out.println("ERROR: car cannot move unless engine is turned on");
		}
		if(speed > MAX_SPEED || speed < 0) {
			System.out.println("ERROR: car speed cannot exceed " + MAX_SPEED + " or fall below 0");
			return;
		}
		this.speed = speed;
	}
	
	/**
	 * turns car on
	 */
	public void start() {
		for (int i = 0; i < this.tires.length; i++) {
			if (this.tires[i].getPsi() < 32) {
				System.out.println("ERROR: cannot start car unless ALL tires are over 32 psi");
				return;
			}
		}
		this.engine.turnOn();
	}
	
	/**
	 * turns car off
	 */
	public void stop() {
		if (this.speed != 0) {
			System.out.println("ERROR: cannot turn off engine while car is moving");
			return;
		}
		this.engine.turnOff();
	}
	
}
