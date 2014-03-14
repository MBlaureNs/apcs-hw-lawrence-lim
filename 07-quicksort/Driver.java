import java.util.*;

public class Driver {
    public static void main(String[] args) {
	RandomTest rt = new RandomTest();
	Sort s = new Sort();
	int n = 1000000;
        long start,time;

	int[] z1 = rt.randIntArray(n,100000);
	int[] z2 = Arrays.copyOf(z1,z1.length);

	//System.out.println(Arrays.toString(z1));
	//System.out.println(Arrays.toString(z2));
	//System.out.println(Arrays.toString(z3));
	start = System.currentTimeMillis();
	s.quicksort(z1);
	time = System.currentTimeMillis()-start;
	System.out.println("quicksort(z1) for "+n+" elements in "+time+"ms");
	System.out.println("sorted?  "+s.check(z1));
	System.out.println();

	start = System.currentTimeMillis();
	s.quicksort2(z2);
	time = System.currentTimeMillis()-start;
	System.out.println("quicksort2(z2) for "+n+" elements in "+time+"ms");
	System.out.println("sorted?  "+s.check(z2));
	System.out.println();
    }
}
