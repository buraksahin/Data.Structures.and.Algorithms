import java.util.LinkedList;
import java.util.Stack;


public class Prim {
	
	Graph graph;
	String source, act;
	
	LinkedList<String> VList = new LinkedList<String>();
	LinkedList<Neighbor> LLN = new LinkedList<Neighbor>();
	Stack<String> Tsort = new Stack<String>();
	
	public Prim(){}
	public Prim(Graph g, String s){
		this.graph = g;
		this.source = s;
		solve();  
	}
	
	public void solve(){
		String tmpName="";
		int tmpWeight = Integer.MAX_VALUE;
		int keepL = 0;
		VList.add(source);
		graph.getVertex(source).setColor("grey");
		for(int i=0; i<graph.getGraphSize()-1; i++){
			for(int j=0; j<VList.size(); j++){
				LLN = graph.getNeighbors(VList.get(j));
				// - Find less in neighbor's of VList(j) - //
				for(int x=0; x<LLN.size(); x++){
				 
					if(tmpWeight>LLN.get(x).weight && graph.getVertex(LLN.get(x).getNodeID()).getColor()=="white"){
						keepL=j;
						tmpWeight=LLN.get(x).weight;
						tmpName = LLN.get(x).NodeID;
						
					}
				}
			}
			System.out.println(VList.get(keepL)+" -> "+tmpName+"::"+tmpWeight);
			graph.getVertex(tmpName).setColor("grey");
			VList.add(tmpName);
			tmpWeight = Integer.MAX_VALUE; 
		}	
	}	
}
