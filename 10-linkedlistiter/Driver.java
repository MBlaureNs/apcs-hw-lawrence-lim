public class Driver {
    public static void main(String[] arg) {
	MyLinkedList<String> l = new MyLinkedList<String>();
	System.out.println(l);
	l.add(0,"a");
	System.out.println(l);
	l.add("b");
	l.add("c");
	l.add("d");
	l.add("e");
	l.add("f");
	System.out.println(l);
	System.out.println(l.get(1));
	System.out.println(l.remove(1));
	System.out.println(l);
	l.add(1,"asdjasd");
	System.out.println(l);
	l.add(6,"nope");
	System.out.println(l);
	System.out.println(l.set(3,"huehuehue"));
	System.out.println(l);
	System.out.println(l.find("huehuehue"));
	System.out.println(l.find("derp"));
	System.out.println(l.nodeAt(3).getPrev());
	System.out.println(l.get(2));
	System.out.println(l.toStringBackward());
	System.out.println(l);
	System.out.println(l.nodeAt(2).getPrev());
	System.out.println("---");
	for(Object i : l) {
	    System.out.println(i);
	}
    }
}
