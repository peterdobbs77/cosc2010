package ch08;

import ch08.trees.BinarySearchTree;

public class TestTree {

	public static void main(String[] args) {

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(50);
		tree.add(40);
		tree.add(30);
		tree.add(45);
		tree.add(60);
		tree.add(90);
		tree.add(80);
		tree.add(100);
		tree.add(35);
		tree.add(35);

		tree.printSideways();

		tree.printLeaves();

		System.out.println("Occurences of 50: " + tree.count(50));
		System.out.println("Occurences of 35: " + tree.count(35));

		// System.out.println("The leftmost descendant is: "
		// + tree.leftmostDescendant());
		// System.out.println("The rightmost descendant is: "
		// + tree.rightmostDescendant());
		//
		// int treeSizeInorder = tree.reset(BinarySearchTree.INORDER);
		// System.out.println("The tree in Inorder is:"); // gives sorted
		// for (int count = 1; count <= treeSizeInorder; count++) {
		// int element = (Integer) tree.getNext(BinarySearchTree.INORDER);
		// System.out.println(element);
		// }
	}
}