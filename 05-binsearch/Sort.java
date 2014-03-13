import java.util.*;

public class Sort {
    public ArrayList<Comparable> merge (ArrayList<Comparable> a, 
					ArrayList<Comparable> b) {
	ArrayList<Comparable> r = new ArrayList<Comparable>();
	int acur = 0;
	int bcur = 0;
	for(int i=0; i<a.size()+b.size(); i++) {
	    if (b.size()-bcur<=0) {
		r.add(a.get(acur)); 
		acur++;
	    } else if(a.size()-acur<=0) {
		r.add(b.get(bcur)); 
		bcur++;
	    } else {
		if(a.get(acur).compareTo(b.get(bcur))<0) {
		    r.add(a.get(acur));
		    acur++;
		} else {
		    r.add(b.get(bcur));
		    bcur++;
		}
	    }
	}
	return r;
    }
    
    public ArrayList<Comparable> mergesort(ArrayList<Comparable> n) {
	if(n.size()<=1) {return n;}
	ArrayList<Comparable> a = new ArrayList<Comparable>();
	ArrayList<Comparable> b = new ArrayList<Comparable>();
	
	int alen = n.size()/2;
	
	for(int i=0; i<alen; i++) {
	    a.add(n.get(i));
	}
	for(int i=alen; i<n.size(); i++) {
	    b.add(n.get(i));
	}
	
	return merge(mergesort(a),mergesort(b));
    }

    public int[] bubblesort(int[] n) {
	for(int i=0; i<n.length; i++) {
	    for(int j=0; j<n.length-i-1; j++) {
		if(n[j]>n[j+1]) {
		    int z = n[j];
		    n[j] = n[j+1];
		    n[j+1] = z;
		}
	    }
	}
	return n;
    }

    public int[] insertsort(int[] n) {
	int[] r = new int[n.length];
	for(int i=0; i<r.length; i++) {
	    r[i] = n[i];
	}
	for(int i=0; i<r.length; i++) {
	    int z = i;
	    for(int j=i; j<r.length; j++) {
		if(r[z]>r[j]) {z = j;}		
	    }
	    int x = r[z];
	    r[z] = r[i];
	    r[i] = x;
	}
	return r;
    }

    public int binsearchrec(Comparable target, ArrayList<Comparable> al) {
	return binsearchrec(target, al, 0, al.size());
    }
    public int binsearchrec(Comparable target, ArrayList<Comparable> al,
			    int start, int end) {
	int n = (start + end) / 2;
	if (al.get(n).equals(target)) {return n;}
	else if (start >= end-1) {return -1;}
	else if (target.compareTo(al.get(n)) < 0) {
	    return binsearchrec(target,al,start,n);
	} else {
	    return binsearchrec(target,al,n,end);
	}
    }
}