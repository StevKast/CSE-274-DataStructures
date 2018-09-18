
public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	/*
	 * Returns the maximum value in the tree.
	 */
	public String max(){
		if(root == null){
			return null;
		}
		return max(root).data;
	}

	/*
	 * Returns the node containing the maximum
	 * value of tree whose root is start.
	 * Algorithm: Keep going to the right until
	 * there is no right.
	 */
	private Node max(Node start){

		if(start == null){
			return null;
		}

		while(start.right != null){
			start = start.right;
		}

		return start;
	}

	/*
	 * Returns the minimum value in the tree.
	 */
	public String min(){
		if(root == null){
			return null;
		}
		return min(root).data;
	}

	/*
	 * Returns the node containing the minimum
	 * value of tree whose root is start.
	 * Algorithm: Keep going to the left until
	 * there is no right.
	 */
	private Node min(Node start){

		if(start == null){
			return null;
		}

		while(start.left != null){
			start = start.left;
		}

		return start;
	}

	/*
	 * Adds the specified node to the BST
	 */
	public String add(String s) {

		// root is a special case:
		if (root == null) {
			root = new Node(s);
			return s;
		}

		Node current = root;

		while (current != null) {
			if (current.data.equals(s)) // no duplicates
				return s;
			else if (current.data.compareTo(s) > 0) { // go left
				if (current.left == null) { // found nothing? Add node here
					current.left = new Node(s);
				} else {
					current = current.left;
				}
			} else { // go right
				if (current.right == null) { // found nothing? Add node here
					current.right = new Node(s);
				} else {
					current = current.right;
				}
			}
		}
		return s;
	}

	/*
	 * Returns true if the string is found in the BST
	 */
	public boolean contains(String s) {

		Node current = root;

		while (current != null) {
			if (current.data.equals(s))
				return true;
			if (current.data.compareTo(s) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		// Made it here? Not found!
		return false;
	}
	
	/*
	 * Returns true if the string is found a given BST
	 */
	public boolean contains(String s, Node root) {

		Node current = root;

		while (current != null) {
			if (current.data.equals(s))
				return true;
			if (current.data.compareTo(s) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		// Made it here? Not found!
		return false;
	}

	/*
	 * Removes the specified string from the BST
	 */
	public boolean remove(String s) {

		System.out.println("Removing: " + s);

		if(root == null)
			return false; //empty tree

		if(!contains(s))
			return false; //not in tree

		//Root to be removed.
		if(s.equals(root.data)){
			//Handle easy cases first
			//Does root have 0 or 1 children
			if(root.left == null || root.right == null){
				//Set root to either null or the appropriate subtree
				root = root.left == null ? root.right: root.left;
				return true;
			}

			//At this point we know s is in the root, and
			//root has 2 children
			//Find the max of left subtree:
			Node maxNode = max(root.left);
			root.data = maxNode.data;
			maxNode = null;

			return true;
		}else { //Not root
			Node current = root;
			Node parent = current;

			//Find node
			while (current.left != null && current.right != null) {
				parent = current; //Keeps track of parent
				if (current.data.equals(s))
					break;
				if (current.data.compareTo(s) > 0) {
					current = current.left;
				} else {
					current = current.right;
				}
			}

			//If it has 0 or 1 child
			if(current.left == null || current.right == null){

				//If it is a leaf
				if(current.left == null && current.right == null){
					if(parent.left == current){
						parent.left = null;
						return true;
					}else if(parent.right == current){
						parent.right = null;
						return true;

					}
				}

				//If it has one child
				if(parent.left == current){
					parent.left = current.left == null ? current.right: current.left;
					return true;
				}else if(parent.right == current) {
					parent.right = current.left == null ? current.right: current.left;
					return true;
				}

				//Has 2 children and is not root.
			}else if(current.left != null && current.right != null){

				//If it has 2 children
				
				if(contains(s, root.left)){
					
					Node maxNode = max(current);
					Node maxParent = current;
					
					current.data = maxNode.data;
					
					//Remove old leaf
					while(maxParent.right != null){
						maxParent = maxParent.right;
					}
					maxParent.right = null;

					return true;
				}else if(contains(s, root.right)){
					
					Node minNode = min(current);
					Node minParent = current;
					
					current.data = minNode.data;

					//Remove old leaf
					while(minParent.right != null){
						minParent = minParent.right;
					}
					minParent.right = null;
					return true;
				}

			}

		}

		return false; //Everything fails

	}

	/*
	 * Prints the values in order
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
		System.out.println();
	}

	/*
	 * Recursive helper for traversing
	 */
	private void inorderTraversal(Node n) {
		if (n != null) {
			inorderTraversal(n.left);
			System.out.print(n.data + " ");
			inorderTraversal(n.right);
		}
	}

	/*
	 * Basic Binary Tree Node
	 */
	private class Node {
		private String data;
		private Node left, right;

		private Node(String data) {
			this.data = data;
			left = right = null;
		}
	}
}
