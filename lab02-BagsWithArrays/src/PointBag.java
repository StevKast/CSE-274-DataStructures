import java.awt.Point;
import java.util.Arrays;

/**
 * An array based implementation of Bag. This will be a bag of Point objects.
 * The bag will have a limited size.
 * 
 * @author Steven Kast, kastsm
 *
 */
public class PointBag implements BagInterface<Point> {

	private Point[] points;
	private int size;

	private final static int DEFAULT_CAP = 7;

	/**
	 * Constructs an empty bag with specified capacity.
	 * 
	 * @param capacity
	 *            the maximum number of items in the bag.
	 */
	public PointBag(int capacity) {
		points = new Point[capacity];
		size = 0;
	}

	/**
	 * Constructs an empty bag with a default capacity (7)
	 */
	public PointBag() {
		this(DEFAULT_CAP);
	}

	/**
	 * Returns the current size of the bag.
	 */
	@Override
	public int getCurrentSize() {
		return size;
	}

	/**
	 * @return true if the bag is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Add the specified point to the bag. 
	 * @return true if add was successful, false otherwise.
	 */
	@Override
	public boolean add(Point newEntry) {
		if (size < points.length) {
			points[size] = newEntry;
			size++;
			return true;
		}
		//Returns if bag is full.
		return false;
	}

	/**
	 * @return an arbitrary item form the bag.
	 * If the bag is empty null with be returned.
	 */
	@Override
	public Point remove() {
		if(size == 0) {
			return null;
		}
		Point result = points[size - 1];
		points[size - 1] = null;
		size--;
		return result;
	}

	/**
	 * Removes a particular item from the bag.
	 * @return true if successful
	 */
	@Override
	public boolean remove(Point anEntry) {
		for(int i = 0; i < points.length; i++) {
			if(points[i].equals(anEntry)){
				points[i] = remove();
				return true;
			}
		}
		return false;
	}

	/**
	 * Clears the bag of all contents
	 */
	@Override
	public void clear() {
		for(Point pnt : points) {
			pnt = null;
		}
		size = 0;
	}

	/**
	 * Counts the frequency of a certain point in a bag.
	 * @param point to check frequency of.
	 * @return the frequency of the point.
	 */
	@Override
	public int getFrequencyOf(Point anEntry) {
		int freq = 0;
		for(Point point : points) {
			if(point.equals(anEntry)) {
				freq++;
			}
		}
		return freq;
	}

	/**
	 * Checks if the bag contains a certain point.
	 * @param point to find
	 * @return true if found false otherwise
	 */
	@Override
	public boolean contains(Point anEntry) {
		if(getFrequencyOf(anEntry) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @return the bag as an array.
	 */
	@Override
	public Point[] toArray() {
		int counter = 0;
		for(Point point : points){
			if(point != null){
				counter++;
			}
		}
		
		Point[] a = new Point[counter];
		
		for(int i = 0; i < a.length; i++){
			a[i] = points[i];
		}
		return a;
	}
	
	/**
	 * @return the bag as a string.
	 */
	public String toString(){
		String result = Arrays.toString(points) + " size = " + size;
		return result;
	}

}
