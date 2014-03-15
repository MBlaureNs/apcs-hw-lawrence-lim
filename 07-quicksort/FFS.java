/*
 *Functions and stuff that java really should do for me but doesn't
 */

import java.util.*;

public class FFS {
    //ArrayList<Integer> to int[]. ffs, java.
    public int[] IALtoia(ArrayList<Integer> a) {
	int[] r = new int[a.size()];
	for(int i=0; i<a.size(); i++) {
	    r[i] = a.get(i);
	}
	return r;
    }
}
