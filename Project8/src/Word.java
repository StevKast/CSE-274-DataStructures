/**
 * 
 * @author Steven Kast, kastsm
 *
 */
public class Word implements Comparable<Word>{
	
	private String data;
	private int frequency;
	
	public Word(String word){
		data = word;
	}
	
	public Word(String word, int frequency){
		data = word;
		this.frequency = frequency;
	}
	
	public void setFrequency(int num){
		frequency = num;
	}

	public int getFrequency(){
		return frequency;
	}

	public void increaseFrequency(int num){
		frequency = frequency + num;
	}

	public String getData() {
		return data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Word word = (Word) o;

		return data != null ? data.equals(word.data) : word.data == null;
	}

	@Override
	public int hashCode() {
		return data != null ? data.hashCode() : 0;
	}

	@Override
	public int compareTo(Word o) {
		Integer freqA = frequency;
		Integer freqB = o.getFrequency();
		if(freqA.compareTo(freqB) == 0){
			return o.data.compareTo(data);
		}
		return freqA.compareTo(freqB);
	}
}
