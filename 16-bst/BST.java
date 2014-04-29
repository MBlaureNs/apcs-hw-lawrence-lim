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
	return search2(n,root);
    }
    public Node search2(int n, Node cur) {
	if(cur==null) {return null;}
	else if(cur.data==n) {return cur;}
	else if(n<cur.data) {return search2(n,cur.left);}
	else {return search2(n,cur.right);}
    }

    public void delete(int n) {
	delete(search(n));
    }
    public void delete(Node n) {
	Node cur = n;
	if(cur==null) {return;}
	if(cur.left==null && cur.right==null) {
	    if(cur==root) {root=null;}
	    else if(n.data<cur.prev.data) {cur.prev.left = null;}
	    else {cur.prev.right = null;}
	} else if (cur.left==null) {
	    if(cur==root) {root=cur.right;}
	    else if(n.data<cur.prev.data) {cur.prev.left = cur.right;}
	    else {cur.prev.right = cur.right;}
	} else if (cur.right==null) {
	    if(cur==root) {root=cur.left;}
	    else if(n.data<cur.prev.data) {cur.prev.left = cur.left;}
	    else {cur.prev.right = cur.left;}
	} else {
	    Node next = cur.left;
	    while(next.right!=null) {next=next.right;}
	    cur.data = next.data;
	    delete(next);
	}
    }
    
    public String toString() {
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

