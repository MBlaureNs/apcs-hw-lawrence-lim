import java.util.*;

public class Driver {
    public static void main(String[] args) {
	RandomTest rt = new RandomTest();
	Select select = new Select();
	Sort sort = new Sort();
	int[] test = rt.randIntArray(10,100);
	
	ArrayList<Comparable> al = new ArrayList<Comparable>();
	for(int i=0; i<test.length; i++) {
	    al.add(test[i]);
	}

	System.out.println(Arrays.toString(test));
	System.out.println(sort.mergesort(al));
	System.out.println(select.quickselect(test,3));
    }
}
