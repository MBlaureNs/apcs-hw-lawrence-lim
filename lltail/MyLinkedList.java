public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    
    public MyLinkedList() {
	head = new Node<T>();
	tail = head;
    }

    public void add(int index, T n) {
	if(index<0) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}

	if(index==size()) {
	    Node<T> next = new Node<T>();
	    next.setData(n);
	    next.setBefore(tail);
	    tail.setNext(next);
	    tail = next;
	} else {
	    Node<T> cur = head;
	    for(int i=0; i<index; i++) {
		if(cur.hasNext()) {
		    cur = cur.getNext();
		} else {
		    throw new IndexOutOfBoundsException
			(Integer.toString(index));
		}
	    }
	    Node<T> next = new Node<T>();
	    next.setData(n);
	    next.setNext(cur.getNext());
	    cur.setNext(next);
	    next.setBefore(cur);
	}
    }
    public void add(T n) {
	add(size(),n);
    }

    public T remove(int index) {
	if(index<0) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}
        
	Node<T> cur = nodeAt(index-1);
	T last = cur.getNext().getData();
	cur.setNext(nodeAt(index+1));
	return last;
    }

    public int find(T s) {
	Node<T> cur = head.getNext();
	int i = 0;
	while(cur!=null) {
	    if(cur.getData().equals(s)) {
		return i;
	    }
	    cur = cur.getNext();
	    i++;
	}
	return -1;
    }
    
    public Node<T> nodeAt(int index) {
	if(index<-1) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}
	
        Node<T> cur = head;
	for(int i=0; i<=index; i++) {
	    cur = cur.getNext();
	}
	return cur;
    }
    public T get(int index) {
	return nodeAt(index).getData();
    }

    public T set(int index, T s) {
	Node<T> n = nodeAt(index);
	if(n==null) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}
	T last = n.getData();
        n.setData(s);
	return last;
    }

    public int size() {
	int s = 0;
	Node<T> cur = head;
	while(cur.hasNext()) {
	    s++;
	    cur = cur.getNext();
	}
	return s;
    }

    public String toString() {
	String r = "[";
	Node<T> cur = head;
	while(cur.hasNext()) {
	    cur = cur.getNext();
	    r+=cur.toString();
	    if(cur.hasNext()) {r+=",";}
	}
	return r+"]  ("+size()+")";
    }
}
