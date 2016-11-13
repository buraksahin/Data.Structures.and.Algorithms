
public class BinarySearch {
	
	// - Variables - //
	private static int LastBSstep = 0;
	
	public BinarySearch(){
		
	}
	
	// - binarySearch (Sorted Array, First Item, Last Item, Searching Item) -> boolean //
	// - mid:   Middle of the array
	// - first: first member of the array
	// - last:  last member of the array
	// - key:   searching item
	public static boolean binarySearch(int[] sorted, int first, int last, int key) {
		
	    while (first < last) {
	    	
	        int mid = (first + last) / 2;
	        LastBSstep++;
	        if (key < sorted[mid]) {
	        	last = mid;  
	        	LastBSstep++;
	        }
	        else if (key > sorted[mid]) {
	            first = mid + 1;  
	            LastBSstep++;
	        } 
	        else {
	        	LastBSstep++;
	            return true;     
	        }
	    }
	    LastBSstep++;
	    return false;   
	}
	
	
	public int getSTEP(){	// - Return Step Value - //
		int tmp = LastBSstep;
		LastBSstep = 0;
		return tmp;
		
	}
}
