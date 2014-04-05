public class Driver {
    public static void main(String[] args) {
	MyStack s = new MyStack();
	System.out.println(s);
	s.push("a");
	s.push("b");
	s.push("c");
	s.push("d");
	s.push("e");
	System.out.println(s);
	while(!s.isEmpty()) {
	    System.out.println(s.peek());
	    System.out.println(s.pop());
	    System.out.println(s);
	}
    }
}
