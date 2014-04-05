public class Driver {
    public static void main(String[] args) {
	ArrayStack a = new ArrayStack();
	System.out.println(a.empty());
	a.push("nope");
	a.push("go away");
	a.push("nope");
	a.push("pon");
	a.push("pon");
	a.push("wei");
	a.push("wei");
	a.push("wei");
	a.push("hue");
	a.push("derp");
	a.push("trees");
	a.push("grass");
	System.out.println(a);
	System.out.println(a.pop());
	System.out.println(a);
	System.out.println(a.peek());
	System.out.println(a.empty());
    }
}
