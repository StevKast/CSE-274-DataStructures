/**
 * A binary tree implementation. When adding values to
 * a tree, there is no assumed "correct" location for that value.
 * So, we will give the root package access, so that we can manually
 * build our trees from a tester class.
 * 
 * @author Norm Krumpe
 *
 */

public class BinaryTree {
	
	Node root;
		
	/**
	 * Returns the height of this tree
	 * @return
	 */
	public int getHeight() {
		return getHeight(root);
	}
	
	private int getHeight(Node n){
		if(n == null){
			return 0;
		}
		return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
	}
	
	//Public method the user would call
	public int getNumberOfNodes() {
		return getNumberOfNodes(root);
	}
	
	//Private recursive method to do all the work
	//We pass in some node as a root
	private int getNumberOfNodes(Node n){
		if(n == null){
			return 0;
		}else{
			return getNumberOfNodes(n.left) + getNumberOfNodes(n.right) + 1;
		}
		
	}
	
	public int getNumberOfLeaves() {
		return getNumberOfLeaves(root);
	}
	
	private int getNumberOfLeaves(Node n){
		if(n == null){
			return 0;
		}else if(n.left == null && n.right == null){
			return 1;
		}
		return getNumberOfLeaves(n.left) + getNumberOfLeaves(n.right);
	}
	
	/**
	 * Prints the preorder traversal of this tree
	 */
	public void preorderTraversal() {
		preorderTraversal(root);
		System.out.println();
	}
	
	private void preorderTraversal(Node n){
		if(n != null){
			System.out.print(n.data + " ");
			preorderTraversal(n.left);
			preorderTraversal(n.right);
		}
	}
	
	/**
	 * Prints the inorder traversal of this tree
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
		System.out.println();
	}
	
	private void inorderTraversal(Node n){
		if(n != null){
			preorderTraversal(n.left);
			System.out.print(n.data + " ");
			preorderTraversal(n.right);
		}
	}
	
	/**
	 * Prints the postorder traversal of this tree
	 */
	public void postorderTraversal() {
		postorderTraversal(root);
		System.out.println();
	}
	
	private void postorderTraversal(Node n){
		if(n != null){
			preorderTraversal(n.left);
			preorderTraversal(n.right);
			System.out.print(n.data + " ");
		}
	}
	
	public boolean isFull() {
		if(Math.pow(2, getHeight()) - 1 == getNumberOfNodes()){
			return true;
		}
		return false;
	}
	
	public boolean contains(int value) {
		return contains(root, value);
	}
	
	private boolean contains(Node n, int value){
		if(n == null){
			return false;
		}else if(n.data ==  value){
			return true;
		}else{
			return contains(n.left, value) || contains(n.right, value);
		}
	}
	
	public int getMin() {
		return getMin(root);
	}
	
	private int getMin(Node n){
		if(n == null){
			return 0;
		}else if(getNumberOfNodes() == 1){
			return n.data;
		}else{
			return Math.min(getMin(n.left), getMin(n.right));
		}
	}

}
