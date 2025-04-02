package app;

import java.util.Random;

public class Game {

	public static void main(String[] args) {
		// create a random health between 1 and 1000
		Random rand = new Random();
		int health1 = rand.ints(1,(1000 + 1)).findFirst().getAsInt();
		int health2 = rand.ints(1,(1000 + 1)).findFirst().getAsInt();
		
		// create Superman and Batman
		System.out.println("Creating our Super Heroes......");
		Superman superman = new Superman(health1);
		Batman batman = new Batman(health2);
		System.out.println("Super Heroes created");
		
		// run the game until one of the super heroes is dead
		
		System.out.println("Running our game......");
		while(!superman.isDead() && !batman.isDead()) {
			// attack each other
			superman.attack(batman);
			batman.attack(superman);
			
			// see if anyone survived
			if(superman.isDead()) {
				System.out.println("Batman defeated Superman");
			}
			
			if(batman.isDead()) {
				System.out.println("Superman defeated Batman");
			}
		}
	}

}
