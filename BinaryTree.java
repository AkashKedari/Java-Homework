
public class BinaryTree {
	
	Node root; // create new node and initialize it 
	
	public void addNode (int key,String name) {	// build the binary tree 
		
		Node newNode = new Node (key,name);
		
		if (root == null) {
			
			root = newNode; // if there is no value for root, assign new node 
			
		} else {
			
			Node focusNode = root;
			
			Node parent;
			
			while(true){
				
				parent = focusNode;
				
				if(key < focusNode.Key) { //add to left
					
					focusNode = focusNode.leftChild;
					
					if (focusNode == null) {
						
						parent.leftChild = newNode;
						return;
					}
					
				} else { // add to right
					
					focusNode = focusNode.rightChild;
					
					if (focusNode == null) {
						
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}	
	}
	
	public void inOrderTraverseTree (Node focusNode) { // In order
		
		if (focusNode != null) {
			
			// traverse left node 
			
			inOrderTraverseTree(focusNode.leftChild);
			
			System.out.println(focusNode);
			
			//traverse right node
			
			inOrderTraverseTree(focusNode.rightChild);	
			
		}
	}
	
	public void preorderTraverseTree(Node focusNode) { // Preorder Traverse

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node focusNode) { // Post Order

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);

			System.out.println(focusNode);

		}

	}

	public Node findNode(int key) {

		Node focusNode = root; // Start at the top of the tree

		// While we haven't found the Node
		// keep looking

		while (focusNode.Key != key) {

			// If we should search to the left

			if (key < focusNode.Key) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}
	
	
	
	
	public static void main(String[] args) {
		
		BinaryTree theTree = new BinaryTree();

		theTree.addNode(50, "Boss");

		theTree.addNode(25, "Vice President");

		theTree.addNode(15, "Office Manager");

		theTree.addNode(30, "Secretary");

		theTree.addNode(75, "Sales Manager");

		theTree.addNode(85, "Salesman 1");

		// Different ways to traverse binary trees 

		//theTree.inOrderTraverseTree(theTree.root);

		 //theTree.preorderTraverseTree(theTree.root);

		//theTree.postOrderTraverseTree(theTree.root);
		
		

		System.out.println(theTree.findNode(15));

	}
}

class Node {
	
	int Key;
	String name; 
	
	Node leftChild;
	Node rightChild;
	
	Node (int key, String name) {
		this.Key = key;
		this.name = name;
	}
	
	public String toString() {
		return name + " has key " + Key;
	}
		
}





