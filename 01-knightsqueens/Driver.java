import java.util.*;

public class Driver { 
    public static void main(String[] args) {
	KnightTour k = new KnightTour();
	k.printboard(k.solve(5));
    }
}
