
public class Tester {

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.add("apple");
		bst.add("aardvark");
		bst.add("house");
		bst.add("cat");
		bst.add("argon");
		bst.add("dog");
		bst.add("giraffe");
		bst.add("zoo");
		bst.inorderTraversal();
		
		bst.remove("cat");
		bst.inorderTraversal();		

//		bst.inorderTraversal();
//		bst.remove("house");
//		bst.inorderTraversal();
//		bst.remove("mouse");
//		bst.inorderTraversal();
//		bst.remove("aa");
//		bst.inorderTraversal();
		
	}

}
