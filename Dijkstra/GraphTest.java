import static org.junit.Assert.*;

import org.junit.Test;


public class GraphTest {

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
