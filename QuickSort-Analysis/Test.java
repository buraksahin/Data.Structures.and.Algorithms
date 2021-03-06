import java.util.Random;

/**
 * 
 * @author   : Burak.Sahin
 * @stud. id : 10876041
 * @since    : 2012.2013
 * 
 */
public class Test {
	
	public static QuickSort qsort = new QuickSort();
	public static BinarySearch BS = new BinarySearch();
	public static AddDelete adddelete = new AddDelete();
	// - Main Class - //
	public static void main(String[] args){
		
		// - Unsorted array - //
		int[] myarray0 = {1,4,2,3,6,8,0,2};
		long start;    // - Process Start  Time - //
		long finished; // - Process Finish Time - //
		
		
        start = System.currentTimeMillis();
        qsort.qsort(myarray0, ">"); // set array & operator
        finished = System.currentTimeMillis();
        
        // - Print - //
		System.out.println("--> " + "Started: " + start + " Finished: " + finished);
		System.out.println("\tProcess time: "+(finished-start) + "ms.");
		print(myarray0);
		// tester0(Number of Member, isPrint, delimiter, number generating type, searching number)
		tester0(1,     false, "<", "sorted", 24);
		tester0(2,     false, "<", "sorted", 24);
		tester0(10,     true, "<", "sorted", 24);
		tester0(100,     false, "<", "sorted", 24);
		tester0(1000,     false, "<", "sorted", 24);
		tester0(10000,     false, "<", "sorted", 24);
		
		tester0(1,     false, "<", "rsorted", 24);
		tester0(2,     false, "<", "rsorted", 24);
		tester0(10,     true, "<", "rsorted", 24);
		tester0(100,     false, "<", "rsorted", 24);
		tester0(1000,     false, "<", "rsorted", 24);
		tester0(10000,     false, "<", "rsorted", 24);
		
		tester0(100,     false, "<", "random", 24);
		tester0(1000,     false, "<", "random", 24);
		tester0(10000,     false, "<", "random", 24);
		tester0(100000,     false, "<", "random", 24);
		tester0(1000000,     false, "<", "random", 24);
		tester0(10000000,     false, "<", "random", 24);
		
		System.out.println("\nAll tests passed...");
	}
	
	public static void tester0 (int lengthArray, boolean printOK, String ope, String gType, int key){
		int myArray[] = new int[lengthArray];
		
		if(gType.startsWith("random")){
			// - Generating new array - //
			myArray = randArray(lengthArray);
		}
		if(gType.startsWith("sorted")){
			// - Generating new array - //
			myArray = sorted(lengthArray);
		}
		if(gType.startsWith("rsorted")){
			// - Generating new array - //
			myArray = rsorted(lengthArray);
		}
	
		
		// - Getting starting time - //
		long start = System.currentTimeMillis();
        qsort.qsort(myArray, ope);    
        long finished = System.currentTimeMillis();
        System.out.println("\n\n--------------------------------------------------------\n");
		System.out.println("Generated " + gType +" "+ lengthArray + " array members for quick qsort...\n --> " + "Started: " + start + " Finished: " + finished);
		System.out.println("\tProcess time: "+(finished-start) + "ms.");
		
		if(isSorted(myArray)){
			System.out.println("isSorted: Yes\n");
			start = System.currentTimeMillis();
			System.out.println("Binary Search result for " + lengthArray + " members :" + BS.binarySearch(myArray, 0, myArray.length-1, key) + "\n");
			finished = System.currentTimeMillis();
			System.out.println("\tSearching Process time: "+(finished-start) + "ms.");
			System.out.println("\tTotal searching step: "+ BS.getSTEP() + " step(s).\n");
			
			// - Add to Array - //
			start = System.currentTimeMillis();
			myArray = adddelete.add_asi(myArray, 5);	
			finished = System.currentTimeMillis();
			System.out.println("\nAdding Process time: "+(finished-start) + "ms.");
			
			// - Delete from Array - //
			start = System.currentTimeMillis();
			// adddelete.delete(array, deleting item's index)
			myArray = adddelete.delete(myArray, myArray.length/2);
			finished = System.currentTimeMillis();
			System.out.println("\nDeleting Process time: "+(finished-start) + "ms.");
			System.out.println("\n--------------------------------------------------------\n\n");
			
			
		}
		else{
			System.out.println("isSorted: No\n");
		}
		
		if(printOK){
		print(myArray);
		System.out.println("\n--------------------------------------------------------\n\n");
		}
	}

	
	// - Generating random arrays - //
	public static int[] randArray(int lengthArray) 
    {
        Random rnd = new Random();
        int[] rArray= new int[lengthArray];
        
        for(int x = 0; x < lengthArray; x++){ 
        	rArray[x] = rnd.nextInt(lengthArray);}
        
        return rArray;
    }
	
	public static int[] sorted(int lengthArray) 
    {
		int z = 0;
        int[] rArray= new int[lengthArray];
        
        for(int x = 0; x < lengthArray; x++){ 
        	
        	rArray[x] = z;
        	z++;
        	}
        
        return rArray;
    }
	
	
	public static int[] rsorted(int lengthArray) 
    {
		int z = lengthArray;
        int[] rArray= new int[lengthArray];
        
        for(int x = 0; x < lengthArray; x++){ 
        	rArray[x] = z;
        	z--;
        	}
        
        return rArray;
    }
	
	// - Print Arrays - //
    public static void print (int[] Larray) 
    {
        for (int x = 0; x<Larray.length; x++){
            System.out.print(Larray[x]+" ");
        }
        System.out.println();
    }
	
    // - isSorted - //
    public static boolean isSorted(int[] Larray)
    {
        for (int x = 0 ; x < Larray.length - 1 ; x++){
            if (Larray[x] > Larray[x+1]){
                return false;
                }
            }
        return true;
    }  
}