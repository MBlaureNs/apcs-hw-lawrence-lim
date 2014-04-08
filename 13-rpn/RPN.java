import java.util.*;

public class RPN {
    private LinkStack<Double> stack;
    private Scanner scan;
    private final String[] ops = new String[]{"+","-","*","/"};
    private final String[] quits = new String[]{"quit","exit","die","q","Q"};

    public RPN() {
	stack = new LinkStack<Double>();
	scan = new Scanner(System.in);
    }

    public void run() {
	while(true) {
	    System.out.print(">>> ");
	    String input = scan.next();
	    if(!runOnce(input)){break;}
	}
    }
    public void run(String[] args) {
	for(int i=0; i<args.length; i++) {
	    if(!runOnce(args[i])){break;}
	}
	System.out.println("\n"+stack);
    }
    private boolean runOnce(String input) {
	if(isQuit(input)){
	    return false;
	} else if(isOp(input)){
	    switch(input) {
	    case "+":
		add();
		break;
	    case "-":
		subtract();
		break;
	    case "*":
		multiply();
		break;
	    case "/":
		divide();
		break;
	    default:
		System.out.println("something broke somehow");
		break;
	    }
	    if(stack.size()>0) {System.out.println(stack.peek());}
	} else {
	    try {
		stack.push(Double.parseDouble(input));
	    } catch (NumberFormatException e) {
		System.out.println("Invalid input: "+input);
	    }
	}
	return true;
    }

    private void add() {
	if(stack.size()<2) {
	    System.out.println("Not enough arguments");
	} else {
	    stack.push(stack.pop()+stack.pop());
	}
    }
    private void subtract() {
	if(stack.size()<1) {
	    System.out.println("Not enough arguments");
	} else if(stack.size()==1) {
	    stack.push(-stack.pop());
	} else {
	    double b = stack.pop();
	    double a = stack.pop();
	    stack.push(a-b);
	}
    }
    private void multiply() {
	if(stack.size()<2) {
	    System.out.println("Not enough arguments");
	} else {
	    stack.push(stack.pop()*stack.pop());
	}
    }
    private void divide() {
	if(stack.size()<2) {
	    System.out.println("Not enough arguments");
	} else {
	    double b = stack.pop();
	    double a = stack.pop();
	    if(b==0) {
		System.out.println("You don't want to do that.");
		stack.push(a);
		stack.push(b);
	    } else {
		stack.push(a/b);
	    }
	}
    }

    private boolean isIn(String s, String[] array) {
	for(int i=0; i<array.length; i++) {
	    if(array[i].equals(s)) {return true;}
	}
	return false;
    }
    private boolean isOp(String s) {return isIn(s,ops);}
    private boolean isQuit(String s) {return isIn(s,quits);}
}
