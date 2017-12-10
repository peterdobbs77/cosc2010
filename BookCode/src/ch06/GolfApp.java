//---------------------------------------------------------------------
// GolfApp.java           by Dale/Joyce/Weems                 Chapter 6
//
// Allows user to enter golfer name and score information.
// Displays information ordered by score.
//----------------------------------------------------------------------
package ch06;

import java.util.Scanner;

import support.Golfer; // Golfer
import ch06.lists.ArraySortedList;
import ch06.lists.ListInterface;

public class GolfApp {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		String name; // golfer's name
		int score; // golfer's score
		ListInterface<Golfer> golfers = new ArraySortedList<Golfer>(20);
		Golfer golfer;

		System.out.print("Golfer name (press Enter to end): ");
		name = conIn.nextLine();
		while (!name.equals("")) {
			System.out.print("Score: ");
			score = conIn.nextInt();
			conIn.nextLine(); // skip

			golfer = new Golfer(name, score);
			golfers.add(golfer);

			System.out.print("Golfer name (press Enter to end): ");
			name = conIn.nextLine();
		}
		System.out.println();
		System.out.println("The final results are");
		System.out.println(golfers);
		conIn.close();
	}
}