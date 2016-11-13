/**
 * 
 * @author burak_sahin
 * 
 */
public class LIFO {
	int size;
	int[] repo;
	int cP;

	// - Constructor - //
	LIFO(int size){
		repo = new int[size];
		cP=size-1;
		this.size=0;
	}
	
	// - Add a new value - //
	public void equeue(int sayi){
		repo[cP] = sayi;
		cP--;
		size++;
	}
	
	// - Dequeue - //
	public Object dequeue(){
		cP++;
		size--;
		return repo[cP];
		
		
	} 
	
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		else{
			return false;
		}
	}

}