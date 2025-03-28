package app;

public class RaceCarGame {
	/**
	 * runs the race car game
	 * @param args
	 */
	public static void main(String[] args) {
		// create a car
		Car car = new Car();
		// ensure car has an engine and 4 tires
		if (car.getEngine() == null) {
			System.out.println("car has no engine");
		} 
		else {
			System.out.println("car has engine");
		}
		
		if (car.getTires() == null) {
			System.out.println("car has no tires");
		}
		else {
			System.out.println("car has " + car.getTires().length + " tires");
		}
		System.out.println();
		
		// ensure car engine can be started and stopped
		System.out.println("engine starts " + (car.getEngine().isOn() ? "on" : "off"));
		car.start();
		System.out.println("after engine is started, engine is " + (car.getEngine().isOn() ? "on" : "off"));
		car.stop();
		System.out.println("after engine is stopped, engine is " + (car.getEngine().isOn() ? "on" : "off"));
		System.out.println();
		
		// ensure car can start, move, stop, start again
		car.start();
		System.out.println("car is " + (car.getEngine().isOn() ? "on" : "off"));
		car.setSpeed(20);
		System.out.println("car is moving at " + car.getSpeed() + " mph");
		car.setSpeed(0);
		System.out.println("car is moving at " + car.getSpeed() + " mph");
		car.stop();
		System.out.println("car is " + (car.getEngine().isOn() ? "on" : "off"));
		car.start();
		System.out.println("car is " + (car.getEngine().isOn() ? "on" : "off"));
		car.stop();
		System.out.println("car is " + (car.getEngine().isOn() ? "on" : "off"));
		
	}

}
