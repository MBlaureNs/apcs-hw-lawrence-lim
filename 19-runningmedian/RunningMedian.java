import java.util.*;

public class RunningMedian {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    
    private class InvertComparator<T> implements Comparator {
	public int compare(Object n1, Object n2) {
	    if((Integer)n1>(Integer)n2) {return -1;}
	    if((Integer)n1<(Integer)n2) {return 1;}
	    return 0;
	}
	public boolean equals(Object o) {
	    return o instanceof InvertComparator;
	}
    }

    public RunningMedian() {
	low = new PriorityQueue<Integer>(11, new InvertComparator<Integer>());
	high = new PriorityQueue<Integer>();	
    }
    
    public int median() {
	if(low.size() > high.size()) {
	    return low.peek();
	} else if (high.size() > low.size()) {
	    return high.peek();
	} else if (low.size() == 0 && high.size() == 0)  {
	    return 0;
	} else {
	    return (low.peek() + high.peek())/2;
	}
    }
    
    public void add(int n) {
	if(n<median()) {
	    low.offer(n);
	} else {
	    high.offer(n);
	}
	balance();
    }

    public int removeMedian() {
	int r;
	if(low.size() > high.size()) {
	    r = low.poll();
	} else if (high.size() > low.size()) {
	    r = high.poll();
	} else if (low.size() == 0 && high.size() == 0)  {
	    r = 0;
	} else {
	    r = (low.poll() + high.poll())/2;
	}
	balance();
	return r;
    }

    private void balance() {
	if (low.size() - high.size() > 1) {
	    high.add(low.poll());
	} else if (high.size() - low.size() > 1) {
	    low.add(high.poll());
	}
	
    }

    public String toString() {
	String r = "";
	r += "median: "+median()+"\n";
	r += "low:  ("+low.size() +")"+Arrays.toString(low.toArray()) +"\n";
	r += "high: ("+high.size()+")"+Arrays.toString(high.toArray())+"\n";
	return r;
    }
}
