/**
 * Your implementation of the LookupInterface.  The only public methods
 * in this class should be the ones that implement the interface.  You
 * should write as many other private methods as needed.  Of course, you
 * should also have a public constructor.
 * 
 * @author Steven Kast, kastsm
 * It takes about 4 minutes to run the text file tests
 */
  
 
public class StudentLookup implements LookupInterface {

	PriorityQueue q;
	HashMap map;

	public StudentLookup() {
		q = new PriorityQueue();
		map = new HashMap();
	}

	@Override
	public void addString(int amount, String s) {
		Word word = new Word(s);
		word.increaseFrequency(amount);

		map.put(word, amount);
		q.add(word);
		
	}

	@Override
	public int lookupCount(String s) {
		Word word = new Word(s);
		if(map.get(word) == null){
			return 0;
		}
		return map.get(word).getFrequency();
	}

	@Override
	public String lookupPopularity(int n) {

		return q.find(n).getData();

	}

	@Override
	public int numEntries() {
		return q.getSize();
	}
    
}
