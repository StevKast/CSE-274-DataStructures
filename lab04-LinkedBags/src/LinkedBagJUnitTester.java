/*
 * This tests some but not all of the methods of a
 * linked representation of Bag.  This could easily
 * be used to test a resizable array-based implementation
 * of Bag since the results should be the same
 * regardless of implementation details.
 * 
 * @author Norm Krumpe
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedBagJUnitTester {

	@Test
	public void testAdd() {
		
		LinkedBag bag = new LinkedBag(); 
		boolean success;
		success = bag.add(new String("A"));
		assertTrue(success);
		assertTrue(bag.contains(new String("A")));
		assertEquals(1, bag.getCurrentSize());
		
		// Should be able to a duplicate
		success = bag.add(new String("A"));
		assertTrue(success);
		assertTrue(bag.contains(new String("A")));
		assertEquals(2, bag.getCurrentSize());
		
		success = bag.add(new String("B"));
		assertTrue(success);
		assertTrue(bag.contains(new String("B")));
		assertEquals(3, bag.getCurrentSize());		
	}
	
	@Test
	public void testContains() {
		LinkedBag bag = new LinkedBag();
		boolean found;
		
		found = bag.contains(new String("A"));
		assertFalse(found);
		
		bag.add(new String("A"));
		found = bag.contains(new String("A"));
		assertTrue(found);
		
		bag.add(new String("A"));
		bag.add(new String("B"));
		bag.add(new String("C"));
		found = bag.contains(new String("B"));
		assertTrue(found);
		found = bag.contains(new String("C"));
		assertTrue(found);
		found = bag.contains(new String("D"));
		assertFalse(found);
		
	}
	
	
	@Test
	public void testRemove() {
		LinkedBag bag = new LinkedBag();
		bag.add(new String("A"));
		bag.add(new String("A"));
		
		// Remove first A
		String result = bag.remove();
		assertEquals(result, new String("A"));
		assertFalse(bag.isEmpty());
		assertTrue(bag.contains(new String("A")));
		assertEquals(1, bag.getCurrentSize());
		
		// Remove next A
		result = bag.remove();
		assertEquals(result, new String("A"));
		assertTrue(bag.isEmpty());
		assertFalse(bag.contains(new String("A")));
		assertEquals(0, bag.getCurrentSize());
		
		// Remove from an empty bag
		result = bag.remove();
		assertNull(result);
		assertEquals(0, bag.getCurrentSize());			
	}

	@Test
	public void testRemoveArbitrary() {
		LinkedBag bag = new LinkedBag();
		bag.add(new String("A"));
		bag.add(new String("A"));
		bag.add(new String("B"));
		bag.add(new String("C"));
		bag.add(new String("B"));
		boolean success;
		
		success = bag.remove(new String("A"));		
		assertTrue(success);
		assertEquals(4, bag.getCurrentSize());
		assertTrue(bag.contains(new String("A")));
		
		success = bag.remove(new String("C"));		
		assertTrue(success);
		assertEquals(3, bag.getCurrentSize());
		assertFalse(bag.contains(new String("C")));
		
		// Removing C when there is no C
		success = bag.remove(new String("C"));		
		assertFalse(success);
		assertEquals(3, bag.getCurrentSize());
		
		success = bag.remove(new String("A"));
		assertTrue(success);
		success = bag.remove(new String("B"));
		assertTrue(success);
		
		assertEquals(1, bag.getCurrentSize());
		assertTrue(bag.contains(new String("B")));
		
		// Removing last item
		success = bag.remove(new String("B"));
		assertTrue(success);
		assertTrue(bag.isEmpty());
		
		// Removing from an empty bag
		success = bag.remove(new String("B"));
		assertFalse(success);
		assertEquals(0, bag.getCurrentSize());
	}

	@Test
	public void testClear() {
		LinkedBag bag = new LinkedBag();
		bag.clear();
		assertEquals(0, bag.getCurrentSize());
		
		bag.add(new String("A"));
		bag.add(new String("B"));
		bag.add(new String("C"));
		bag.add(new String("B"));
		
		assertEquals(4, bag.getCurrentSize());
		
		bag.clear();
		assertEquals(0, bag.getCurrentSize());
		
		// Clear empty bag
		bag.clear();
		assertEquals(0, bag.getCurrentSize());	
	}
	
	@Test
	public void testToArray() {
		LinkedBag bag = new LinkedBag();
		String[] result = bag.toArray();
		assertEquals(0, result.length);
		
		bag.add(new String("A"));
		result = bag.toArray();
		assertEquals(1, result.length);
		assertEquals(new String("A"), result[0]);
		
		bag.add(new String("A"));
		bag.add(new String("B"));
		result = bag.toArray();
		assertEquals(3, result.length);
		java.util.Arrays.sort(result);
		assertEquals(new String("A"), result[0]);
		assertEquals(new String("A"), result[1]);
		assertEquals(new String("B"), result[2]);	
		
	}

	@Test
	public void testGetFrequencyOf() {
		LinkedBag bag = new LinkedBag();
		assertEquals(0, bag.getFrequencyOf(new String("A")));
		
		bag.add(new String("A"));
		assertEquals(1, bag.getFrequencyOf(new String("A")));
		assertEquals(0, bag.getFrequencyOf(new String("B")));
		
		bag.add(new String("A"));
		bag.add(new String("B"));
		assertEquals(2, bag.getFrequencyOf(new String("A")));
		assertEquals(1, bag.getFrequencyOf(new String("B")));
		assertEquals(0, bag.getFrequencyOf(new String("C")));
	}

}
