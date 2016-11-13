import java.util.Stack;

// - Topological Sort - //
// - Depth-First Search - //

public class TopologicalSort {
	
	Graph graph;
	String source, act;
	
	Stack<Object> S = new Stack<Object>();
	Stack<String> Sortx = new Stack<String>();
	int sizeN;
	public TopologicalSort(){}
	public TopologicalSort(Graph g, String s){
		this.graph = g;
		this.source = s;
		act = source;
		sort();
	}
	
	
	// - Checking White and Gray neighbors - //
	public int[] checkNeig(String act){
		int[] result = new int[2];
		int z = graph.getVertex(act).getNeighbors().size();
		int whC = 0;
		if(z>0){
		for(int x=0; x<z; x++){

			if(graph.getVertex(graph.getVertex(act).getNeigh(x)).Color=="white"){
				whC++;
				result[0]=1;
				result[1]=x;
	
				break;
			}
		}
		}
		if(whC>0){

			return result;
		}
		else{
			return result;
		}
	}
	
	public void sort(){
		
		
		while(graph.getVertex(source).Color=="white"||graph.getVertex(source).Color=="gray"){
		 
			sizeN = graph.getVertex(act).getNeighbors().size();
			int chk_W[] = checkNeig(act);
			
			while(act!=null){
				if(chk_W[0]>0){

				graph.getVertex(graph.getVertex(act).getNeigh(chk_W[1])).setColor("gray");
				S.add(act);
				act = graph.getVertex(graph.getVertex(act).getNeigh(chk_W[1])).getVName();
			
				}
				else{

					graph.getVertex(act).setColor("black");
					
					Sortx.push(act);
					if(S.size()>0){
					
					act = (String)S.pop();
					
					}
					else{break;}
				}
				chk_W = checkNeig(act);
			}
		}
		
		System.out.print("Topological Sort::DFS\n");
		for(int j=Sortx.size()-1; j>=0; j--){
			System.out.print(Sortx.get(j)+" ");
		}System.out.println("");
	}
}