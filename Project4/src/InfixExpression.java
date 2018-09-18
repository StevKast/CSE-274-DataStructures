import java.util.Scanner;

public class InfixExpression {

	private String infix;

	/**
	 * Constructs a new InfixExpression object.
	 * @param input Infix expression that gets cleaned and checked for validity.
	 * @throws IllegalArgumentException Thrown if argument is not a valid infix expression.
	 */
	public InfixExpression(String input) throws IllegalArgumentException {
		infix = input;
		clean();
		
		if(!isValid()){
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns the infix expression.
	 * @return the infix expression as a string.
	 */
	@Override
	public String toString() {
		return infix;
	}

	private boolean isBalanced() {
		boolean isBalanced = true;
		ArrayStack<Character> openDelimiterStack = new ArrayStack<Character>();
		int index = 0;
		int charCount = infix.length();
		char nextChar = ' ';

		while (isBalanced && (index < charCount)) {
			nextChar = infix.charAt(index);
			switch (nextChar) {
			case '(':
				openDelimiterStack.push(nextChar);
				break;
			case ')':
				if (openDelimiterStack.isEmpty()) {
					isBalanced = false;
				} else {
					char openDelim = openDelimiterStack.pop(); //Throws null when true is expected
					isBalanced = isPaired(openDelim, nextChar);
				}
				break;
			default: break;
			} //end switch statement
			index++;
		}//end loop
		
		if(!openDelimiterStack.isEmpty()){
			isBalanced = false;
		}
		return isBalanced;
	}

	/**
	 * Checks to see if two characters are paired parentheses.
	 * @param open first character to be checked
	 * @param close seconds character to be checked
	 * @return True if open and close are matching parentheses.
	 */
	private static boolean isPaired(char open, char close) {
		return (open == '(' && close == ')');
	}

	/**
	 * Checks to see if the infix string is a valid expression.
	 * @return returns true if valid.
	 */
	private boolean isValid(){
		Scanner in = new Scanner(infix);
		String nextToken = "";
		int iter = 0; //Used for checking if first item is an operator
		ArrayStack<String> opStack = new ArrayStack();
		
		while(in.hasNext()){
			nextToken = in.next();
			iter ++;

			if(nextToken.matches("\\d+")){
				if(!opStack.isEmpty() && opStack.peek().matches("\\d+")){
					return false;
				}
				opStack.push(nextToken);
			}else if(nextToken.matches("[+\\-*/%^]")){
				if(!opStack.isEmpty() && opStack.peek().matches("[+\\-*/%^]")
						|| iter == 1){
					return false;
				}
				opStack.push(nextToken);
			}
		}//end while
		
		return isBalanced();
	}

	/**
	 * Cleans the entered infix expression and formats it to be easily digested.
	 */
	private void clean() {
		// I used regex because I learned it from another project I've done.
		infix = infix.replaceAll("\\+", " + ");
		infix = infix.replaceAll("-", " - ");
		infix = infix.replaceAll("\\*", " * ");
		infix = infix.replaceAll("/", " / ");
		infix = infix.replaceAll("%", " % ");
		infix = infix.replaceAll("\\^", " ^ ");
		infix = infix.replaceAll("\\(", " ( ");
		infix = infix.replaceAll("\\)", " ) ");
		
		// Replaces all whitespace with a single space.
		infix = infix.replaceAll("\\s+", " "); 
		
		infix = infix.trim(); // Clears trailing whitespace.
	}

	/**
	 * Converts the infix expression to postfix.
	 * @return the postfix expression as a string.
	 */
	public String getPostfixExpression(){
		ArrayStack<String> opStack = new ArrayStack();
		String postfix = "";
		Scanner in = new Scanner(infix);
		String nextToken = "";
		String topOp = "";
		
		while(in.hasNext()){
			nextToken = in.next();
			switch(nextToken){
			case "^":
				opStack.push(nextToken);
				break;
			case "+": case "-": case "*": case"/":
				while(!opStack.isEmpty() &&
						getPrecedence(nextToken) <= getPrecedence(opStack.peek())){
					postfix += opStack.peek() + " ";
					opStack.pop();
				}
				opStack.push(nextToken);
				break;
			case "(":
				opStack.push(nextToken);
				break;
			case ")":
				topOp = opStack.pop();
				while(!topOp.equals("(")){
					postfix += topOp + " ";
					topOp = opStack.pop();
				}
				break;
			default: postfix += nextToken + " ";
			}//End switch
		} //End while
		
		while(!opStack.isEmpty()){
			topOp = opStack.pop();
			postfix += topOp + " ";
		}
		
		in.close();
		return postfix.trim();
	}

	/**
	 * Gets the precedence of an operator. '*, /, %' are value 2,
	 * '+, -' are value 1, all else are 0.
	 * @param operator operator to check
	 * @return the value of precedence.
	 */
	private int getPrecedence(String operator) {
		if(operator.equals("*") || operator.equals("/") || operator.equals("%"))
			return 2;
		else if(operator.equals("+") || operator.equals("-"))
			return 1;
		else return 0;
	}

	/**
	 * Evaluates the postfix expression.
	 * @return the value of the expression.
	 */
	public int evaluate(){
		ArrayStack<Integer> valueStack = new ArrayStack();
		Scanner in = new Scanner(getPostfixExpression());
		String nextToken = "";
		
		while(in.hasNext()){
			nextToken = in.next();
			switch(nextToken){
			case "+": case "-": case "*": case "/": case "^": case "%":
				int opTwo = valueStack.pop();
				int opOne = valueStack.pop();
				int result = calculate(opOne, opTwo, nextToken);
				valueStack.push(result);
				break;
			default: 
				valueStack.push(Integer.parseInt(nextToken));
				break;
			}
		}
		
		in.close();
		return valueStack.peek();
	}

	/**
	 * Calculates a basic math equation.
	 * @param operandOne First operand.
	 * @param operandTwo Second operand.
	 * @param operator Operation to do.
	 * @return Value of operation.
	 */
	private int calculate(int operandOne, int operandTwo, String operator){
		switch(operator){
		case "+":
			return operandOne + operandTwo;
		case "-":
			return operandOne - operandTwo;
		case "*":
			return operandOne * operandTwo;
		case "/":
			return operandOne / operandTwo;
		case "%":
			return operandOne % operandTwo;
		case "^":
			return (int) Math.pow(operandOne, operandTwo);
		default: break;
		}
		return -1;
	}

}
