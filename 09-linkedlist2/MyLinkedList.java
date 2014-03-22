public class MyLinkedList {
    private Node head;
    
    public MyLinkedList() {
	head = new Node();
    }

    public void add(int index, String n) {
	if(index<0) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}

	Node cur = head;
	for(int i=0; i<index; i++) {
	    if(cur.hasNext()) {
		cur = cur.getNext();
	    } else {
		throw new IndexOutOfBoundsException(Integer.toString(index));
	    }
	}
	Node next = new Node();
	next.setData(n);
	next.setNext(cur.getNext());
	cur.setNext(next);
    }
    public void add(String n) {
	add(size(),n);
    }

    public String remove(int index) {
	if(index<0) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}
        
	Node cur = nodeAt(index-1);
	String last = cur.getNext().getData();
	cur.setNext(nodeAt(index+1));
	return last;
    }

    public int find(String s) {
	Node cur = head.getNext();
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
    
    private Node nodeAt(int index) {
	if(index<-1) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}
	
        Node cur = head;
	for(int i=0; i<=index; i++) {
	    cur = cur.getNext();
	}
	return cur;
    }
    public String get(int index) {
	return nodeAt(index).getData();
    }

    public String set(int index, String s) {
	Node n = nodeAt(index);
	if(n==null) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}
	String last = n.getData();
        n.setData(s);
	return last;
    }

    public int size() {
	int s = 0;
	Node cur = head;
	while(cur.hasNext()) {
	    s++;
	    cur = cur.getNext();
	}
	return s;
    }

    public String toString() {
	String r = "[";
	Node cur = head;
	while(cur.hasNext()) {
	    cur = cur.getNext();
	    r+=cur.toString();
	    if(cur.hasNext()) {r+=",";}
	}
	return r+"]  ("+size()+")";
    }
}
