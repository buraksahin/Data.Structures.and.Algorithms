public class BellmanFord {
	
	Graph graph;
	String source;
	int inf = Integer.MAX_VALUE;
	public BellmanFord(Graph graph, String source){
		this.graph = graph;
		this.source = source;
		
		BellmanF(graph,source);
	}
	
	public void BellmanF(Graph g, String s){
		for (int i = 0; i <g.getGraphSize(); ++i){
			g.Graph.mheap.get(i).setDistance(inf);
		}
			 
		g.Graph.mheap.get(0).setDistance(0);

		for (int i = 0; i < g.getGraphSize()-1; ++i){
			for (int j = 0; j < g.Graph.mheap.get(i).getNeighbors().size(); ++j){
				if (g.Graph.mheap.get(i).getDistance() + g.Graph.mheap.get(i).Neighbors.get(j).weight < g.Graph.mheap.get(i).getDistance()){
					g.Graph.mheap.get(i).setDistance(g.Graph.mheap.get(i).getDistance() + g.Graph.mheap.get(i).Neighbors.get(j).weight);
				}
			}
		}			
	}
}