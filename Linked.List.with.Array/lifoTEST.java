import static org.junit.Assert.*;
import org.junit.Test;
/**
 * 
 * @author burak_sahin
 * 
 */
public class lifoTEST {

	@Test
	public void testEqueue() {
		LIFO f = new LIFO(10);
		f.equeue(5);
		assertEquals(f.isEmpty(),false);

	}

	@Test
	public void testDequeue() {
		LIFO f = new LIFO(10);
		f.equeue(5);
		f.dequeue();
		assertEquals(f.isEmpty(),true);
	}

	@Test
	public void testIsEmpty() {
		FIFO f = new FIFO(10);
		assertEquals(f.isEmpty(),true);
	}

}
