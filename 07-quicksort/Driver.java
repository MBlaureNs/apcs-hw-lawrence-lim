import java.util.*;

public class Driver {
    public static void main(String[] args) {
	if(args.length < 1) {
	    System.out.println("Enter a number of elements to sort.");
	    return;
	}
	
	RandomTest rt = new RandomTest();
	Sort s = new Sort();
	int n = Integer.parseInt(args[0]);
        long start,time;

	int[] z1 = rt.randIntArray(n,100000);
	int[] z2 = Arrays.copyOf(z1,z1.length);
	int[] z3 = rt.sameIntArray(n,100);
	int[] z4 = Arrays.copyOf(z3,z3.length);
	
	System.out.println();
	System.out.println("Using arrays of length "+n+".");
	System.out.println();

	System.out.println("==( Array of random elements from 0 to 100000 )==");

	start = System.currentTimeMillis();
	s.quicksort(z1);
	time = System.currentTimeMillis()-start;
	if (s.check(z1)) {
	    System.out.println(" quicksort(z1) succeeded in "+time+"ms");
	} else {
	    System.out.println(" quicksort(z1) failed to sort correctly in"+
			       time+"ms");
	}

	start = System.currentTimeMillis();
	s.quicksort2(z2);
	time = System.currentTimeMillis()-start;
	if (s.check(z1)) {
	    System.out.println("quicksort2(z2) succeeded in "+time+"ms");
	} else {
	    System.out.println("quicksort2(z2) failed to sort correctly in"+
			       time+"ms");
	}

	System.out.println();
	System.out.println("==( Array of all 100s )==");

	start = System.currentTimeMillis();
	s.quicksort(z3);
	time = System.currentTimeMillis()-start;
	if (s.check(z1)) {
	    System.out.println(" quicksort(z3) succeeded in "+time+"ms");
	} else {
	    System.out.println(" quicksort(z3) failed to sort correctly in"+
			       time+"ms");
	}

	start = System.currentTimeMillis();
	s.quicksort2(z4);
	time = System.currentTimeMillis()-start;
	if (s.check(z1)) {
	    System.out.println("quicksort2(z4) succeeded in "+time+"ms");
	} else {
	    System.out.println("quicksort2(z4) failed to sort correctly in"+
			       time+"ms");
	}
    }
}
