package app;

public class Test {

	public static void main(String[] args) {
		// create new Person objects
		Person person1 = new Person("Justine", "Reha");
		Person person2 = new Person("Brianna", "Reha");
		Person person3 = new Person(person1);
		
		// test object equality
		if(person1 == person2) {
			System.out.println("These persons are identical using ==");
		}
		else {
			System.out.println("These persons are not identical using ==");
		}
		
		// test object equality
		if(person1.equals(person2)) {
			System.out.println("These persons are identical using equals()");
		}
		else {
			System.out.println("These persons are not identical using equals()");
		}
		
		// test copy constructor
		if(person1.equals(person3)) {
			System.out.println("The copied person is identical using equals()");
		}
		else {
			System.out.println("The copied person is not identical using equals()");
		}		
		
		// print the objects
		System.out.println(person1);
		System.out.println(person2.toString());
		System.out.println(person3);
	}

}
