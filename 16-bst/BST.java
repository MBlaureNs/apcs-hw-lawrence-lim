public class BST {
    private class Node {
        int data;
        Node left,right,prev;
	
        Node(int n, Node p) {
	    data = n;
	    prev = p;
	    left = null;
	    right = null;
	}
	
	public String toString() {return ""+data;}
    }

    private Node root;
    
    public BST() {
	root = null;
    }

    public void insert(int n) {
	Node prev = null;
	Node cur = root;
	while(cur!=null) {
	    if(cur.data == n) {
		return;
	    } else if (n<cur.data) {
		prev = cur;
		cur = cur.left;
	    } else {
		prev = cur;
		cur = cur.right;
	    }
	}
	
	Node toAdd = new Node(n,prev);
	if(prev==null) {
	    root = toAdd;
	} else {
	    if (n<prev.data) {toAdd.prev.left = toAdd;} 
	    else {toAdd.prev.right = toAdd;}
	}
    }
    
    public Node search(int n) {
	Node cur = root;
	while (cur!=null) {
	    if (n==cur.data) {return cur;} 
	    else if (n<cur.data) {cur=cur.left;} 
	    else {cur=cur.right;}
	}
	return null;
    }

    public Node search2(int n) {
	return search2b(n,root);
    }
    public Node search2b(int n, Node cur) {
	if(cur==null) {return null;}
	else if(cur.data==n) {return cur;}
	else if(n<cur.data) {return search2b(n,cur.left);}
	else {return search2b(n,cur.right);}
    }
    
    public String toString() {
	int depth = 0;
	return treeString(root,0);
    }
    public String treeString(Node n, int depth) {
	String r = "";
	for(int i=0; i<depth; i++) {
	    r+="  ";
	}
	if(n==null) {
	    r+= "null\n";
	} else {
	    r+= n.data+"\n"
		+treeString(n.left,depth+1)+treeString(n.right,depth+1);
	}
	return r;
    }
}

