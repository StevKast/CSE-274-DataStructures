import static org.junit.Assert.*;
import org.junit.Test;

public class SetTester {

    @Test
    public void getCurrentSize() {
        SortedSet set = new SortedSet();
        set.add("apple");
        assertEquals(1, set.getCurrentSize());
        set.add("bacon");
        set.add("bacon");
        assertEquals(2, set.getCurrentSize()); //Ignores duplicates
    }

    @Test
    public void isEmpty() {
        SortedSet set = new SortedSet();
        assertTrue(set.isEmpty());
        set.add("Apples");
        assertFalse(set.isEmpty());
    }

    @Test
    public void add() {
        SortedSet set = new SortedSet();
        assertTrue(set.add("Apple"));
        assertTrue(set.add("Banana"));
        assertTrue(set.add("Carrot"));
        assertTrue(set.add("Date"));
        assertTrue(set.add("Apricot"));

        assertFalse(set.add("Apple"));//Check for adding duplicates

        assertEquals("[Apple Apricot Banana Carrot Date]", set.toString());
    }

    @Test
    public void removeSpecific() {
        SortedSet set = new SortedSet();
        set.add("Apple");
        set.add("Banana");
        set.add("Carrot");
        set.add("Date");
        assertTrue(set.remove("Apple"));
        assertFalse(set.remove("Apple")); //Can't remove item that doesn't exist
        assertTrue(set.remove("Carrot"));
    }

    @Test
    public void remove() {
        SortedSet set = new SortedSet();
        set.add("Apple");
        set.add("Banana");
        set.add("Carrot");
        assertEquals("Apple", set.remove());
        assertEquals("Banana", set.remove());
        assertEquals("Carrot", set.remove());
    }

    @Test
    public void clear() {
        SortedSet set = new SortedSet();
        set.add("Apple");
        set.add("Banana");
        set.add("Carrot");
        set.clear();
        assertEquals(0, set.getCurrentSize());
    }

    @Test
    public void contains() {
        SortedSet set = new SortedSet();
        set.add("Apple");
        set.add("Banana");
        set.add("Carrot");
        assertTrue(set.contains("Apple"));
        assertTrue(set.contains("Banana"));
        assertTrue(set.contains("Carrot"));
        assertFalse(set.contains("My Social Security Number")); //Is not in set
    }

    @Test
    public void toArray() {
        SortedSet set = new SortedSet();
        set.add("Apple");
        set.add("Banana");
        set.add("Carrot");
        String[] arr = new String[] {"Apple", "Banana", "Carrot"};
        assertArrayEquals(arr, set.toArray());
    }

}