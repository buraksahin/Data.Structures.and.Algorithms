
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
		if(keyV.key>node.keyV.key){
			node = new Node(node.keyV, node.left, insert(keyV, node));
			System.out.println("KeyValue: "+keyV.key);
		}
		if(keyV.key<node.keyV.key){
			node = new Node(node.keyV, insert(keyV, node),node.right);
			System.out.println("KeyValue: "+keyV.key);
		}
	}
	
	public static Node insert(KeyValue keyV, Node node){
		if(node == null){
			node = new Node(keyV);
		}
		if(keyV.key>node.keyV.key){
			node = insert(keyV, node.right);
		}
		if(keyV.key<node.keyV.key){
			node = insert(keyV,node.left);
		}
		return node;
	}
	
	// - Delete KeyValue - //
	// - Key -> Node - //
	public void delete(int key){
		if(node.keyV.key == key){
			delete(node, key);
		}
		if(key > node.keyV.key){
			delete(node.right,key);
		}
		if(key < node.keyV.key){
			delete(node.left,key);
		}
	}
	
	public static void delete(Node node,int key){
		if(key > node.keyV.key){
			delete(node.right,key);
		}
		if(key < node.keyV.key){
			delete(node.left,key);
		}
		if(key==node.keyV.key){
			Node n = findMin(node.right);
			node = new Node(n.keyV,node.left,node.right);
		}
	}
	
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
