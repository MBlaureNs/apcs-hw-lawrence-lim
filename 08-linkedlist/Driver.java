public class Driver {
    public static void main(String[] arg) {
	MyLinkedList l = new MyLinkedList();
	System.out.println(l);
	l.add("a",0);
	l.add("b");
	l.add("c");
	l.add("d");
	l.add("e");
	l.add("f");
	System.out.println(l);
	System.out.println(l.get(1));
	l.remove(1);
	System.out.println(l);
	l.add("asdjasd",1);
	System.out.println(l);
	l.add("nope",6);
	System.out.println(l);
    }
}
