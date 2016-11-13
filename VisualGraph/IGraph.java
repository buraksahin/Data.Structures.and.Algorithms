
public interface IGraph {
	public void addVertex(Vertex v);
	public void removeVertex(String NodeID);
	public void addNeighbor(String NodeID, String Neighbor, int Weight);
	public void removeNeighbor(String NodeID, String Neighbor);
	public void readfromfile(String path);
}