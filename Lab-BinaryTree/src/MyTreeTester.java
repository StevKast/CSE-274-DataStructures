
public class MyTreeTester {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		
		bt.root = new Node(6);
		bt.root.left = new Node(1);
		bt.root.right = new Node(5);
		bt.root.right.right = new Node(7);
		
		System.out.println(bt.getNumberOfNodes());
		bt.preorderTraversal();
		System.out.println();
		bt.inorderTraversal();
		System.out.println();
		bt.postorderTraversal();
		

	}

}
