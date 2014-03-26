public class MyLinkedList {
    private Node head;
    private int length;
    
    public MyLinkedList() {
	head = null;
	length = 0;
    }

    public void add(int index, String n) {
	if(index<0 || index>length) {
	    System.out.println("lol");
	    return;
	}
	
	Node next = new Node();
	next.setData(n);
	if(index==0) {
	    next.setNext(head);
	    head = next;
	} else {
	    Node cur = head;
	    for(int i=0; i<index-1; i++) {
		cur = cur.getNext();
	    }
	    next.setNext(cur.getNext());
	    cur.setNext(next);
	}
	length++;
    }
    public void add(String n) {
	add(length,n);
    }

    public String remove(int index) {
	if(index<0 || index>length-1) {
	    System.out.println("lol");
	    return null;
	}
	
	String last;
	if(index==0) {
	    last = head.getData();
	    head = head.getNext();
	} else {
	    Node cur = nodeAt(index-1);
	    last = cur.getNext().getData();
	    cur.setNext(nodeAt(index+1));
	}
	length--;
	return last;
    }

    public int find(String s) {
	Node cur = head;
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
	if(index<0 || index>length-1) {
	    System.out.println("no");
	    return null;
	}
	
        Node cur = head;
	for(int i=0; i<index; i++) {
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
	    System.out.println("oh");
	}
	String last = n.getData();
        n.setData(s);
	return last;
    }

    public int size() {return length;}

    public String toString() {
	String r = "[";
	if(head!=null) {
	    Node cur = head;
	    r+=cur.toString();
	    while(cur.hasNext()) {
		cur = cur.getNext();
		r+=","+cur.toString();
	    }
	}
	return r+"]  ("+length+")";
    }
}
