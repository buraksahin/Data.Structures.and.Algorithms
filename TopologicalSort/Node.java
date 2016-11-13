/**
 * 
 * @author burak_sahin
 *
 */
class Node{
	
	// - Variables - //
	
	Node next;
	Object nObj;
	String Color;

	// - Constructor - //
		
	public Node(){
		this.next = null;
		this.nObj = null;
	}
	
	public Node(Object nObj)
	{
		this.next = null;
		this.nObj = nObj;
	}
	
	public Node(Object nObj, Node next)
	{
		this.next = next;
		this.nObj = nObj;
	}
	
	// - Getters and Setters - //
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Object getnObj() {
		return nObj;
	}
	
	public void setnObj(Object nObj) {
		this.nObj = nObj;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}
}