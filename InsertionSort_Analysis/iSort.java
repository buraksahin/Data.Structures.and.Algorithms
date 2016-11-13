 
public class iSort {
	
	// - Insertion Sort - //
	/*
	public void insertSort(int[] uList){
		
		  for(int x = 1; x < uList.length; x++){
			  
		    int key = uList[x];
		    int j = x - 1;
		    // - Loop - //
		    while(j >= 0 && uList[j] > key){
		    	uList[j + 1] = uList[j];
		      j = j - 1;
		    }
		    uList[j + 1] = key;
		  }
		}
*/
	// - Insertion Sort with end and start points - //

	public void inSort(int[] uList, int end, int start)
	{
		int j = end-1;
		
		while (j >= start)
		{
			insert (uList[j], uList, end, j);
			j--;
		}
	}
	

	protected void insert (int key, int[] uList, int end, int start)
	{
		while ((start < end -1) && (key > uList [start + 1]))
		{
			// - swap number line - //
			uList[start] = uList[start + 1];
			// - change current position //
			start++;
		}
		uList[start] = key;		
	}
	
}
