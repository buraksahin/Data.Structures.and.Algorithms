import java.util.LinkedList;

public class Vertex {
	String VName;
	LinkedList<Neighbor> Neighbors = new LinkedList<>();
	String Color="white";
	int distance = 0;
	String PName = "";
	
	public Vertex(String VName){
	this.VName = VName;
	}
	
	public String getVName() {
		return VName;
	}
	
	public void setVName(String vName) {
		VName = vName;
	}
	
	public LinkedList<Neighbor> getNeighbors() {
		return Neighbors;
	}
	
	public void setNeighbors(LinkedList<Neighbor> neighbors) {
		Neighbors = neighbors;
	}
	
	public void addNeigh(String x, int w){
		Neighbors.add(new Neighbor(x,w));
	}
	public String getNeigh(int index){
		return Neighbors.get(index).getNodeID();
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}
	
	
}