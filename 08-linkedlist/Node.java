public class Node {
    Node next;
    String data;

    public Node() {
	next = null;
    }
    public Node(String s) {
	next = null;
	data = s;
    }

    public boolean hasNext() {return next!=null;}

    public Node getNext() {return next;}
    public String getData() {return data;}

    public void setNext(Node n) {next = n;}
    public void setData(String s) {data = s;}

    public String toString() {return data;}
}
