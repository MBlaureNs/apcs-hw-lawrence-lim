import java.util.*;

public class RandomTest {
    Random rng = new Random();

    public int[] randIntArray(int len, int max) {
	int[] r = new int[len];
	for (int i=0; i<len; i++) {
	    r[i] = rng.nextInt(max);
	}
	return r;
    }
}
