import java.util.*;

public class Driver {
    public static void main(String[] args) {
	BST bst = new BST();
	Random rng = new Random();
	for(int i=0; i<100; i++) {
	    bst.insert(rng.nextInt(100));
	}
	System.out.println(bst);
	System.out.println(bst.search(50));
	System.out.println(bst.search2(50));
    }
}
