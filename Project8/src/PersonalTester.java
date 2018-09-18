/**
 * @author Steven Kast, kastsm
 */

public class PersonalTester {

    public static void main(String[] args){
        Word a = new Word("Apple");
        a.setFrequency(4);
        Word b = new Word("Banana");
        b.setFrequency(2);
        Word c = new Word("Carrot");
        c.setFrequency(2);
//        System.out.println(a.getData());
//        System.out.println(b.getData());
//
//        PriorityQueue q = new PriorityQueue();
//
//        System.out.println(q.add(a));
//        System.out.println(q.add(b));
//        System.out.println(q.add(c));
//
//        System.out.println("Current Queue: " + q);

        StudentLookup test = new StudentLookup();

        test.addString(10, "Apple");
        test.addString(6, "Banana");
        test.addString(4, "Carrot");
        test.addString(3, "Date");
        test.addString(1, "Eggplant");
        test.addString(2, "Apple");

        System.out.println("Number of entries 5?: " + test.numEntries());

        System.out.println(test.lookupPopularity(0));
        System.out.println(test.lookupPopularity(4));
        System.out.println("Apple: " + test.lookupCount("Apple"));
        System.out.println("Carrot: " + test.lookupCount("Carrot"));

        HashMap map = new HashMap();
        map.put(a, 0);
        System.out.println(map.get(a).getFrequency());
        map.put(a, 2);
        Word a2 = new Word("Apple");
        map.put(a2, 100);
        System.out.println(map.get(a2).getFrequency());


//        HashMap map = new HashMap();
//        map.put(a, 0);
//        //a.increaseFrequency(2);
//        map.put(b, 0);
//        map.put(c, 0);
//
//        System.out.println(map.get(a).getFrequency());



        




//        System.out.println(q.remove());
//        System.out.println(q.remove());





    }
}
