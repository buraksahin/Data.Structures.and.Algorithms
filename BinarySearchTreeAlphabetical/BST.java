
public class BST {

	// - Variables - //
	Node node;

	public BST() {
	}

	// - Insert keyValue to Binary Search Tree - //
	// - KeyValue(int Key, String Value)
	// - KeyValue -> Node - //
	public void insert(KeyValue keyV){
		if(node==null){
			node = new Node(keyV);
		}
		if(keyV.value.compareTo(node.keyV.value)>0){
			node = new Node(node.keyV, node.left, insert(keyV, node));
		}
		if(keyV.value.compareTo(node.keyV.value)<0){
			node = new Node(node.keyV, insert(keyV, node),node.right);
		}
	}

	public static Node insert(KeyValue keyV, Node node){
		if(node == null){
			node = new Node(keyV);
		}
		if(keyV.value.compareTo(node.keyV.value)>0){
			node = insert(keyV, node.right);
		}
		if(keyV.value.compareTo(node.keyV.value)<0){
			node = insert(keyV,node.left);
		}
		return node;
	}

	// - Delete KeyValue - //
	// - Key -> Node - //
	public void delete(String value){
		if(node.keyV.value == value){
			delete(node, value);
		}
		if(node.keyV.value.compareTo(value)<0){
			delete(node.right,value);
		}
		if(node.keyV.value.compareTo(value)>0){
			delete(node.left,value);
		}
	}

	public static void delete(Node node,String value){
		if(node.keyV.value.compareTo(value)<0){
			delete(node.right,value);
		}
		if(node.keyV.value.compareTo(value)>0){
			delete(node.left,value);
		}
		if(value==node.keyV.value){
			Node n = findMin(node.right);
			node = new Node(n.keyV,node.left,node.right);
		}
	}

	// - Find Minimum Value From BST - //
	public static Node findMin(Node node){

		if(node.left==null){
			Node n = node;
			node = null;
			return n;

		}
		else{
			return findMin(node.left);
		}
	}
}
