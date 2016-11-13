import java.util.Random;

import javax.swing.JFrame;

 
/**
 * 
 * @author BurakSahin_10876041
 *
 */

public class Test extends Thread {
	/**
	 * Graph Algorithms::DS&A
	 */
 

	/* **********************
	 * 	  - VARIABLES -		*
	 * **********************/
	private static       int WIDTH    = 640;  // - Window Width  Size - //
	private static       int HEIGHT   = 480;  // - Window Height Size - //
	private static TopologicalSort tdfs;
	private static TopologicalSortBFS tbfs;
	public static void main(String[] args){
		
		/*
		Graph g = new Graph();
		Dijkstra d = new Dijkstra(g,g.source);
		g.readfromfile("mygraph.txt");
		BellmanFord b = new BellmanFord(g,g.source);
		
		Graph g2 = new Graph();
		g2.readfromfile("DAG3.txt");
		tbfs = new TopologicalSortBFS(g2,"a");
		System.out.println("\n\n\n");

		Graph g3 = new Graph();
		g3.readfromfile("DAG2.txt");
		tdfs = new TopologicalSort(g3,"a");
		 */
		Graph cg = new Graph();
		cg.readfromfile("CG.txt");
		Prim pa = new Prim(cg,"a");
		
		// - My Graph Drawer - //
		GraphicProcess newOBJ = new GraphicProcess(cg);
		newOBJ.setVisible(true);
		newOBJ.setResizable(false);
		newOBJ.setTitle("Graph Visualizer::BurakSahin");
		newOBJ.setSize(WIDTH, HEIGHT);
        newOBJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newOBJ.run();
	
	}
}