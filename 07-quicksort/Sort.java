import java.util.*;

public class Sort {
    Random rng = new Random();

    public int[] quicksort(int[] a) {
	return quicksort(a,0,a.length-1);
    }
    public int[] quicksort(int[] a, int low, int high) {
	System.out.println(Arrays.toString(a)+","+low+","+high);
	if(low>=high){return a;}
	if(high<0){return a;}
	if(low>=a.length){return a;}
	int p = a[rng.nextInt(a.length)];
	System.out.println(p);
	int[] t = new int[a.length];
	int min = low;
	int max = high;
	for(int i=0; i<min; i++) {
	    t[i]=a[i];
	}
	for(int i=max; i<a.length; i++) {
	    t[i]=a[i];
	}
	for(int i=low; i<=high; i++) {
	    if(a[i]<p) {
		t[min] = a[i];
		min++;
	    } else if(a[i]>p) {
		t[max] = a[i];
		max--;
	    }
	}
	for(int i=min; i<=max; i++) {
	    t[i] = p;
	}
	t=quicksort(t,low,min-1);
	t=quicksort(t,max+1,high);
	return t;
    }
}