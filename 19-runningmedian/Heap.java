import java.util.*;

public class Heap {
    private int size;
    private int[] data;
    private boolean isMaxHeap;
    
    public Heap() {
	data = new int[7];
	size = 0;
	isMaxHeap = true;
    }
    public Heap(boolean type) {
	data = new int[7];
	size = 0;
	isMaxHeap = type;
    }
    public Heap(int[] a) {
	data = new int[a.length];
	isMaxHeap = true;
	for (int i=0; i<a.length; i++) {
	    add(a[i]);
	}
    }
    public Heap(int[] a, boolean type) {
	data = new int[a.length];
	isMaxHeap = type;
	for (int i=0; i<a.length; i++) {
	    add(a[i]);
	}
    }

    public int size() {return size;}
    public int[] rawdata() {
	int[] r = new int[size];
	for(int i=0; i<size; i++) {
	    r[i]=data[i];
	}
	return r;
    }
    public int getTop() {
	return data[0];
    }

    public void add(int n) {
	size++;
	if(size>=data.length) {grow();}
	data[size-1]=n;
	pushUp(data,size-1,isMaxHeap);
    }
    private void grow() {
	int[] n = new int[size*2+1];
	for(int i=0; i<data.length; i++) {
	    n[i] = data[i];
	}
	data = n;
    }
    public int removeTop() {
	int r = data[0];
	size--;
	data[0] = data[size];
	pushDown(data,0,size,isMaxHeap);
	return r;
    }
    public int[] sorted() {
	int[] temp = new int[size];
	for(int i=0; i<temp.length; i++) {
	    temp[i] = data[i];
	}
	return Heap.sort(temp,isMaxHeap);
    }
    public String toString() {
	String r = "";
	if (data[0]>data[1]) {r+="Maxheap\n";}
	else {r+="Minheap\n";}
	r+="Size: "+size+"\n";
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
	return sort(a,true);
    }
    public static int[] sort(int[] a, boolean isMax) {
	for(int i=0; i<a.length; i++) {
	    pushUp(a,i,isMax);
	}
	for(int i=0; i<a.length; i++) {
	    swapTop(a,a.length-i,isMax);
	}
	return a;
    }
    private static void swapTop(int[] a, int len, boolean isMax) {
	int r = a[0];
	a[0] = a[len-1];
	pushDown(a,0,len,isMax);
	a[len-1] = r;
    }
    private static void pushUp(int[] a, int i, boolean isMax) {
	if(i==0) {return;}
	int above = (i+1)/2-1;
	if(( isMax && a[above]<a[i]) || 
	   (!isMax && a[above]>a[i])) {
	    swap(a,above,i);
	    pushUp(a,above,isMax);
	}
    }
    private static void pushDown(int[] a, int i, int len, boolean isMax) {
	int left = (i+1)*2-1;
	int right = left+1;
	if(left>=len-1) {return;}
	if(( isMax && (right>=a.length || a[left] > a[right])) ||
	   (!isMax && (right<=a.length || a[left] < a[right]))) {
	    if(( isMax && a[left] > a[i]) ||
	       (!isMax && a[left] < a[i])) {
		swap(a,left,i);
		pushDown(a,left,len,isMax);
	    }
	} else {
	    if(( isMax && (a[right] > a[i])) ||
	       (!isMax && (a[right] < a[i]))) {
		swap(a,right,i);
		pushDown(a,right,len,isMax);
	    }
	}
    }
    private static void swap(int[] a, int p, int q) {
	int temp = a[p];
	a[p] = a[q];
	a[q] = temp;
    }
    public static boolean isMaxHeap(int[] a) {
	for(int i=0; i<a.length/2; i++) {
	    if(a[i] < a[(i+1)*2-1] || a[i] < a[(i+1)*2]) {return false;}
	}
	return true;
    }
    public static boolean isMinHeap(int[] a) {
	for(int i=0; i<a.length/2; i++) {
	    if(a[i] > a[(i+1)*2-1] || a[i] > a[(i+1)*2]) {return false;}
	}
	return true;
    }
    public static String toString(int[] a) {
	String r = "";
	if (isMaxHeap(a)) {r+="Maxheap\n";}
	else if (isMinHeap(a)) {r+="Minheap\n";}
	else {return "Not a heap\n"+Arrays.toString(a)+"\n";}
	r+="Size: "+a.length+"\n";
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
