import java.util.LinkedList;


public class Dijkstra {
	
	Graph graph;
	Queue FIFO;
	String source;
	
	Dijkstra(Graph graph, String source){
		this.graph = graph;
		this.FIFO = new Queue();
		this.source = source;
		
		ShortestPath(this.graph, this.source);
	}

	public void ShortestPath(Graph graph, String source){
		 
		Vertex sourceV = graph.getVertex(source);	
		sourceV.setColor("gray"); 
		sourceV.setDistance(0);
		FIFO.enqueue(sourceV);
		 
		
		while(!(FIFO.isEmpty())){
			Vertex tmp = ((Vertex) FIFO.dequeue());
			tmp.setColor("black");
			addtoQueue(graph.getNeighbors(tmp.getVName()), this.FIFO, tmp);
			
		}
	}
	
	public void addtoQueue(LinkedList<Neighbor> Neigh, Queue FIFO, Vertex source){
		for(int i=0; i < Neigh.size(); i++){
			Vertex v = graph.getVertex(Neigh.get(i).getNodeID());
			if(v.getColor().equals("black")){continue;}
			else if(v.getColor().equals("white")){
				v.setColor("gray");
				v.setPName(source.getVName());
				v.setDistance(source.getDistance()+v.getDistance());
				FIFO.enqueue(v);
			}
			else if(v.getColor().equals("gray")){
				 if( v.getDistance()<=source.getDistance()+v.getDistance()) continue;
				 else{ 
					 v.setPName(source.getVName());
					 v.setDistance(source.getDistance()+v.getDistance());
					 FIFO.enqueue(v);
				 }
			}
		}
		 
	}
}