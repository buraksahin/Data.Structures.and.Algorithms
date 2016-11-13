
public class AddDelete {
	
	
	// - Add number last of the array - //
	public int[] add_loa (int[]arr, int number){
		int[] newarr = new int[arr.length+1];
		for (int x = 0; x < newarr.length-1; x++){
			newarr[x] = arr[x];
		}
		newarr[newarr.length-1] = number;
		
		return newarr;
	}
	
	// - Add number to a index  - //
		public int[] add (int[]arr, int indx, int number){
			int[] newarr = new int[arr.length+1];
			int y = 0;
			for (int x = 0; x < newarr.length; x++){
				if(indx == x){
					newarr[0] = number;
				}
				else{
					newarr[x] = arr[y];
					y++;
				}
				
			}
			
			return newarr;
	}
		
	// - Add as sorted index - //
	
	public int[] add_asi (int[]arr, int number){
		
		int[] newarr = new int[arr.length+1];
		int y = 0;
		boolean isadded = true;
		for (int x = 0; x < newarr.length; x++){
			
			if(x<newarr.length-1){
			if(arr[y]>= number && isadded){
				newarr[x] = number;
				isadded=false;
			}
			else{
				newarr[x] = arr[y];
				y++;
			}}
			else{
				if(isadded){
					newarr[x] = number;
				}
				else{
				newarr[x] = arr[arr.length-1];
				}
			}
			
		}
		
		return newarr;
	}
	
	// - Delete number from a index - //
	
	public int[] delete (int[]arr, int indx){
		
		int[] newarr = new int[arr.length-1];
		int y = 0;
		for(int x = 0; x < arr.length; x++){
			if(x != indx){
				newarr[y] = arr[x];
				y++;
			}
		}
		
		return newarr;
	}
		
		
		
}
