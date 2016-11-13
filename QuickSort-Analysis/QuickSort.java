public class QuickSort  {
	
	private int[] listx;   // - Array - //
	private int   lenList; // - Length of the list - //
	private String ope = "<";
	
	public QuickSort (){
	}
	
	public void qsort(int[] values, String ope) {
	
		if (values.length==0){
			return;
		}
	    else{
	    	this.ope = ope;
		    this.listx = values;
		    lenList = values.length;
		    quicksort(0, lenList - 1);
		    }
	}
	  
	private void quicksort(int start, int end) {
	    int less = start, greater = end;	    
		
	    // Set pivot lenList //
		int pivot = listx[start + (end-start)/2];
	
		while (less <= greater) {
	
			if(ope.startsWith("<")){
				// - Count until find the greater number than pivot //
				while (listx[less] < pivot) {
		    		less++;
			    }
			    	
			   	// - Count until find the less number than pivot // 
			   	while (listx[greater] > pivot) {
			   		greater--;
			   	}
		   	}
		    	
		   	if(ope.startsWith(">")){
		    	// - Count until find the greater number than pivot //
		    	while (listx[less] > pivot) {
		    		less++;
		    	}
			    	
			   	// - Count until find the less number than pivot // 
			   	while (listx[greater] < pivot) {
			   		greater--;
			   	}
		   	}
		    	
		      
		   	// - Check the position of current values of less and great
		   	if (less <= greater) {
		   		swap(less, greater); // - Swap less and greater numbers //
	    		less++;
	    		greater--;
	    	}
		}//<--end_of_the_loop -->//
		  
		    
		// - Checking the position of the current counter - //
		if (start < greater){
			// sort list again... //
			quicksort(start, greater);
		}
			
		// - Checking the position of the current counter - //
		if (end > less){
			// sort list again... //		      
			quicksort(less, end);
		}
	}//<--end_of_the_quick-sort-->//
	
	  // - Swap items - //
	  private void swap(int less, int greater) {
	    int temp = listx[less];
	    listx[less] = listx[greater];
	    listx[greater] = temp;
	  }
}  