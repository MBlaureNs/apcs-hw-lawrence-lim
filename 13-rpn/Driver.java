public class Driver {
    public static void main(String[] args) {
	RPN rpn = new RPN();
	if(args.length>0) {
	    rpn.run(args);
	} else {
	    rpn.run();
	}
    }
}
