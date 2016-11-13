import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;

public class Testx {
	/**
	 * Prim_Test
	 */
	@Test
	public void testPrim () {
		Graph g = new Graph();
		// - Generate 1000 Vertex and Edge - //
		g.addVertex("Test1");
		g.addVertex("Test2");
		g.addNeighbor("Test1", "Test2", 5);
		g.addNeighbor("Testw2", "Test1", 5);
		for(int x=0; x<998; x++){
			Random r1 = new Random();  
	        String nodename = Integer.toString(Math.abs(r1.nextInt()), 0);
	        String getR = g.nodenames.get(r1.nextInt(g.nodenames.size()-1));
	        int tmpW = r1.nextInt(100);
	        g.addVertex(nodename);
			g.addNeighbor(getR, nodename, tmpW);
			g.addNeighbor(nodename, getR, tmpW);
		}
		
		assertEquals(g.getGraphSize(),1000);
		@SuppressWarnings("unused")
		Prim pr = new Prim(g,"Test1");
	
	}
	
	/*
	 * OTHER TESTS
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
	
	*/
	

}
