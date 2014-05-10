import java.util.*;

public class Heap {
    private int size;
    private int[] data;
    
    public Heap() {
	data = new int[7];
	size = 0;
    }
    public Heap(int[] a) {
	data = new int[a.length];
	for (int i=0; i<a.length; i++) {
	    add(a[i]);
	}
    }

    public int size() {return size;}

    public void add(int n) {
	size++;
	if(size>=data.length) {grow();}
	data[size-1]=n;
	pushUp(data,size-1);
    }
    private void grow() {
	int[] n = new int[size*2+1];
	for(int i=0; i<data.length; i++) {
	    n[i] = data[i];
	}
	data = n;
    }
    public int removeMax() {
	int r = data[0];
	size--;
	data[0] = data[size];
	pushDown(data,0,size);
	return r;
    }
    public int[] sorted() {
        int[] r = new int[size];
	for(int i=0; i<r.length; i++) {
	    r[r.length-1-i] = removeMax();
	}
	return r;
    }
    public String toString() {
	String r = "Size: "+size+"\n";
	return r+heapString(0,0);
    }
    private String heapString(int index, int depth) {
	if(index>=size) {return "";}
	String r="";
	for(int i=0; i<depth; i++) {
	    r+="  ";
	}
	r+= data[index]+"\n"
	    +heapString((index+1)*2-1, depth+1)
	    +heapString((index+1)*2  , depth+1);
	return r;
    }

    public static int[] sort(int[] a) {
	for(int i=0; i<a.length; i++) {
	    pushUp(a,i);
	}
	for(int i=0; i<a.length; i++) {
	    swapMax(a,a.length-i);
	}
	return a;
    }
    private static void swapMax(int[] a, int len) {
	int r = a[0];
	a[0] = a[len-1];
	pushDown(a,0,len);
	a[len-1] = r;
    }
    private static void pushUp(int[] a, int i) {
	if(i==0) {return;}
	int above = (i+1)/2-1;
	if(a[above]<a[i]) {
	    swap(a,above,i);
	    pushUp(a,above);
	}
    }
    private static void pushDown(int[] a, int i, int len) {
	int left = (i+1)*2-1;
	int right = left+1;
	if(left>=len-1) {return;}
	if(right>=a.length || a[left] > a[right]) {
	    if(a[left] > a[i]) {
		swap(a,left,i);
		pushDown(a,left,len);
	    }
	} else {
	    if(a[right] > a[i]) {
		swap(a,right,i);
		pushDown(a,right,len);
	    }
	}
    }
    private static void swap(int[] a, int p, int q) {
	int temp = a[p];
	a[p] = a[q];
	a[q] = temp;
    }
    public static String toString(int[] a) {
	String r = "Size: "+a.length+"\n";
	return r+heapString(a,0,0);
    }
    private static String heapString(int[] a, int index, int depth) {
	if(index>=a.length) {return "";}
	String r="";
	for(int i=0; i<depth; i++) {
	    r+="  ";
	}
	r+= a[index]+"\n"
	    +heapString(a, (index+1)*2-1, depth+1)
	    +heapString(a, (index+1)*2  , depth+1);
	return r;
    }
}
