import java.util.*;

public class RunningMedian {
    Heap low;
    Heap high;
    
    public RunningMedian() {
	low = new Heap(true);
	high = new Heap(false);	
    }
    
    public int median() {
	if(low.size() > high.size()) {
	    return low.getTop();
	} else if (high.size() > low.size()) {
	    return high.getTop();
	} else if (low.size() == 0 && high.size() == 0)  {
	    return 0;
	} else {
	    return (low.getTop() + high.getTop())/2;
	}
    }
    
    public void add(int n) {
	if(n<median()) {
	    low.add(n);
	} else {
	    high.add(n);
	}
	balance();
    }

    public int removeMedian() {
	int r;
	if(low.size() > high.size()) {
	    r = low.removeTop();
	} else if (high.size() > low.size()) {
	    r = high.removeTop();
	} else if (low.size() == 0 && high.size() == 0)  {
	    r = 0;
	} else {
	    r = (low.removeTop() + high.removeTop())/2;
	}
	balance();
	return r;
    }

    private void balance() {
	if (low.size() - high.size() > 1) {
	    high.add(low.removeTop());
	} else if (high.size() - low.size() > 1) {
	    low.add(high.removeTop());
	}
	
    }

    public String toString() {
	String r = "";
	r += "median: "+median()+"\n";
	r += "low:  ("+low.size() +")"+Arrays.toString(low.rawdata()) +"\n";
	r += "high: ("+high.size()+")"+Arrays.toString(high.rawdata())+"\n";
	return r;
    }
}
