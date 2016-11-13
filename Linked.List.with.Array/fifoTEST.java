import static org.junit.Assert.*;
import org.junit.Test;
/**
 * 
 * @author burak_sahin
 * 
 */
public class fifoTEST {

	@Test
	public void testEqueue() {
		FIFO f = new FIFO(10);
		f.equeue(5);
		assertEquals(f.isEmpty(),false);

	}

	@Test
	public void testDequeue() {
		FIFO f = new FIFO(10);
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
