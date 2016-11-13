/**
 *
 * @author BurakSahin
 *
 */
public class Test {

	public static void main(String args[]){

		BST myBST = new BST();
		int lastValue = 0;

		myBST.insert(new KeyValue(5,"A"));
		myBST.insert(new KeyValue(8,"A"));
		myBST.insert(new KeyValue(3,"B"));


		// - Reading Inputs - //
		int countA = args.length;
		int j = 0;
		while(countA>0)
		{
			String command = null;
			String name	   = null;

			if(j%2==0){
				command = args[j];
				name    = args[j+1];
			}

			if(command.startsWith("I")){
				myBST.insert(new KeyValue(lastValue,name));
			}
			/*
			if(command.startsWith("I")){
				myBST.delete(Integer.parseInt(name));
			}*/
			j=j+2;
			countA=countA+2;
		}
	}
}
