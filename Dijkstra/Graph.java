import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Graph implements IGraph {
	// - Variables - //
	// Used my heap object for Graph //
	// Graph will keep vertices //
	Heap Graph = new Heap();
	ArrayList<String> nodenames = new ArrayList<>();
	boolean weighted;
	String source="";
	int VNumber=0;
	
	public Graph() {
	}
	
	public void addVertex(String v){
		if(isNotExist(v)){
			Graph.insert(new Vertex(v));
			nodenames.add(v);
			System.out.println("'"+ v + "' inserted..." );
		}
		else{
			System.out.println("Node '" + v + "' had been defined...");
		}
	}
	@Override
	public void addVertex(Vertex v) {
		// TODO Auto-generated method stub
		if(isNotExist(v.getVName())){
			Graph.insert(v);
			nodenames.add(v.getVName());
			VNumber++;
			System.out.println("'"+ v.getVName() + "' inserted..." );
		}
		else{
			System.out.println("Node '" + v.getVName() + "' had been defined...");
		}
		
	}

	@Override
	public void removeVertex(String NodeID) {
		// TODO Auto-generated method stub
		Graph.removeVertex(NodeID);
		for(int x=0; x<nodenames.size(); x++){
			if(nodenames.get(x).equals(NodeID)){
				nodenames.remove(x);
				VNumber--;
				break;
			}
		}
	}

	
	@Override
	public void addNeighbor(String NodeID, String Neighbor, int Weight) {
		// TODO Auto-generated method stub
		for(int x=0; x<nodenames.size(); x++){
			if(Graph.getVertex(x).getVName().equals(NodeID)){
				Vertex tmp = Graph.getVertex(x);
				if(isNeigh(tmp, Neighbor)){
					tmp.addNeigh(Neighbor,Weight);
					Graph.mheap.set(x, tmp);
					break;
				}
				else{
					System.out.println("These are already neighbor...");
					break;
				}
			}
		}
	}

	@Override
	public void removeNeighbor(String NodeID, String Neighbor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readfromfile(String path) {
		// TODO Auto-generated method stub
		String GraphData = "";
		try {
			BufferedReader filex = new BufferedReader(new FileReader (path));
			String str = null; 
			try {
				while ((str = filex.readLine()) != null){
					GraphData += str+"\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] strGraph = GraphData.split("\n");
		Graph = new Heap();
		nodenames = new ArrayList<>();
		VNumber = Integer.parseInt(strGraph[0]);
		System.out.println(VNumber);
		for(int x=0; x<VNumber; x++){
			nodenames.add(strGraph[1].split(" ")[x]);
			Graph.insert(new Vertex(strGraph[1].split(" ")[x]));
			System.out.print(strGraph[1].split(" ")[x]+" ");
		}
		source=strGraph[2];
		System.out.println(source);
		int line=3;
		
		// Adding Neighbors //
		for(int x=0; x<nodenames.size(); x++){
			
			String[] tmp = strGraph[line].split(" ");
			 
			for(int j=0; j<tmp.length; j++){
				System.out.print(Integer.parseInt(tmp[j])+ " ");
				if(x!=j && Integer.parseInt(tmp[j])>0){
					addNeighbor(nodenames.get(x), nodenames.get(j), Integer.parseInt(tmp[j]));
				}
			}
			System.out.println("\n");
			line++;
		}
}
	
	public boolean isNotExist(String N){
		for(int x=0; x<nodenames.size(); x++){
			if(nodenames.get(x).equals(N)){	
				return false;
			}
		}
		return true;
	}
	
	public boolean isNeigh(Vertex v, String n){
		for(int x=0; x<v.getNeighbors().size(); x++){
			if(v.getNeighbors().get(x).equals(n)){	
				return false;
			}
		}
		return true;
	}
	public int getGraphSize(){
		return nodenames.size();
	}
	
	public Vertex getVertex(String V){
		for(int x=0; x<nodenames.size(); x++){
			if(Graph.getVertex(x).getVName().equals(V)){
				return Graph.getVertex(x);
			}
		}
		return null;
}
	
	public LinkedList<Neighbor> getNeighbors(String V){
		for(int x=0; x<nodenames.size(); x++){
			if(Graph.getVertex(x).getVName().equals(V)){
				return Graph.getVertex(x).getNeighbors();
			}
		}
		return null;
}
	
	
}
