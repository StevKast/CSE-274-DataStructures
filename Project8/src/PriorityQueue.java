/**
 * @author Steven Kast, kastsm
 */

public class PriorityQueue {

//    Node[] queue = new Word[4092];
    private int size;
    Node head;

    public PriorityQueue(){
        size = 0;
        head = null;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public boolean add(Word word){
        Node newWord = new Node(word);
        Node currentNode = head;
        Node prevNode = null;

        //System.out.println("Adding: " +  word.getData());

        while (currentNode != null &&  isGreater(newWord, currentNode)) {
            if(currentNode.data.equals(newWord.data)){
                currentNode.data = newWord.data;
                return true;
            }

            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        if (prevNode == null) {
            newWord.nextNode = head;
            head = newWord;
            size++;
            return true;
        } else {
            prevNode.nextNode = newWord;
            newWord.nextNode = currentNode;
            size++;
            return true;
        }

        //Something went horrible and it failed.
        //return false;

    }

    public Word peek(){
        return head.data;
    }


    public Word remove(){
        if(head == null){
            return null;
        }
        Node removed = head;
        head = head.nextNode;
        size--;
        return removed.data;
    }

    public Word remove(Word word){
        if(head == null){
            return null;
        }
        Node removed = getSpecific(word);
        removed.prevNode.nextNode = removed.nextNode;
        return removed.data;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Word find(int n){
        Node current = head;

        for(int i = 0; i < n; i++){
            if(current != null){
                current = current.nextNode;
            }
        }

        return current.data;
    }

    public boolean contains(Word word){
        Node current = head;
        while(current != null){
            if(current.data.getData().equals(word.getData())){
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    public Node getSpecific(Word word){
        Node current = head;
        while(current != null){
            if(current.data.getData().equals(word.getData())){
                return current;
            }
            current.prevNode = current;
            current = current.nextNode;
        }
        return null;
    }

    public int getSize(){
        return size;
    }

    private boolean isGreater(Node a, Node b){
        if(a.compareTo(b) <= 0){
            return true;
        }

        return false;
    }


    @Override
    public String toString() {
        String ret = "";
        Node current = head;
        while(current != null){
            ret += current.data.getData() + " ";
            current = current.nextNode;
        }
        return ret.trim();
    }

    /**
     * Private node class for linked list implementation of PriorityQueue
     */
    private class Node implements Comparable<Node>{
        private Node nextNode;
        private Node prevNode; //Special Previous node for removing specific nodes
        private Word data;

        public Node(Word data){
            this.data = data;
            nextNode = null;
        }

        public Word getData(){
            return data;
        }

        @Override
        public int compareTo(Node o) {
            return data.compareTo(o.data);
        }
    }
}
