public class Driver {
    public static void main(String[] arg) {
	MyLinkedList l = new MyLinkedList();
	System.out.println(l);
	l.add(0,"a");
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
    }
}
