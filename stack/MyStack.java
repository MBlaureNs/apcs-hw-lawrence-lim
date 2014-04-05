public class MyStack {
    private class Node {
	Node next;
        String data;
	Node(String s) {
	    next = null;
	    data = s;
	}
    }
    
    private Node top;
    
    public MyStack() {
	top = null;
    }

    public void push(String s) {
	Node add = new Node(s);
	add.next = top;
	top = add;
    }
    public String pop() {
	if(top==null){return null;}
	String r = top.data;
	top = top.next;
	return r;
    }
    public String peek() {
	return top.data;
    }
    public boolean isEmpty() {
	return top==null;
    }

    public String toString() {
	Node cur = top;
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
