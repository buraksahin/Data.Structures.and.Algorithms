import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;


public class GraphicProcess extends JFrame implements Runnable {
	
	/**
	 * GraphicProcess
	 */
	private static final long serialVersionUID = 1L;
	/* **********************
	 * 	  - VARIABLES -		*
	 * **********************/
	private static       int WIDTH    = 640;      // - Window Width  Size - //
	private static       int HEIGHT   = 480;     // - Window Height Size - //
	private static ArrayList<GraphNode>  GNode;  // - Node Render List... - //
	private Graph g;							 // - Graph - //
    private Random rand = new Random();		 	 // - Random Number - //
	
	public GraphicProcess(Graph g){
		GNode = new ArrayList<GraphNode>();
		this.g = g;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		processGraph();
	}
	
	public void processGraph(){
		int Nx=WIDTH/2, Ny=HEIGHT/2;
		GraphNode gnode;
		for(int x = 0; x < g.getGraphSize(); x++){
			gnode = new GraphNode(g.nodenames.get(x),Nx,Ny,g.getNeighbors(g.nodenames.get(x)));
			GNode.add(gnode);
			
			Nx=rand.nextInt(WIDTH-50);
			Ny=rand.nextInt(HEIGHT-50);
			if(Nx<50 || Ny<50){
				Nx=rand.nextInt(WIDTH-50);
				Ny=rand.nextInt(HEIGHT-50);
			}
			 
		}
		System.out.println("--->"+GNode.size());
	}
	
	/* ***********************
	 *    - Image & Paint - 
	 * ***********************/
	
	// - Create an Image for paint Frame - //
	
	private Image createImage(){
		
	    BufferedImage bufferedImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	    
	    Graphics g = bufferedImage.getGraphics();
	    
		// - Background Texture - //
	    g.setColor(new Color(250,255,250));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		 // - Print Balls - //
	    for(int y = 0; y < GNode.size(); y++){
	    	GNode.get(y).draw(g,GNode);
			}

		return bufferedImage;
	  }
	  
	
	// - Paint - //
	@Override
	public void paint(Graphics g){
		Image img = createImage();
		g.drawImage(img, 0,0,this);
	}


}
