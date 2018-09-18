import static org.junit.Assert.*;
import java.util.Stack;

import org.junit.Test;

public class StackProblemTest {

	@Test
	public void testSumTo99() {
		Stack<Integer> nums = new Stack<>();
		assertEquals("Failed on empty stack.", 0, StackProblems.sumTo99(nums));
		nums.push(99);
		assertEquals("Failed on stack containing just 99", 0, StackProblems.sumTo99(nums));

		for (int count = 1; count <= 20; count++) {
			nums.clear();
			int randomSize = 10 + (int) (20 * Math.random());
			int sumSinceLast99 = 0;

			for (int i = 0; i < randomSize; i++) {
				if (Math.random() > .8) {
					nums.push(99);
					sumSinceLast99 = 0;
				} else {
					int num = (int) (5 * Math.random() + 1);
					sumSinceLast99 += num;
					nums.push(num);
				}
			}
			@SuppressWarnings("unchecked")
			Stack<Integer> numsCopy = (Stack<Integer>) (nums.clone());
			assertEquals("Failed on " + numsCopy.toString(), sumSinceLast99, StackProblems.sumTo99(nums));
		}

	}

	@Test
	public void testSumSkipDuplicates() {
		int[] data = { 4, 1, 2, 2, 7, 2, 8, 8, 8, 4 };
		Stack<Integer> stack = new Stack<>();
		for (int num : data) {
			stack.push(num);
		}
		assertEquals(28, StackProblems.sumSkipDuplicates(stack));

		data = new int[] { 1, 2, 3, 4, 5, 6 };
		stack = new Stack<>();
		for (int num : data) {
			stack.push(num);
		}
		assertEquals(21, StackProblems.sumSkipDuplicates(stack));

		data = new int[] { 1, 1, 1, 1, 1 };
		stack = new Stack<>();
		for (int num : data) {
			stack.push(num);
		}
		assertEquals(1, StackProblems.sumSkipDuplicates(stack));

		data = new int[] { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6 };
		stack = new Stack<>();
		for (int num : data) {
			stack.push(num);
		}
		assertEquals(21, StackProblems.sumSkipDuplicates(stack));

		data = new int[] {};
		stack = new Stack<>();
		for (int num : data) {
			stack.push(num);
		}
		assertEquals(0, StackProblems.sumSkipDuplicates(stack));

	}

	@Test
	public void testStringToStack() {
		String testString = "This is a test string.";
		Stack<Character> result = StackProblems.stringToStack(testString);

		String resultString = "";
		while (!result.isEmpty()) {
			resultString = result.pop() + resultString;
		}

		assertEquals(testString, resultString);
	}

	@Test
	public void testEmptyStringToStack() {
		String testString = "";
		Stack<Character> result = StackProblems.stringToStack(testString);
		assertEquals(0, result.size());
	}

	@Test
	public void testCopyStack() {
		// Test an empty stack
		Stack<Integer> empty = new Stack<>();
		Stack<Integer> result = StackProblems.copyStack(empty);
		
		assertNotSame(empty, result);
		assertTrue(result.isEmpty());		
		assertTrue(empty.isEmpty());
		
		int[] data = new int[50];
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (10 * Math.random());
		}

		Stack<Integer> start = new Stack<>();
		for (int num : data) {
			start.push(num);
		}
		result = StackProblems.copyStack(start);

		for (int i = data.length - 1; i >= 0; i--) {
			int val = data[i];
			assertEquals("Modified orig. array", val, (int) start.pop());
			assertEquals("Copy failed", val, (int) result.pop());
		}

	}

	@Test
	public void testReverseStack() {
		// Test an empty stack
		Stack<Integer> empty = new Stack<>();
		StackProblems.reverseStack(empty);
		assertTrue(empty.isEmpty());

		int[] data = new int[50];
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (10 * Math.random());
		}

		Stack<Integer> start = new Stack<>();
		for (int num : data) {
			start.push(num);
		}

		StackProblems.reverseStack(start);

		for (int num : data) {
			assertEquals(num, (int) start.pop());
		}

		assertEquals(0, start.size());

	}

	@Test
	public void testIsPalindrome() {
		assertTrue(StackProblems.isPalindrome("a"));
		assertTrue(StackProblems.isPalindrome("BB"));
		assertTrue(StackProblems.isPalindrome("CCC"));
		assertTrue(StackProblems.isPalindrome("radar"));
		assertTrue(StackProblems.isPalindrome("racecar"));
		assertTrue(StackProblems.isPalindrome("tattarrattat"));

		assertFalse(StackProblems.isPalindrome("ab"));
		assertFalse(StackProblems.isPalindrome("abab"));
		assertFalse(StackProblems.isPalindrome("baaa"));
	}

}
