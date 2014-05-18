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
	System.out.println();
	
	System.out.println("Heap object");
	System.out.println("-----------");
	Heap h1 = new Heap(a);
	System.out.println(h1);
	System.out.println(Arrays.toString(h1.sorted()));
	Heap h2 = new Heap(a,false);
	System.out.println(h2);
	System.out.println(Arrays.toString(h2.sorted()));

	System.out.println();
	System.out.println();

	System.out.println("In-place sort");
	System.out.println("-------------");
	Heap.sort(a);
	System.out.println(Arrays.toString(a));

	System.out.println();
	System.out.println();

	System.out.println("Static toString method");
	System.out.println("----------------------");
	System.out.println(Heap.toString(new int[]{5,2,7}));
	System.out.println(Heap.toString(new int[]{5,2,1}));
	System.out.println(Heap.toString(new int[]{5,6,7}));

	System.out.println();
	System.out.println();

	System.out.println("Running Median");
	System.out.println("--------------");
	RunningMedian rm = new RunningMedian();
	for (int i=0; i<30; i++) {
	    int n = rng.nextInt(100);
	    rm.add(n);
	}
	System.out.println(rm);
	rm.removeMedian();
	System.out.println(rm);
	rm.add(rng.nextInt(100));
	System.out.println(rm);
	rm.removeMedian();
	System.out.println(rm);
    }
}
