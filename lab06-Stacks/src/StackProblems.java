import java.util.ArrayList;
import java.util.Stack;

public class StackProblems {

	public static void main(String[] args) {
		Stack<Integer> nums = new Stack<>();
		nums.push(4);
		nums.push(6);
		nums.push(5);
		nums.push(5);
		nums.push(5);
		System.out.println(sumSkipDuplicates(nums));
		
		
		
	}

	/*
	 * Computes the sum of all the numbers in the stack before the first 99 is
	 * encountered. If no 99 is encountered, just add everything in the stack.
	 */
	public static int sumTo99(Stack<Integer> data) {
		int sum = 0;
		while(!data.isEmpty() && data.peek() != 99){
			sum += data.pop();
		}
		return sum;
	}

	/*
	 * Computes the sum of all the numbers in the stack. However, if two or more
	 * numbers IN A ROW are equal, only add one of them. So, for example, if the
	 * stack contained 4, 1, 2, 2, 7, 2, 8, 8, 8, 4, then the numbers that would be
	 * added would be 4 + 1 + 2 + 7 + 2 + 8 + 4 = 28
	 */
	public static int sumSkipDuplicates(Stack<Integer> data) {
		int sum = 0;
		int last = 0;

		while(!data.isEmpty()) {
			last = data.peek();
			sum += data.pop();
			while(!data.isEmpty() && data.peek() == last)
				data.pop();
		}

		return sum;
	}

	/*
	 * Puts all of the characters of a string into a stack, with the first character
	 * of the string at the bottom of the stack and the last character of the string
	 * at the top of the stack.
	 */
	public static Stack<Character> stringToStack(String s) {
		Stack<Character> chars = new Stack<>();
		
		for(int i = 0; i < s.length(); i++){
			chars.push(s.charAt(i));
		}
		return chars;

	}

	/*
	 * Copies a given stack, returning a new stack with the same values.
	 * Though your method might modify the original stack, the original
	 * stack should be returned to its original state before the method
	 * ends.
	 */
	public static Stack<Integer> copyStack(Stack<Integer> s) {
		Stack<Integer> newStack = new Stack<>();
		Stack<Integer> holder = new Stack<>();
		while(!s.isEmpty()){
			holder.push(s.pop());
		}
		while(!holder.isEmpty()){
			newStack.push(holder.peek());
			s.push(holder.pop());
		}
		
		return newStack;
		
	}
	
	
	/*
	 * Reverses a given stack, so that the top of the stack becomes the bottom and
	 * the bottom becomes the top.
	 */
	public static void reverseStack(Stack<Integer> s) {
		Stack<Integer> holder = new Stack<>();
		Stack<Integer> reversedStack = new Stack<>();

		while(!s.isEmpty()) {
			holder.push(s.pop());
		}

		while(!holder.isEmpty()) {
			reversedStack.push(holder.pop());
		}

		while(!reversedStack.isEmpty()) {
			s.push(reversedStack.pop());
		}

	}

	/*
	 * A palindrome reads the same forward and backward. Use a stack to determine if
	 * a given string is a palindrome. Challenge: try not to use any additional
	 * variables (except a counter for any loop). Just the given string and a stack
	 * of Characters.
	 */
	public static boolean isPalindrome(String s) {
		Stack<Character> stack = stringToStack(s);

		for(int i = 0; i < s.length(); i++) {
			if(stack.pop() != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
