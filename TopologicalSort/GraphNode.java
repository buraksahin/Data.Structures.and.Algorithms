 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class GraphNode extends Thread{
	
	/* **********************
	 * 	  - VARIABLES -		*
	 * **********************/
	private String name;        // - Name of the node
	private int x;			    // - represents the x coordinate
	private int y;			    // - represents the y coordinate
	private int radius;		    // - radius of the ball
	private Color color;        // - Color  of the ball
	private Color colorx;		// - Color  of the texture
	private LinkedList<Neighbor> neigh;
	Font xFont;
	private Random rand = new Random();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 
	}// *<-- end of the run --> //
	
	
	
	/* *********************
	 * - Ball Constructors -
	 * *********************/ 
	
	public GraphNode(String name,int x, int y, LinkedList<Neighbor> neigh) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.neigh = neigh;
		this.radius = 50;
		colorx = new Color(rand.nextInt(120), rand.nextInt(40), rand.nextInt(80));
		this.color  =  new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
		xFont = new Font("TimesRoman",Font.BOLD,22);
		 
	}
	
	/* *********
	 * - Paint - 
	 * *********/
	
	public void draw(Graphics g, ArrayList<GraphNode> gNodes) {
        // - Paint Ball  - //
		g.setColor(new Color(32,32,32));
        g.fillOval(x-radius/2, y-radius/2, radius, radius);
        g.setColor(color);
        g.fillOval(x-radius/2+4, y-radius/2+4, radius-8, radius-8);
        
        // - Write Thread Id on the Ball - //
        g.setColor(colorx);
        xFont = new Font("TimesRoman",Font.BOLD,radius/4);
        g.setFont(xFont);
        g.drawString("id: " + this.getNameN(), x-8, y+4);
        
        for(int j=0; j<neigh.size(); j++){
        	int neighXY[] = getNeighC(neigh.get(j).NodeID,gNodes);
        	g.drawLine(x, y,neighXY[0],neighXY[1]);
        }
        
        
    }
	
	public int[] getNeighC(String namex, ArrayList<GraphNode> gNodes){
		int[] result = new int[2];
		for(int j=0; j<gNodes.size(); j++){
			if(gNodes.get(j).name==namex){
				result[0]=gNodes.get(j).getX();
				result[1]=gNodes.get(j).getY();
				break;
			}
		}
		return result;
	}  
 
	/* **********************
	 *  - Getters & Setters -
	 * **********************/
 
	
	public int getX() {
		return x;
	}
	public String getNameN() {
		return name;
	}
	public void setNameN(String name) {
		this.name = name;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
 
}// *<--end of the Class -->* //
