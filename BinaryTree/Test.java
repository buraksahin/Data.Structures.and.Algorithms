import java.util.Random;
/**
 * @author BurakSahin
 */
public class Test {


	// - Variables - //
	public static boolean isBS = true;
	public static Random rnd = new Random();


	public static void main(String[] args) {
			new Test().run();
	}

	public void run() {

		//--------------------Node----------------------------//

		Node binarysearchtree = new Node(new KeyValue(15,"Burak"),
						new Node(new KeyValue(6,"A"),new Node(new KeyValue (4,"B")),new Node(new KeyValue(9,"C"))),
						new Node(new KeyValue(26,"D")));

		// - Insert new nodes to Tree - //
		insert(binarysearchtree, new Node(new KeyValue(2,"E")));
		insert(binarysearchtree, new Node(new KeyValue(3,"F")));
		insert(binarysearchtree, new Node(new KeyValue(1,"Z")));
		insert(binarysearchtree, new Node(new KeyValue(10,"L")));
		insert(binarysearchtree, new Node(new KeyValue(16,"X")));
		insert(binarysearchtree, new Node(new KeyValue(14,"Y")));

		//--------------------Tests---------------------------//
		System.out.println("---------------------------------------");
		testBST(binarysearchtree);
		System.out.println("---------------------------------------\n");

		// - GenerateRandomTest(int num, int mem) -> void (Print Tests)
		//   - num: Number of Tests - //
		//   - mem: Member value of a Random Binary Search Tree- //
		GenerateRandomTests(2,100);
		GenerateRandomTests(2,1000);
		GenerateRandomTests(2,10000);
		GenerateRandomTests(2,100000);
		GenerateRandomTests(2,1000000);

		// - Binary Search Tree - Searching //
		BinarySearching(binarysearchtree, 26);

	}

	// - BinarySearching Node node, int num -> void (Print Result)
	// - Finding key from the binary search tree, if key exist from the tree then print the key's value.
	public static void BinarySearching (Node node, int num){
		if(node.keyV.key == num){
			System.out.println("Tree has " + num + " value is " + node.keyV.value);
		}
		else{
			if(node.right!=null && node.keyV.key < num){
				BinarySearching(node.right,num);
			}
			else if(node.left!=null && node.keyV.key > num){
				BinarySearching(node.left,num);
			}
			else{
				System.out.println("Tree has not " + num);
			}
		}
	}


	public static boolean isBinarySearchTree(Node node){
		return (isBinarySearchTree(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	// - Helper Method for isBinarySearchTree - //
	// Node BTS, Boolean isBinarySearchTree -> isBinarySearchTree::True || False //

	public static boolean isBinarySearchTree(Node node, int min, int max){

		// - If node is empty return true - //
		if(node==null){
			return true;
		}

		// - False cases - //
		if(node.keyV.key < min || node.keyV.key > max){
			return false;
		}
		return (isBinarySearchTree(node.left, min, node.keyV.key)
				&& isBinarySearchTree(node.right, node.keyV.key, max));
		}


	// - Insert node to Tree - //
	public static void insert(Node node, Node node_x){
		if (node_x.keyV.key < node.keyV.key) {
			if (node.left != null) {
				insert(node.left, node_x);
			}
			else{
				node.left = node_x;
			}
		}
		else if (node_x.keyV.key > node.keyV.key) {
			if (node.right != null) {
				insert(node.right, node_x);
			}
			else {
				node.right = node_x;
			}
		}
	}


	// - Insert random nodes to a Tree - //
	public static void addRandom(int member, Node node){
		for(int x = 0; x < member; x++){
			insert(node, new Node(new KeyValue(rnd.nextInt(member),"Random")));
		}
	}

	// - Calculate Members - //
	public static int calculate (Node node){
		if(node==null){
			return 0;
		}
		else{
			return 1 + calculate(node.left) + calculate(node.right);
		}
	}

	// - Calculate Height - //
	public static int height(Node node){

		if (node == null){
			return 0;
		}

		int heightLeft = height(node.left);
		int heightRight = height(node.right);

		if( heightLeft > heightRight ){
			return heightLeft +1;
		}
		else{
			return heightRight +1;
		}
	}

	// - OutofBalance - //
	public static double outofbalance(int h, int m){
		return (double) h / (Math.log((double)m))/ (Math.log(2));
	}

	// - Print Tree - //
	public static void print(Node node){
		if(node!=null){
			System.out.println(node.keyV.key+ " " + node.keyV.value);
			print(node.left);
			print(node.right);
		}

	}


	// - Testing BST - //
	public static void testBST(Node node){
		// - Print - //
		// print(node);

		// - is Binary Search Tree - //
		System.out.println("is Binary Search Tree: "+ isBinarySearchTree(node));

		// - Total Member - //
		System.out.println("Tree has " + calculate (node) + " member(s).");

		// - Height of the tree - //
		System.out.println("Height of the tree: " + height(node));

		// - OutofBalance - //
		System.out.println("Out of Balance: " + outofbalance(height(node), calculate (node)));
	}


	// - Generate Random Tests - //
	public static void GenerateRandomTests(int num, int mem){
		Node testNode = new Node(new KeyValue(1,"Random_Test"));
		for(int x = 1; x <= num; x++){
			System.out.println("---------------------------------------");
			addRandom(mem,testNode);
			testBST(testNode);
			System.out.println("---------------------------------------\n");
		}
	}
}//<--end_of_the-class-->//
