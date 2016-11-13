/**
 * 
 * @author burak_sahin
 *
 */
public class FIFO implements IFL
{
	// Variables //
	private Node node;
	private int member;
	
	// Constructor //
	public FIFO(){
		node = new Node(null);
		member = 0;
	}
	
	// - add
	// - Object 'nObj' -> Node
	// - Get a object any type of nObj and add to node Node
	public void add(Object nObj){
		if(node.getnObj()==null){
			node.setnObj(nObj);
			member++;
		}
		else{
			add(node,nObj);
		}
	}

	public void add(Node node, Object nObj){
		if(node.next!=null){
			add(node.next,nObj);
		}
		else{
			node.next = new Node(nObj);
			member++;
		}
	}
	// - Remove First - //
	public void remove(){
		if(node.getnObj()!=null){
			Node tmp = node.next;
			node = tmp;
			member--;
		}
	}
	
	// getObj: Get an object with index number from the node.
	// index -> Object
	public Object getObj(int i){
		if(member<=0){
			return null;
		}
		
		Node temp = node;
		for(int j=0; j<i; j++){
			if(temp.next!=null){
				temp = temp.next;
			}
			else{
				return null;
			}
		}
		return temp.getnObj();
	}
	
	
	// - isEmpty
	// - If empty -> true else false
	public boolean isEmpty(){
		if(member<=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	// - Size
	public int size(){
		return member;
	}
}