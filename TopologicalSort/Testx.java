import static org.junit.Assert.*;

import org.junit.Test;


public class Testx {

	@Test
	public void testAddVertexString() {
		Graph g = new Graph();
		g.addVertex("d");
		g.addVertex("b");
		g.addVertex("f");
		g.addVertex("a");
		g.addVertex("g");
		g.addVertex("e");
		assertEquals(g.getGraphSize(),6);
	}

	@Test
	public void testAddNeighbor() {
		Graph g = new Graph();
		g.addVertex("b");
		g.addVertex("c");
		g.addNeighbor("b", "c", 1);
		assertEquals(g.isNeigh(g.Graph.getVertex(0), "c"),true);
	}
	
	
	public boolean testN(){
		Graph g = new Graph();
		for(int i = 0; i<=20; i++){
			g.addVertex(""+i);
		}
		g.addNeighbor("1", "2", 5);
		g.addNeighbor("1", "3", 6);
		g.addNeighbor("2", "5", -5);
		g.addNeighbor("3", "2", -7);
		g.addNeighbor("4", "1", 1);
		g.addNeighbor("5", "3", 4);
		g.addNeighbor("6", "7", 8);
		g.addNeighbor("8", "3", -6);
		g.addNeighbor("9", "10", 8);
		Dijkstra d = new Dijkstra(g,g.source);
		return true;
	}
	@Test
	public void testNegativeW(){
		Testx t = new Testx();
		assertEquals(t.testN(),true);
	}
	
	@Test
	public void removeVertex(){
		Graph g = new Graph();
		g.addVertex("d");
		g.addVertex("b");
		g.addVertex("f");
		g.addVertex("a");
		g.addVertex("g");
		g.addVertex("e");
		g.removeVertex("d");
		g.removeVertex("b");
		g.removeVertex("f");
		g.removeVertex("a");
		g.removeVertex("g");
		g.removeVertex("e");
		assertEquals(g.getGraphSize(),0);
	}

}
