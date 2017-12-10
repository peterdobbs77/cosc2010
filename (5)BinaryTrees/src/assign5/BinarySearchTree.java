//----------------------------------------------------------------------------
// BinarySearchTree.java          by Dale/Joyce/Weems                Chapter 8
//
// Defines all constructs for a reference-based BST
//----------------------------------------------------------------------------

package assign5;

public class BinarySearchTree<T extends Comparable<T>> implements
		BSTInterface<T> {
	protected BSTNode<T> root; // reference to the root of this BST

	boolean found; // used by remove

	// for traversals
	protected LinkedUnbndQueue<T> inOrderQueue; // queue of info
	protected LinkedUnbndQueue<T> preOrderQueue; // queue of info
	protected LinkedUnbndQueue<T> postOrderQueue; // queue of info

	public BinarySearchTree()
	// Creates an empty BST object.
	{
		root = null;
	}

	public boolean isEmpty()
	// Returns true if this BST is empty; otherwise, returns false.
	{
		return (root == null);
	}

	private int recSize(BSTNode<T> tree)
	// Returns the number of elements in tree.
	{
		if (tree == null)
			return 0;
		else
			return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
	}

	public int size()
	// Returns the number of elements in this BST.
	{
		return recSize(root);
	}

	public int size2()
	// Returns the number of elements in this BST.
	{
		int count = 0;
		if (root != null) {
			LinkedStack<BSTNode<T>> hold = new LinkedStack<BSTNode<T>>();
			BSTNode<T> currNode;
			hold.push(root);
			while (!hold.isEmpty()) {
				currNode = hold.top();
				hold.pop();
				count++;
				if (currNode.getLeft() != null)
					hold.push(currNode.getLeft());
				if (currNode.getRight() != null)
					hold.push(currNode.getRight());
			}
		}
		return count;
	}

	private boolean recContains(T element, BSTNode<T> tree)
	// Returns true if tree contains an element e such that
	// e.compareTo(element) == 0; otherwise, returns false.
	{
		if (tree == null)
			return false; // element is not found
		else if (element.compareTo(tree.getInfo()) < 0)
			return recContains(element, tree.getLeft()); // Search left subtree
		else if (element.compareTo(tree.getInfo()) > 0)
			return recContains(element, tree.getRight()); // Search right
															// subtree
		else
			return true; // element is found
	}

	public boolean contains(T element)
	// Returns true if this BST contains an element e such that
	// e.compareTo(element) == 0; otherwise, returns false.
	{
		return recContains(element, root);
	}

	public boolean isLeaf(BSTNode<T> tree) {
		return (tree.getRight() == null && tree.getLeft() == null);
	}

	private T recGet(T element, BSTNode<T> tree)
	// Returns an element e from tree such that e.compareTo(element) == 0;
	// if no such element exists, returns null.
	{
		if (tree == null)
			return null; // element is not found
		else if (element.compareTo(tree.getInfo()) < 0)
			return recGet(element, tree.getLeft()); // get from left subtree
		else if (element.compareTo(tree.getInfo()) > 0)
			return recGet(element, tree.getRight()); // get from right subtree
		else
			return tree.getInfo(); // element is found
	}

	public T get(T element)
	// Returns an element e from this BST such that e.compareTo(element) == 0;
	// if no such element exists, returns null.
	{
		return recGet(element, root);
	}

	private BSTNode<T> recAdd(T element, BSTNode<T> tree)
	// Adds element to tree; tree retains its BST property.
	{
		if (tree == null)
			// Addition place found
			tree = new BSTNode<T>(element);
		else if (element.compareTo(tree.getInfo()) <= 0)
			// Add in left subtree
			tree.setLeft(recAdd(element, tree.getLeft()));
		else
			// Add in right subtree
			tree.setRight(recAdd(element, tree.getRight()));
		return tree;
	}

	public void add(T element)
	// Adds element to this BST. The tree retains its BST property.
	{
		root = recAdd(element, root);
	}

	private T getPredecessor(BSTNode<T> tree)
	// Returns the information held in the rightmost node in tree
	{
		while (tree.getRight() != null)
			tree = tree.getRight();
		return tree.getInfo();
	}

	private BSTNode<T> removeNode(BSTNode<T> tree)
	// Removes the information at the node referenced by tree.
	// The user's data in the node referenced by tree is no
	// longer in the tree. If tree is a leaf node or has only
	// a non-null child pointer, the node pointed to by tree is
	// removed; otherwise, the user's data is replaced by its
	// logical predecessor and the predecessor's node is removed.
	{
		T data;

		if (tree.getLeft() == null)
			return tree.getRight();
		else if (tree.getRight() == null)
			return tree.getLeft();
		else {
			data = getPredecessor(tree.getLeft());
			tree.setInfo(data);
			tree.setLeft(recRemove(data, tree.getLeft()));
			return tree;
		}
	}

	private BSTNode<T> recRemove(T element, BSTNode<T> tree)
	// Removes an element e from tree such that e.compareTo(element) == 0
	// and returns true; if no such element exists, returns false.
	{
		if (tree == null)
			found = false;
		else if (element.compareTo(tree.getInfo()) < 0)
			tree.setLeft(recRemove(element, tree.getLeft()));
		else if (element.compareTo(tree.getInfo()) > 0)
			tree.setRight(recRemove(element, tree.getRight()));
		else {
			tree = removeNode(tree);
			found = true;
		}
		return tree;
	}

	public boolean remove(T element)
	// Removes an element e from this BST such that e.compareTo(element) == 0
	// and returns true; if no such element exists, returns false.
	{
		root = recRemove(element, root);
		return found;
	}

	private void inOrder(BSTNode<T> tree)
	// Initializes inOrderQueue with tree elements in inOrder order.
	{
		if (tree != null) {
			inOrder(tree.getLeft());
			inOrderQueue.enqueue(tree.getInfo());
			inOrder(tree.getRight());
		}
	}

	private void preOrder(BSTNode<T> tree)
	// Initializes preOrderQueue with tree elements in preOrder order.
	{
		if (tree != null) {
			preOrderQueue.enqueue(tree.getInfo());
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	private void postOrder(BSTNode<T> tree)
	// Initializes postOrderQueue with tree elements in postOrder order.
	{
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			postOrderQueue.enqueue(tree.getInfo());
		}
	}

	public int reset(int orderType)
	// Initializes current position for an iteration through this BST
	// in orderType order. Returns current number of nodes in the BST.
	{
		int numNodes = size();

		if (orderType == INORDER) {
			inOrderQueue = new LinkedUnbndQueue<T>();
			inOrder(root);
		} else if (orderType == PREORDER) {
			preOrderQueue = new LinkedUnbndQueue<T>();
			preOrder(root);
		}
		if (orderType == POSTORDER) {
			postOrderQueue = new LinkedUnbndQueue<T>();
			postOrder(root);
		}
		return numNodes;
	}

	public T getNext(int orderType)
	// Preconditions: The BST is not empty
	// The BST has been reset for orderType
	// The BST has not been modified since the most recent reset
	// The end of orderType iteration has not been reached
	//
	// Returns the element at the current position on this BST for orderType
	// and advances the value of the current position based on the orderType.
	{
		if (orderType == INORDER)
			return inOrderQueue.dequeue();
		else if (orderType == PREORDER)
			return preOrderQueue.dequeue();
		else if (orderType == POSTORDER)
			return postOrderQueue.dequeue();
		else
			return null;
	}

	/**
	 * Calls a recursive function to print the tree
	 */
	public void printSideways() {
		printSideways(root, "");
	}

	/**
	 * Recursively traverses the tree in order to print the tree
	 * 
	 * @param tree
	 *            current node of the tree
	 * @param indent
	 *            compounding indentation to separate the nodes
	 */
	private void printSideways(BSTNode<T> tree, String indent) {
		if (tree != null) {
			printSideways(tree.getRight(), indent + "    ");
			System.out.println(indent + tree.getInfo());
			printSideways(tree.getLeft(), indent + "    ");
		}
	}

	/**
	 * Calls a recursive function to print the tree's leaves
	 */
	public void printLeaves() {
		printLeaves(root);
	}

	/**
	 * Recursively traverses the tree in order to print the leaves
	 * 
	 * @param tree
	 *            current node of the tree
	 */
	private void printLeaves(BSTNode<T> tree) {
		if (tree != null) {
			printLeaves(tree.getLeft());
			printLeaves(tree.getRight());
			if (tree.isLeaf())
				System.out.println(tree.getInfo());
		}
	}

	/**
	 * Calls a recursive function to print the paths from root to leaves
	 */
	public void printPaths() {
		printPaths(root, "");
	}

	/**
	 * Recursively traverses the tree in order to print the path from root to
	 * leaves
	 * 
	 * @param tree
	 *            current node in the tree
	 * @param path
	 *            compounding path of the tree from root to leaf
	 */
	private void printPaths(BSTNode<T> tree, String path) {
		if (tree != null) {
			if (tree.isLeaf())
				System.out.println(path + " " + tree.getInfo());
			printPaths(tree.getLeft(), path + " " + tree.getInfo());
			printPaths(tree.getRight(), path + " " + tree.getInfo());
		}
	}

	/**
	 * Calls a recursive function to find the leftmost descendant of the tree's
	 * root
	 * 
	 * @return returns the leftmost descendant of the tree's root
	 */
	public T leftmostDescendant() {
		if (root == null)
			return null;
		return leftmostDescendant(root);
	}

	/**
	 * Recursively traverses the left nodes of the tree to find the leftmost
	 * node
	 * 
	 * @param tree
	 *            current node of the tree
	 * @return returns the leftmost descendant node
	 */
	private T leftmostDescendant(BSTNode<T> tree) {
		if (tree.getLeft() == null)
			return tree.getInfo();
		return (leftmostDescendant(tree.getLeft()));
	}

	/**
	 * Calls a recursive function to find the rightmost descendant of the tree's
	 * root
	 * 
	 * @return returns the rightmost descendant of the tree's root
	 */
	public T rightmostDescendant() {
		if (root == null)
			return null;
		return rightmostDescendant(root);
	}

	/**
	 * Recursively traverses the right nodes of the tree to find the rightmost
	 * node
	 * 
	 * @param tree
	 *            current node of the tree
	 * @return returns the rightmost descendant node
	 */
	private T rightmostDescendant(BSTNode<T> tree) {
		if (tree.getRight() == null)
			return tree.getInfo();
		return (rightmostDescendant(tree.getRight()));
	}

	/**
	 * Calls a recursive function to find the number of occurrences of an input
	 * element in a tree
	 * 
	 * @param element
	 *            input to compare to
	 * @return number of occurrences of the input element
	 */
	public int count(T element) {
		return count(element, root);
	}

	/**
	 * Recursively traverses the tree to find occurrences of an input element,
	 * O(n)
	 * 
	 * @param element
	 *            comparison object
	 * @param tree
	 *            current node in the tree
	 * @return returns 1 if node is occurrence of element, 0 otherwise
	 */
	private int count(T element, BSTNode<T> tree) {
		int result = 0;
		if (tree != null) {
			if (element.compareTo(tree.getInfo()) == 0)
				result++;
			result += count(element, tree.getLeft());
			result += count(element, tree.getRight());
		}
		return result;
	}

	/**
	 * Calls a recursive function to find the number of occurrences of an input
	 * element in a tree
	 * 
	 * @param element
	 *            input to compare to
	 * @return number of occurrences of the input element
	 */
	public int count2(T element) {
		return count2(element, root);
	}

	/**
	 * Recursively traverses the tree to find occurrences of an input element,
	 * O(log(n))
	 * 
	 * @param element
	 *            comparison object
	 * @param tree
	 *            current node in the tree
	 * @return returns 1 if node is occurrence of element, 0 otherwise
	 */
	private int count2(T element, BSTNode<T> tree) {
		int result = 0;
		if (tree != null) {
			if (element.compareTo(tree.getInfo()) == 0)
				result++;
			if (element.compareTo(tree.getInfo()) <= 0)
				result += count(element, tree.getLeft());
			if (element.compareTo(tree.getInfo()) > 0)
				result += count(element, tree.getRight());
		}
		return result;
	}

	/**
	 * Traverses the tree inOrder until the second to last element, O(n)
	 * 
	 * @return returns the second largest element of the tree
	 */
	public T getSecondLargest() {
		T element = null;
		if (root != null && (root.getLeft() != null || root.getRight() != null)) {
			int treeSizeInorder = this.reset(BinarySearchTree.INORDER);
			for (int count = 1; count <= treeSizeInorder - 1; count++) {
				element = this.getNext(BinarySearchTree.INORDER);
			}
		}
		return element;
	}

	/**
	 * 
	 * @return returns the height of the tree, from root to farthest leaf from
	 *         root
	 */
	public int height() {
		return height(root);
	}

	/**
	 * Recursively loops through the tree from root to farthest leaf
	 * 
	 * @param tree
	 *            current node in the binary search tree
	 * @return returns height of the tree
	 */
	private int height(BSTNode<T> tree) {
		if (tree != null) {
			int left = height(tree.getLeft());
			int right = height(tree.getRight());

			if (left > right) {
				return ++left;
			} else {
				return ++right;
			}
		}
		return -1;
	}

	/**
	 * Calls a recursive function to reverse the tree about the root node
	 * 
	 * @return mirror image about the BinarySearchTree root
	 */
	public BinarySearchTree<T> reverse() {
		BinarySearchTree<T> temp = new BinarySearchTree<T>();
		temp.root = copy(root);
		temp.reverse(temp.root);
		return temp;
	}

	/**
	 * Recursively traverses the tree to switch the left and right nodes of each
	 * node
	 * 
	 * @param tree
	 *            current node of the tree
	 * @return returns the tree with each successive node having reversed left
	 *         and right nodes
	 */
	private BinarySearchTree<T> reverse(BSTNode<T> tree) {
		if (tree != null) {
			BSTNode<T> tempRight = tree.getRight();
			tree.setRight(tree.getLeft());
			tree.setLeft(tempRight);
			reverse(tree.getLeft());
			reverse(tree.getRight());
		}
		return null;
	}

	/**
	 * Creates a clone of the input BSTNode object
	 * 
	 * @param node
	 *            object to clone
	 * @return clone of the object
	 */
	private BSTNode<T> copy(BSTNode<T> node) {
		if (node != null) {
			BSTNode<T> temp = new BSTNode<T>(node.getInfo());
			temp.setLeft(node.getLeft());
			temp.setRight(node.getRight());
			return temp;
		}
		return null;
	}
}
