import java.util.*;
import java.io.*;

public class TextWhatever {
    public ArrayList<String> getWords(File f) {
	ArrayList<String> r = new ArrayList<String>();
	Scanner scan;

	try {
	    scan = new Scanner(f);
	} catch (Exception e) {
	    System.out.println("oh.");
	    System.out.println(e);
	    return null;
	}	
	
	while(scan.hasNext()) {
	    r.add(scan.next());
	}
	return r;
    }
}