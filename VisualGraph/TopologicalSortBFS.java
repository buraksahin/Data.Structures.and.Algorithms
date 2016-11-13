import java.util.LinkedList;
import java.util.Stack;
 
// - Topological Sort - //
// - Breadth-First Search - //
public class TopologicalSortBFS {
	
	
	Graph graph;
	String source, act;
 
	LinkedList<String> Sortx = new LinkedList<String>();
	Stack<String> Tsort = new Stack<String>();
	
	public TopologicalSortBFS(){}
	public TopologicalSortBFS(Graph g, String s){
		this.graph = g;
		this.source = s;
		act = source;
		sort();
		printT();
	}
	
	
	// - Visit Neighbors - //
	public void checkNeig(String act){
		 
		int z = graph.getVertex(act).getNeighbors().size();
		if(z>0){
			for(int x=0; x<z; x++){
				if(graph.getVertex(graph.getVertex(act).getNeigh(x)).Color=="white"){
					graph.getVertex(graph.getVertex(act).getNeigh(x)).setColor("gray");
					Sortx.add(graph.getVertex(graph.getVertex(act).getNeigh(x)).getVName());
				}
			}
		}
	}
	
	public void printT(){
		System.out.print("Topological Sort::BFS\n");
		for(int j=0; j<Tsort.size(); j++){
			System.out.print(Tsort.get(j)+" ");
		}System.out.println("");
	}
	public void sort(){
		
		Sortx.add(source);
		while(Sortx.size()>0){
			act = Sortx.pop();
			
			// - Visit Neighbors and Mark - //
			if(graph.getVertex(act).getColor()!="black"){
				checkNeig(act);
				graph.getVertex(act).setColor("black");
				Tsort.add(act);
			}
			 
		}
		// - Check isolated nodes - //
		int z = graph.getGraphSize();
		if(z>0){
		for(int x=0; x<z; x++){

			if(graph.getVertex(graph.nodenames.get(x)).Color=="white"){
				source=graph.nodenames.get(x);
				sort();
				break;
			}
		}
		}
		
	}
}