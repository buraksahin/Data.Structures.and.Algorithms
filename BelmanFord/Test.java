
public class Test {
	public static void main(String[] args){

		Heap h = new Heap();
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex z = new Vertex("Z");
		h.insert(e);
		h.insert(a);
		h.insert(d);
		h.insert(b);
		h.insert(z);
		h.insert(c);

		Graph g = new Graph();
		g.addVertex("d");
		g.addVertex("b");
		g.addVertex("f");
		g.addVertex("a");
		g.addVertex("g");
		g.addVertex("e");
		
		System.out.println("Graph Size: "+ g.getGraphSize());
		System.out.println("Array Size: "+ g.Graph.mheap.size());
		
		for(int x = 0; x< g.Graph.mheap.size(); x++){
			System.out.println(g.Graph.mheap.get(x).getVName()+"");
		}
		
		g.removeVertex("a");
	System.out.println("\n\n");
		for(int x = 0; x< g.Graph.mheap.size(); x++){
			System.out.println(g.Graph.mheap.get(x).getVName()+"");
		}
		System.out.println("Graph Size: "+ g.getGraphSize());
		System.out.println("Array Size: "+ g.Graph.mheap.size());
		
		//Graph g = new Graph();
		//g.readfromfile("mygraph.txt");
		//Dijkstra d = new Dijkstra(g,g.source);
		BellmanFord b = new BellmanFord(g,g.source);
	 
}}
