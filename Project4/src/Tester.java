import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		//TODO: Make sure method names are right
		//TODO: Note what works and doesn't

		Scanner in = new Scanner(System.in);
		String infixStr = "";

		System.out.println("Infix Expression: ");
		infixStr = in.nextLine();
		try{
			InfixExpression inf = new InfixExpression(infixStr);
			System.out.println(inf.getPostfixExpression());
			System.out.println(inf.evaluate());
		}catch(IllegalArgumentException e){
			System.out.println("Failed: Invalid expression!");
		}

	}

	public static void ownTester(){

		InfixExpression exp1 = new InfixExpression("2+  2    /    2  -(  2+2 *3  )   ");

		System.out.println(exp1);

		InfixExpression exp2 = new InfixExpression("( 5 + 4) / (4 - 1  )");

		System.out.println(exp2 + "\n" + exp2.getPostfixExpression() + "\n" + exp2.evaluate());


		ArrayStack<String> stack = new ArrayStack();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
