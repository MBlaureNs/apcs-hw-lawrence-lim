import java.util.*;

public class ArrayStack {
    String[] stack;
    int top;

    public ArrayStack() {
	stack = new String[10];
	top = -1;
    }
    
    public boolean empty() {
	return top<0;
    }

    public void push(String s) {
	top++;
	if(top>=stack.length) {
	    grow();
	}
	stack[top] = s;
    }
    public void grow() {
	String[] newstack = new String[stack.length*3/2+1];
	for(int i=0; i<stack.length; i++) {
	    newstack[i] = stack[i];
	}
	stack = newstack;
    }

    public String pop() {
	if(top<0) {
	    throw new EmptyStackException();
	}
	top--;
	return stack[top+1];
    }

    public String peek() {
	return stack[top];
    }
    
    public String toString() {
	String r = "[";
	for(int i=top; i>=0; i--) {
	    r+=stack[i];
	    if(i!=0) {r+=",";}
	}
	return r+"]";
    }
}
