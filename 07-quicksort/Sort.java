import java.util.*;

public class Sort {
    Random rng = new Random();

    public void swap(int[] a, int p, int q) {
	int t = a[p];
	a[p] = a[q];
	a[q] = t;
    }
    public int partition(int[] a, int L, int R) {
	int pindex = rng.nextInt(R-L)+L;
	int p = a[pindex];
	int wall = L;
	swap(a,pindex,R);
	for(int i=L; i<R; i++) {
	    if(a[i]<p) {
		swap(a,i,wall);
		wall++;
	    }
	}
	swap(a,wall,R);
	return wall;
    }
    public int[] quicksort2(int[] a) {
	return null;
    }


    public int[] yoloquicksort(int[] a) {
	return yoloquicksort(a,0,a.length-1);
    }
    public int[] yoloquicksort(int[] a, int low, int high) {
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
	t=yoloquicksort(t,low,min-1);
	t=yoloquicksort(t,max+1,high);
	return t;
    }
}