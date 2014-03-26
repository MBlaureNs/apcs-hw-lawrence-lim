public class Node<T> {
    private Node<T> next;
    private Node<T> before;
    private T data;

    public Node() {
	next = null;
	data = null;
    }

  
    public Node(T s) {
	next = null;
	data = s;
    }

    public void setBefore(Node<T> x) {
	before = x;
    }

    public boolean hasNext() {return next!=null;}

    public Node<T> getNext() {return next;}
    public Node<T> getBefore() {return before;}
    public T getData() {return data;}

    public void setNext(Node<T> n) {next = n;}
    public void setData(T s) {data = s;}

    public String toString() {return data.toString();}
}
