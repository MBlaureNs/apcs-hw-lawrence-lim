import java.util.*;

public class Select {
    Random rng = new Random();
    public int quickselect(int[] a, int k) {
	return quickselect(a,k,0,a.length-1);
    }
    public int quickselect(int[] a, int k, int low, int high) {
	/*
	System.out.println("quickselect("+
			   Arrays.toString(a)+","+
			   k+","+
			   low+","+
			   high+")");
	*/
	int p = a[rng.nextInt(high-low+1)+low];
	//System.out.println(p);
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
	if (k>=min && k<=max) {return p;}
	for(int i=min; i<=max; i++) {
	    t[i] = p;
	}
	if(k<min) {return quickselect(t,k,low,min-1);}
	if(k>max) {return quickselect(t,k,max+1,high);}
	return -1;
    }
}
