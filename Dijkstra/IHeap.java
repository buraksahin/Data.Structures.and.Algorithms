
public interface IHeap {
	public void insert(Vertex x);
	public Vertex findMin();
	public Vertex deleteMin();
	public boolean isEmpty();
	public void makeEmpty();
	public void swap(int c, int f);
}
