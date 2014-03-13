import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
	Sort s = new Sort();
	TextWhatever tw = new TextWhatever();
	Random rng = new Random();
	long start;
	long diff;
	int[] n = new int[]{0,5,20,13,8,7,6,3,7,8,8,7,9,12,7,5,3};
	ArrayList<Comparable> sorted = new ArrayList<Comparable>();
	ArrayList<Comparable> ints = new ArrayList<Comparable>();
	ArrayList<String> words = new ArrayList<String>();
	ArrayList<Comparable> damnit = new ArrayList<Comparable>();

	for(int i=0; i<17; i++) {
	    //ints.add(rng.nextInt(100));
	    ints.add(n[i]);
	}
	words = tw.getWords(new File("test2.txt"));
	for(int i=0; i<words.size(); i++) {
	    damnit.add((Comparable)words.get(i));
	}

	//start = System.currentTimeMillis();
	sorted = s.mergesort(ints);
	//diff = System.currentTimeMillis()-start;
	//System.out.println("mergesorted "+sorted.size()+
	//		   " Integers in "+diff+"ms ");
	System.out.println(sorted);

	System.out.println(s.binsearchrec(0,sorted));
	System.out.println(ints.get(s.binsearchrec(0,sorted)));

	//start = System.currentTimeMillis();
	//sorted = s.mergesort(damnit);
	//diff = System.currentTimeMillis()-start;
	//System.out.println("mergesorted "+sorted.size()+
	//		   " Strings in "+diff+"ms ");
	//System.out.println(sorted);

	
    }
}