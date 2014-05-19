import java.util.*;
import java.io.*;

public class MapTest {
    public static void main(String[] args) {
	Random rng = new Random();
	Scanner sc = null;
	try {
	    sc = new Scanner(new File("derp"));
	    sc.useDelimiter("\\Z");
	} catch (Exception e) {
	    System.out.println(e);
	}
	HashMap<Integer,String> h = new HashMap<Integer,String>();
	TreeMap<Integer,String> t = new TreeMap<Integer,String>();
	long start,time;
	
	String z = sc.useDelimiter("\\Z").next();
	for(int i=0; i<7; i++) {z+=z+" ";}
	String[] s = z.split(" ");
	int[] n = new int[s.length];
	for (int i=0; i<s.length; i++) {
	    n[i] = rng.nextInt(Integer.MAX_VALUE);
	}
	int[] m = new int[s.length];
	for (int i=0; i<s.length; i++ ) {
	    m[i] = rng.nextInt(s.length);
	}
	int[] o = new int[s.length];
	for (int i=0; i<s.length; i++ ) {
	    if(i%2==0) {m[i] = rng.nextInt(s.length);}
	    else {m[i] = rng.nextInt(Integer.MAX_VALUE);}
	}
	

        
	System.out.println("==( HashMap )==");

	start = System.currentTimeMillis();
	for (int i=0; i<s.length; i++) {
	    h.put(n[i],s[i]);
	}      
	time = System.currentTimeMillis()-start;
	System.out.println("put "+s.length+" elements in "+time+"ms");

	start = System.currentTimeMillis();
	for (int i=0; i<s.length; i++) {
	    h.get(m[i]);
	}      
	time = System.currentTimeMillis()-start;
	System.out.println("get "+s.length+" elements in "+time+"ms");

	start = System.currentTimeMillis();
	for (int i=0; i<s.length; i++) {
	    h.containsKey(o[i]);
	}      
	time = System.currentTimeMillis()-start;
	System.out.println("contains "+s.length+" elements in "+time+"ms");

	start = System.currentTimeMillis();
	for (int i=0; i<s.length; i++) {
	    h.remove(n[i]);
	}      
	time = System.currentTimeMillis()-start;
	System.out.println("remove "+s.length+" elements in "+time+"ms");


	System.out.println("==( TreeMap )==");

	start = System.currentTimeMillis();
	for (int i=0; i<s.length; i++) {
	    t.put(n[i],s[i]);
	}      
	time = System.currentTimeMillis()-start;
	System.out.println("put "+s.length+" elements in "+time+"ms");

	start = System.currentTimeMillis();
	for (int i=0; i<s.length; i++) {
	    t.get(m[i]);
	}      
	time = System.currentTimeMillis()-start;
	System.out.println("get "+s.length+" elements in "+time+"ms");

	start = System.currentTimeMillis();
	for (int i=0; i<s.length; i++) {
	    t.containsKey(o[i]);
	}      
	time = System.currentTimeMillis()-start;
	System.out.println("containsKey "+s.length+" elements in "+time+"ms");

	start = System.currentTimeMillis();
	for (int i=0; i<s.length; i++) {
	    t.remove(n[i]);
	}      
	time = System.currentTimeMillis()-start;
	System.out.println("remove "+s.length+" elements in "+time+"ms");
	
	
    }
    
}
