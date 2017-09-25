import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestMaxHeap {

	MaxHeap heap=new MaxHeap();
	
	@After
	public void teardown(){
		heap.clear();
	}
	
	@Test
	public void testAdd() {
		assertTrue(heap.getSize()==0);
		
		heap.add("AAA");
		assertTrue(heap.getSize()==1);
		assertTrue(heap.getMax()=="AAA");
		
		heap.add("BBB");
		assertTrue(heap.getSize()==2);
		assertTrue(heap.getMax()=="BBB");
		assertEquals("\nBBB\nAAA",heap.display());
		
		heap.add("DDD");
		assertEquals("\nDDD\nAAA\nBBB",heap.display());
		
		heap.add("CCC");
		assertEquals("\nDDD\nCCC\nBBB\nAAA",heap.display());
		
		heap.add("ABB");
		assertEquals("\nDDD\nCCC\nBBB\nAAA\nABB",heap.display());
		
		
	}
	
	@Test
	public void testRemove(){
		heap.add("AAA");
		heap.add("BBB");
		heap.add("DDD");
		heap.add("CCC");
		heap.add("ABB");
		System.out.print(heap.display());
	    assertEquals("DDD",heap.removeMax());
	    System.out.print(heap.display());
	    assertEquals("CCC",heap.getMax());
	    assertEquals(4,heap.getSize());
	    
	    assertEquals("CCC",heap.removeMax());
	    assertEquals("BBB",heap.getMax());
	    assertEquals(3,heap.getSize());
	}
	
	@Test
	public void testClearAndEmpty(){
		heap.add("AAA");
		heap.add("BBB");
		heap.add("DDD");
		heap.add("CCC");
		heap.add("ABB");
		assertEquals(false,heap.isEmpty());
		heap.clear();
		assertEquals(0,heap.getSize());
		assertEquals(true,heap.isEmpty());
	}

}
