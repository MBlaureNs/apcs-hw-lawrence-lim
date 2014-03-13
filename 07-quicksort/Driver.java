import java.util.*;

public class Driver {
    public static void main(String[] args) {
	RandomTest rt = new RandomTest();
	Sort s = new Sort();

	int[] z = rt.randIntArray(10,100);

	System.out.println(Arrays.toString(z));
	System.out.println(Arrays.toString(s.quicksort(z)));
    }
}