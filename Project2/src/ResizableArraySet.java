import java.util.Arrays;

public class ResizableArraySet implements SetInterface {

    private int[] ints;
    private int entriesCount = 0;

    public ResizableArraySet(){
        ints =  new int[10];
    }

    public ResizableArraySet(int size){
        ints = new int[size];
    }

    @Override
    public int getSize() {
        return entriesCount;
    }

    @Override
    public boolean isEmpty() {
        return entriesCount == 0;
    }

    @Override
    public boolean add(int newValue) {
        if(contains(newValue)){
            return false;
        }
        if((entriesCount + 1) == ints.length){
            ints = Arrays.copyOf(ints, ints.length * 2);
        }
        ints[entriesCount] = newValue;
        entriesCount++;
        return true;
    }

    @Override
    public boolean remove(int aValue) {
        if(contains(aValue)) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == aValue) {
                    ints[i] = remove();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int remove() {
        int removed = ints[entriesCount];
        entriesCount--;
        return removed;
    }

    @Override
    public void clear() {
        entriesCount = 0;
    }

    @Override
    public boolean contains(int anEntry) {
        for(int i = 0; i < entriesCount; i++){
            if(ints[i] == anEntry){
                return true;
            }
        }
        return false;
    }

    @Override
    public SetInterface union(SetInterface anotherSet) {
        for (int n: anotherSet.toArray()) {
            add(n);
        }
        return this;
    }

    @Override
    public SetInterface intersection(SetInterface anotherSet) {
        clear();
        for(int n : ints){
            if(anotherSet.contains(n)){
                add(n);
            }else{
                remove(n);
            }
        }
        return this;
    }

    @Override
    public SetInterface difference(SetInterface anotherSet) {
        for (int n : anotherSet.toArray()) {
            remove(n);
        }
        return this;
    }

    @Override
    public int[] toArray() {
        int[] ret = new int[entriesCount];
        for(int i = 0; i < ret.length; i++){
            ret[i] = ints[i];
        }
        return ret;
    }
}
