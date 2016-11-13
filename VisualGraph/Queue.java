/**
 * 
 * @author burak_sahin
 *
 */
public class Queue {

	FIFO f;
	
	public Queue(){
		f = new FIFO();
	}

	public void enqueue(Object nObj){
		f.add(nObj);
	}

	public Object dequeue(){
		Object obj_x = f.getObj(0);
		f.remove();
		return obj_x;
	}
	
	public boolean isEmpty(){
		return f.isEmpty();
	}
}
