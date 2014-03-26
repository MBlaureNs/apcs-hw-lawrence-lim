public class Node<T> {
    private Node<T> next;
    private Node<T> prev;
    private T data;

    public Node() {
	next = null;
	prev = null;
	data = null;
    }

  
    public Node(T s, Node<T> prevnode) {
	next = null;
	prev = prevnode;
	data = s;
    }

    public Node<T> getNext() {return next;}
    public Node<T> getPrev() {return prev;}
    public T getData() {return data;}

    public void setNext(Node<T> n) {next = n;}
    public void setPrev(Node<T> n) {prev = n;}
    public void setData(T s) {data = s;}

    public String toString() {return data.toString();}
}
