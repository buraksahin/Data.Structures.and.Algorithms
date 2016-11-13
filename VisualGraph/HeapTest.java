import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {

	@Test
	public void testInsert() {
		Heap h = new Heap();
		h.insert(new Vertex("a"));
		assertEquals(h.isEmpty(),false);
	}

	@Test
	public void testRemoveVertex() {
		Heap h = new Heap();
		h.insert(new Vertex("a"));
		h.removeVertex("a");
		assertEquals(h.isEmpty(),true);
	}

}
