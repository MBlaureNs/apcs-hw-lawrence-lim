import java.io.*;
import java.util.*;
/* Lawrence Michael Lims Pd. 3 Mr. Zamansky
 */

public class DoubleLL<E>{
    private class Node<E>{
	E data;
	Node<E> next,prev;
		
	public Node(E d) {
	    this.data =d;
	}
		
	public String toString() {
	    return ""+data;
	}

	public void setData(E d) { data = d;}
	public E getData() {return data;}
	public void setNext(Node<E> n) {next = n;}
	public Node<E> getNext() {return next;}
	public void setPrev(Node<E> p) {prev = p;}
	public Node<E> getPrev() {return prev;}
    }

    private Node<E> current;

    public void insert(E d) {
	Node<E> n = new Node<E>(d);
	if(current == null){
	    current=n;
	    current.prev = current;
	    current.next = current;
	}
	else{
	    n.next = current;
	    if(current.prev!=null){
		current.prev.next = n;
		n.prev = current.prev;
	    }
	    current.prev = n;
	    current=n;	
	}
    }

    public E getCurrent(){
	return current.getData();
    }

    public void forward(){
	if(current.getNext()!=null)
	    current = current.getNext();
    }

    public void back(){
	if(current.getPrev()!=null)
	    current = current.getPrev();
    }

    public String toString(){
	if(current==null)
	    return "";
	Node<E> tmp = current.next;
		
	String s = "";
	s = s + current.getData() + ", ";
	while (tmp!=current){
	    s = s + tmp.getData() + ", ";
	    tmp = tmp.getNext();
	}
	return s;
    }

    public String delete(){
	String s = "" + current.getData();
	current.prev.next = current.next;
	current.next.prev = current.prev;
	current = current.next;
	return s;
    }

    public int find(E d){
	int i = 0;
	Node<E> tmp = current;
	while(tmp!= current.prev){
	    if(tmp.getData().equals(d))
		return i;
	    i++;
	    tmp=tmp.next;
	}
	if(tmp.getData().equals(d)){
	    return i;
	}
	return -1;
    }

    public static void main(String[] args) {
	DoubleLL<String> L = new DoubleLL<String>();
	System.out.println(L);
	L.insert("hello");
	System.out.println(L);
	L.insert("world");
	System.out.println(L);
	L.insert("three");
	System.out.println(L);
	//First test up to here
	System.out.println(L.find("hello"));
	System.out.println(L.find("world"));
	System.out.println(L.find("three"));
	System.out.println(L.find("lel"));
	System.out.println(L);
		

	System.out.println(L.getCurrent());
	L.forward();

	System.out.println(L.getCurrent());
	L.insert("inserted");

	System.out.println(L);
	//then test again to here
    }
}
