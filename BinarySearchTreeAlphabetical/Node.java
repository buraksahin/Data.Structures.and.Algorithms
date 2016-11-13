public class Node {
	KeyValue keyV;
	Node left;
	Node right;

	public Node(KeyValue keyV) {
		super();
		this.keyV = keyV;
	}

	public Node(KeyValue keyV, Node left, Node right) {
		super();
		this.keyV = keyV;
		this.left = left;
		this.right = right;
	}

	public KeyValue getKeyV() {
		return keyV;
	}

	public void setKeyV(KeyValue keyV) {
		this.keyV = keyV;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
