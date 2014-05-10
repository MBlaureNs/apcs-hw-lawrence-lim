import java.util.*;

public class Driver {
    public static void main(String[] args) {
	Random rng = new Random();
	int[] a = new int[10];
	for (int i=0; i<a.length; i++) {
	    int n = rng.nextInt(100);
	    a[i]=n;
	}
	System.out.println(Arrays.toString(a));

	System.out.println();
	
	System.out.println("Heap object");
	Heap h = new Heap(a);
	System.out.println(h);
	System.out.println(Arrays.toString(h.sorted()));

	System.out.println();

	System.out.println("In-place sort");
	Heap.sort(a);
	System.out.println(Arrays.toString(a));
    }
}