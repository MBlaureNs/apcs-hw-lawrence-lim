import java.util.*;

public class RunningMedian {
    Heap low;
    Heap high;
    
    public RunningMedian() {
	low = new Heap();
	high = new Heap();	
    }
    
    public int median() {
	if(low.size() > high.size()) {
	    return low.getMax();
	} else if (high.size() > low.size()) {
	    return high.getMax();
	} else if (low.size() == 0 && high.size() == 0)  {
	    return 0;
	} else {
	    return (low.getMax() + high.getMax())/2;
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
	    r = low.removeMax();
	} else if (high.size() > low.size()) {
	    r = high.removeMax();
	} else if (low.size() == 0 && high.size() == 0)  {
	    r = 0;
	} else {
	    r = (low.removeMax() + high.removeMax())/2;
	}
	balance();
	return r;
    }

    private void balance() {
	if (low.size() - high.size() > 1) {
	    high.add(low.removeMax());
	} else if (high.size() - low.size() > 1) {
	    low.add(high.removeMax());
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
