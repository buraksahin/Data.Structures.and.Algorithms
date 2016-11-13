/**
 * 
 * @author burak_sahin
 * 
 */
public class FIFO {
	int size;
	int[] repo;
	int cP = 0;
	int oP = -1;
	// - Size - //
	FIFO(int size){
		repo = new int[size];
	}
	
	// - Add a new value - //
	public void equeue(int sayi){
		repo[cP] = sayi;
		cP++;
	}
	
	// - Dequeue - //
	public Object dequeue(){
		oP++;
		cP--;
		return repo[oP];
		
		
	} 
	
	public boolean isEmpty(){
		if(cP==0){
			return true;
		}
		else{
			return false;
		}
	}

}
