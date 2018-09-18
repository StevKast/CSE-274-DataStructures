import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T> {
    
	private T[] stack;
	private int top;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(){
		stack =  (T[]) new Object[DEFAULT_CAPACITY];
		capacity = DEFAULT_CAPACITY;
		top = 0;
	}
	
	@Override
    public void push(T newEntry) {
		if(top == capacity){
			stack = Arrays.copyOf(stack, capacity * 2);
		}
		stack[top] = newEntry;
		top++;
    }

    @Override
    public T pop() throws EmptyStackException{
    	if(isEmpty()){
    		throw new EmptyStackException();
    	}else{
    	top--;
        return stack[top];
    	}
    }

    @Override
    public T peek() throws EmptyStackException{
        if(isEmpty()){
        	throw new EmptyStackException();
        }else{
        	return stack[top - 1];
        }
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void clear() {
    	top = 0;
    }
}
