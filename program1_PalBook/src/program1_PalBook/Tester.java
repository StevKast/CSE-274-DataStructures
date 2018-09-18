
/*
 * This is just the beginning of testing.  It does not test all the methods.
 * Feel free to use this in any way you want, or ignore it and create your own tester.
 * Note that if my tester does not compile, it indicates a problem with one
 * of your methods or constructors. 
 * 
 */

package program1_PalBook;

import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {

		System.out.println("An empty network:");
		PalBook sn = new PalBook();
		System.out.println(sn);

		System.out.println("Add Norm and his siblings:");
		boolean result;
		result = sn.addMember("Norm");
		sn.addMember("Don");
		sn.addMember("Mike");
		sn.addMember("Laura");

		System.out.println(sn);

		System.out.println("So far, there are no pals in the network:");
		String[] palsOfNorm = sn.getPals("Norm");
		System.out.println("Norm's pals: " + Arrays.toString(palsOfNorm));

		System.out.println("Give Norm a couple pals:");
		result = sn.makePals("Norm", "Mike");
		sn.makePals("Norm", "Laura");
		palsOfNorm = sn.getPals("Norm");
		System.out.println("Norm's pals: " + Arrays.toString(palsOfNorm));

		System.out.println("\nHere's the network so far:");
		System.out.println("Everything should be sorted by name...");
		System.out.println(sn);

		String[] members = sn.getMembers();
		System.out.println("Testing degrees of separation:");
		for (String m : members) {
			System.out.println("degrees between Norm and " + m + ": " + sn.degreesOfSeparation("Norm", m));
		}

		System.out.println("\nMake Don a pal of Laura:");
		sn.makePals("Don", "Laura");
		System.out.println("Now here is the network...");
		System.out.println(sn);

		System.out.println("Retesting degrees of separation:");
		for (String m : members) {
			System.out.println("degrees between Norm and " + m + ": " + sn.degreesOfSeparation("Norm", m));
		}

		System.out.println("\nThere are still some methods to be tested.");
		System.out.println("Also need to test what happens for edge cases...");
		System.out.println("Adding when the network is full");
		System.out.println("Removing a non-existent member");
		System.out.println("Removing when the network is empty");
		System.out.println("Making pals when one or more names is not a member");
		System.out.println("And so on...");

		System.out.println("The following lines of code are just checking that "
				+ "\nyou have the right methods.  It does not check whether your methods " + 
				"\nreturn correct results.");
		System.out.println("If your code does not compile with my tester, it means" + 
				"\nyou have the wrong method names, or the wrong parameter or return types.");
		
		
		boolean b;
		String s;
		String[] sa;
		int i;
		
		PalBook pb = new PalBook(5);
		pb = new PalBook();
		b = pb.addMember("");
		pb.removeMember("");
		b = pb.containsMember("");
		b = pb.makePals("", "");
		pb.endPals("", "");
		b = pb.arePals("", "");
		b = pb.areConnected("", "");
		
		sa = pb.getMembers();
		sa = pb.getPals("");
		sa = pb.getPalsOfPals("");
		sa = pb.commonPals("", "");
		sa = pb.membersWithDegree("", 0);
		
		i = pb.degreesOfSeparation("", "");
		i = pb.getMemberCount();
		
		
		
		
	}

}
