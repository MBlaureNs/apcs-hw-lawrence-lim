public class MyLinkedList {
    Node head;
    int length;
    
    public MyLinkedList() {
	head = null;
	length = 0;
    }

    public void add(String n, int index) {
	if(index<0) {
	    System.out.println("lol");
	    return;
	}
	if(index>length) {
	    System.out.println("no");
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
	Node next = new Node();
	next.setData(n);
	if(head==null) {
	    head = next;
	} else {
	    Node cur = head;
	    while(cur.hasNext()) {
		cur = cur.getNext();
	    }
	    cur.setNext(next);
	}
	length++;
    }

    public void remove(int index) {
	if(index<0) {
	    System.out.println("lol");
	    return;
	}
	if(index>length-1) {
	    System.out.println("no");
	    return;
	}
	
	if(index==0) {
	    head=get(1);
	} else {
	    Node cur = get(index-1);
	    cur.setNext(get(index+1));
	}
	length--;
    }
	
    public Node get(int index) {
	if(index<0) {
	    System.out.println("lol");
	    return null;
	}
	if(index>length-1) {
	    System.out.println("no");
	    return null;
	}
	
        Node cur = head;
	for(int i=0; i<index; i++) {
	    cur = cur.getNext();
	}
	return cur;
    }

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
