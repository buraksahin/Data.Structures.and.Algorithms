
public class Neighbor {
	int weight;
	String NodeID;

	public Neighbor(String nodeID,int weight) {
		this.weight = weight;
		this.NodeID = nodeID;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getNodeID() {
		return NodeID;
	}
	public void setNodeID(String nodeID) {
		NodeID = nodeID;
	}
	
	
}
