public class SetTester {

    public static void main(String[] args){

        ResizableArraySet set1 = new ResizableArraySet(2);
        ResizableArraySet set2 = new ResizableArraySet(2);
        ResizableArraySet set3 = new ResizableArraySet();

        System.out.println("-------------------");
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        System.out.println(viewSet(set1));
        System.out.println("set1 size 5?: " + set1.getSize());
        System.out.println("Contains 2 True?: " + set1.contains(2));
        System.out.println("Contains 0 False?: " + set1.contains(0));

        set1.remove(4);
        set1.remove();
        System.out.println("Removed 4 and 5? " + viewSet(set1));

        System.out.println("-------------------");
        set2.add(4);
        set2.add(1);
        set2.add(5);
        System.out.println("set2 size 3?: " + set2.getSize());

        System.out.println(viewSet(set2));
        System.out.println("-------------------");


        set3.add(1);
        set3.add(3);
        set3.add(5);
        set3.add(6);
        set3.add(8);

        set1.intersection(set3);
        System.out.println("Intersection of set1 and set3: " + viewSet(set1));

        set1.union(set2);
        System.out.println("Union of set1 and set2: " + viewSet(set1));

        System.out.println("Set 2: " + viewSet(set2));
        System.out.println("Set 3: " + viewSet(set3));
        set2.difference(set3);
        System.out.println("Difference of set2 and set3: " + viewSet(set1));


    }

    public static String viewSet(ResizableArraySet set){
        String ans = "Size: " + set.getSize() + " [ ";
        for (int n : set.toArray()) {
            ans += n + " ";
        }
        return  ans + "]";
    }


}

