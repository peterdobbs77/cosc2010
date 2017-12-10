package assign5;

public class TestTree {

	public static void main(String[] args) {
		System.out.println("********************\n" + "* Tree Test Driver *\n"
				+ "********************");

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(50);
		tree.add(40);
		tree.add(30);
		tree.add(45);
		tree.add(60);
		tree.add(90);
		tree.add(80);
		tree.add(100);

		System.out.println("\nForward Tree:");
		tree.printSideways();

		System.out.println("Second largest element of tree: "
				+ tree.getSecondLargest());
		System.out.println("Height of binary tree: " + tree.height());
		System.out.println("Print Paths:");
		tree.printPaths();

		BinarySearchTree<Integer> rev = tree.reverse();
		System.out.println("\nReverse Tree:");
		rev.printSideways();
	}
}