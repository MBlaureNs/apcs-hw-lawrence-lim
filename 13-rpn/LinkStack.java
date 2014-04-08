public class LinkStack<T> {
    private class Node<T> {
	Node<T> next;
        T data;
	Node(T s) {
	    next = null;
	    data = s;
	}
    }
    
    private Node<T> top;
    private int len;
    
    public LinkStack() {
	top = null;
	len = 0;
    }

    public void push(T s) {
	Node<T> add = new Node<T>(s);
	add.next = top;
	top = add;
	len++;
    }
    public T pop() {
	if(top==null){return null;}
	T r = top.data;
	top = top.next;
	len--;
	return r;
    }
    public T peek() {
	return top.data;
    }
    public boolean isEmpty() {
	return top==null;
    }
    public int size() {
	return len;
    }

    public String toString() {
	Node<T> cur = top;
	String r = "[";
	while(cur!=null) { 
	    r+=cur.data;
	    if(cur.next!=null) {r+=",";}
	    cur=cur.next;
	}
        r+="]";
	return r;
    }
}
