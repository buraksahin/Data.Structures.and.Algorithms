
public class MergeSort {
	
	// - List of type x || Unsorted or sorted array - //
    private int[] LoX;
    private String ope = "<";
    
      //////////////////////
     // - Constructors - //
    //////////////////////
    public MergeSort(){}
    public MergeSort(int[] arr) {LoX = arr;}
    
    // - Set LoX - //
    public void setLoX(int[] arr, String ope){
    	LoX = arr;
    	this.ope = ope;
    }
    
    // - Start to Sorting - //
    public void sort() 
    {
    	LoX = msort(LoX, ope);
    }
    
    private int[] msort(int[] arr, String ope) 
    {
    	if (arr.length == 1) { return arr; }
    	else {
    		
    		// - Divide the array to left and right - //
    		
    	    // - A part of the array (Left)
    	    int[] left = new int[arr.length/2];
    	    // - Copy LoX to left side - //
    	    System.arraycopy(arr, 0, left, 0, left.length);

    	    // - A part of the array (Right)
    	    int[] right = new int[arr.length-left.length];
    	    // - Copy LoX to right side - //
    	    System.arraycopy(arr, left.length, right, 0, right.length);
    	    
    	    // - Sort sides - //
    	    left  = msort(left, ope);
    	    right = msort(right, ope);

    	    // - Merge arrays - //
    	    merge(arr, left, right, ope);

    	    return arr;
    	}
   }
    
    private void merge(int[] arr, int[] left, int[] right, String ope) {
    	
    	// - Keeps current indexes - //
    	int cLft = 0;
    	int cRgt = 0;
    	int cArr = 0;

    	
    	while (cLft < left.length && cRgt < right.length) {
    		// -  comparison condition that two items - //
    		if(ope.startsWith("<")){
	    		if (left[cLft] < right[cRgt])
	    		{
	    			// - swap items - //
	    			arr[cArr] = left[cLft];
	    			// - Add one to index - //
	    			cLft++;
	    	    }
	    	    else {
	    	    	// - swap items - //
	    	    	arr[cArr] = right[cRgt];
	    	    	// - Add one to index - // 
	    	    	cRgt++; 
	    	    }
    		}
    		else{
    			if (left[cLft] > right[cRgt])
	    		{
	    			// - swap items - //
	    			arr[cArr] = left[cLft];
	    			// - Add one to index - //
	    			cLft++;
	    	    }
	    	    else {
	    	    	// - swap items - //
	    	    	arr[cArr] = right[cRgt];
	    	    	// - Add one to index - // 
	    	    	cRgt++; 
	    	    }
    		}
    		// - Add one to index - //
    	    cArr++; 
    	}
    	
    	
    	// - fArray for copy left or right sides - //
    	int[] fArray;
    	// - index of fArray - //
    	int cfAr;
    	
    	
    	if (cLft >= left.length)
    	{
    		fArray = right;
    		cfAr = cRgt;
    	}
    	else{
    		fArray = left;
    		cfAr = cLft;
    		}

    	// - Swap array items - //
    	for (int x=cfAr; x<fArray.length; x++) {
    	    arr[cArr] = fArray[x];
    	    cArr++;
    	}
    }
}
