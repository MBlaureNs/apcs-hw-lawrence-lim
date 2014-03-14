import java.util.*;

public class Sort {
    Random rng = new Random();
    FFS ffs = new FFS();

    public int[] quicksort(int[] a) {
	if(a.length<=1) {return a;}
	ArrayList<Integer> left = new ArrayList<Integer>();
	ArrayList<Integer> mid = new ArrayList<Integer>();
	ArrayList<Integer> right = new ArrayList<Integer>();

	int p = a[rng.nextInt(a.length)];
	for(int i=0; i<a.length; i++) {
	    if(a[i]<p) {left.add(a[i]);}
	    else if(a[i]>p) {right.add(a[i]);}
	    else {mid.add(a[i]);}
	}
	
	int[] lefta = quicksort(ffs.IALtoia(left));
	int[] righta = quicksort(ffs.IALtoia(right));
	
	int cur=0;
	for(int i=0; i<left.size(); i++) {
	    a[cur] = lefta[i]; 
	    cur++;
	}
	for(int i=0; i<mid.size(); i++) {
	    a[cur] = mid.get(i); 
	    cur++;
	}
	for(int i=0; i<right.size(); i++) {
	    a[cur] = righta[i]; 
	    cur++;
	}
	return a;
    }

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
	return quicksort2(a,0,a.length-1);
    }
    public int[] quicksort2(int[] a, int L, int R) {
	if(L>=R){return a;}
	int p = partition(a,L,R);
        a=quicksort2(a,L,p-1);
	a=quicksort2(a,p+1,R);
	return a;
    }

    public boolean check(int[] a) {
	for(int i=0; i<a.length-1; i++) {
	    if(a[i]>a[i+1]){return false;}
	}
	return true;
    }
}
