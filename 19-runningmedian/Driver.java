import java.util.*;

public class Driver {
    public static void main(String[] args) {
	Random rng = new Random();

	System.out.println();
	System.out.println("Running Median");
	System.out.println("--------------");
	RunningMedian rm = new RunningMedian();
	for (int i=0; i<30; i++) {
	    int n = rng.nextInt(100);
	    rm.add(n);
	}
	System.out.println(rm);
	rm.removeMedian();
	System.out.println(rm);
	rm.add(rng.nextInt(100));
	System.out.println(rm);
	rm.removeMedian();
	System.out.println(rm);
    }
}
