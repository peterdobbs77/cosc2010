//---------------------------------------------------------------------
// GolfApp2.java           by Dale/Joyce/Weems                Chapter 8
//
// Allows user to enter golfer name and score information.
// Displays information ordered by score.
//----------------------------------------------------------------------
package ch08;

import java.util.Scanner;

import support.Golfer; // Golfer
import ch08.trees.BSTInterface;
import ch08.trees.BinarySearchTree;

public class GolfApp2 {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);

		String name; // golfer's name
		int score; // golfer's score

		BSTInterface<Golfer> golfers = new BinarySearchTree<Golfer>();
		Golfer golfer;
		int numGolfers;

		System.out.print("Golfer name (press Enter to end): ");
		name = conIn.nextLine();
		while (!name.equals("")) {
			System.out.print("Score: ");
			score = conIn.nextInt();
			conIn.nextLine();

			golfer = new Golfer(name, score);
			golfers.add(golfer);

			System.out.print("Golfer name (press Enter to end): ");
			name = conIn.nextLine();
		}
		System.out.println();
		System.out.println("The final results are");

		numGolfers = golfers.reset(BinarySearchTree.INORDER);
		for (int count = 1; count <= numGolfers; count++) {
			System.out.println(golfers.getNext(BinarySearchTree.INORDER));
		}
		conIn.close();
	}
}