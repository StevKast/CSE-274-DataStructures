import java.awt.Point;
import java.util.Arrays;

public class PointBagTester {

	public static void main(String[] args) {
		PointBag bag = new PointBag(5);

		// Add some points
		bag.add(new Point(1, 1));
		bag.add(new Point(2, 2));
		bag.add(new Point(3, 3));
		bag.add(new Point(4, 4));
		
		System.out.println(bag);

		// Print this next one. It should print true because the add is
		// successful
		System.out.println("true? " + bag.add(new Point(2, 2)));

		// This should print false because the bag is full
		System.out.println("false? " + bag.add(new Point(6, 6)));

		// Show the contents
		System.out.println(bag);
		
		// Check the contents of the bag:
		System.out.println("true? " + bag.contains(new Point(1, 1)));
		System.out.println("false? " + bag.contains(new Point(10, 10)));
		System.out.println("size 5? " + bag.getCurrentSize());
		System.out.println("frequency of (1,1) is 1? " + bag.getFrequencyOf(new Point(1, 1)));
		System.out.println("frequency of (2,2) is 2? " + bag.getFrequencyOf(new Point(2, 2)));
		System.out.println("frequency of (0,0) is 0? " + bag.getFrequencyOf(new Point(0, 0)));
		
		// Test remove methods:
		System.out.println("\ntesting remove methods");
		Point removed = bag.remove();
		System.out.println("removed point: " + removed);
		System.out.println("Bag after removal: " + bag);
		
		// Let's remove the other (2, 2):
		System.out.println("\nremoving (2,2) should be success: " + bag.remove(new Point(2, 2)));
		System.out.println("Bag after removal: " + bag);
		
		// Does toArray work?
		System.out.println("\nTesting toArray()");
		System.out.println(Arrays.toString(bag.toArray()));
		
		// Keep removing points until empty:
		System.out.println("\nremoving remaining points");
		while (!bag.isEmpty()) {
			bag.remove();
			System.out.println(bag);
		}
		
		
		
	}

}
