package app;

/** 
 * Person
 * Created on Mar 18, 2025
 * @author Zachary Siefert
 */
public class Person {
	/**
	 * 
	 */
	private int age;
	/**
	 * This person's name
	 */
	private String name;
	/**
	 * This person's weight
	 */
	private float weight;
	
	/**
	 * Returns the age
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the weight
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * Sets the weight
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	/**
	 * @param age the age of person to set
	 * @param name the name of person to set
	 * @param weight the weight of person to set
	 */
	public Person(int age, String name, float weight) {
		super();
		this.age = age;
		this.name = name;
		this.weight = weight;
	}
	
	
	/**
	 * Walks the person
	 */
	public void walk() {
		System.out.println("I am in walk()");
	}
	
	/**
	 * Runs the person
	 * @param distance the distance to run
	 * @return 0 if method returns successfully
	 */
	public float run(float distance) {
		System.out.println("I am in run()");
		return 0;
	}
	
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		Person person = new Person(24, "Zach", (float) 198.8);
		System.out.println("My name is " + person.getName());
		person.walk();
		person.run(10);
	}

}
