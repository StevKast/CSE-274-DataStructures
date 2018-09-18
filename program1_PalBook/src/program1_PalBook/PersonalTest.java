package program1_PalBook;

import java.util.Arrays;

public class PersonalTest {

	public static void main(String[] args) {
		
		PalBook net = new PalBook(8);
		
		net.addMember("Abe");
		net.addMember("Breen");
		net.addMember("Zacks");
		net.addMember("Che");
		net.addMember("Lawn");
		net.addMember("Steve");
		net.addMember("Xi");
		net.addMember("Loner");
		
		System.out.println("Testing add over member limit, false?: " + net.addMember(""));
		net.removeMember("John"); //Will crash if failed
		
		System.out.println(net);
		
		net.makePals("Abe", "Breen");
		net.makePals("Abe", "Zacks");
		net.makePals("Abe", "Che");
		net.makePals("Breen", "Lawn");
		net.makePals("Lawn", "Steve");
		net.makePals("Steve", "Xi");
		
		System.out.println("Testing bad makePals, false?: " + net.makePals("Abe", "John") + "\n");
		
		System.out.println("List Abes Pals " + Arrays.toString(net.getPals("Abe")));
		
		System.out.println("List Che Pals " + Arrays.toString(net.getPals("Che")));

		System.out.println("List Lawns Pals " + Arrays.toString(net.getPals("Lawn")));
		
		System.out.println();
		System.out.println(net);
		
		//System.out.println(Arrays.toString(net.getPalsOfPals("Abe")));
		
		System.out.println("Deg of sep [Expected: 4]");
		System.out.println(net.degreesOfSeparation("Abe", "Xi"));
		
		System.out.println("Deg of sep [Expected: 2]");
		System.out.println(net.degreesOfSeparation("Abe", "Lawn"));
		
		System.out.println("Deg of sep [Expected: 1]");
		System.out.println(net.degreesOfSeparation("Abe", "Breen"));
		
		System.out.println("Deg of sep [Expected: 1]");
		System.out.println(net.degreesOfSeparation("Abe", "Che"));
		
		System.out.println("Deg of sep [Expected: -1]");
		System.out.println(net.degreesOfSeparation("Zacks", "Loner"));
		
		System.out.println("Testing members with degree for Abe:");
		
		System.out.println("Deg 1:" + Arrays.toString(net.membersWithDegree("Abe", 1)));
		System.out.println("Deg 2:" + Arrays.toString(net.membersWithDegree("Abe", 2)));
		System.out.println("Deg 3:" + Arrays.toString(net.membersWithDegree("Abe", 3)));
		System.out.println("Deg 4:" + Arrays.toString(net.membersWithDegree("Abe", 4)));
		

		System.out.println("\nTesting areConnected:");
		System.out.println("False?: " + net.areConnected("Che", "Loner"));
		System.out.println("True?: " + net.areConnected("Abe", "Xi"));
		
		System.out.println("\n*********\nEND");
		
		
	}

}
