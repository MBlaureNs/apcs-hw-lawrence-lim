public class Position implements Comparable<Position> {
    public int x;
    public int y;
    
    public Position(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public boolean equals(Object o) {
	if (o==null) {return false;}
	if (o.getClass() != this.getClass()) {return false;}
	else {
	    Position p = (Position) o;
	    if (p.x==this.x) {
		if (p.y==this.y) {return true;}
	    }
	}
	return false;
    }

    public int compareTo(Position p) {
	if (this.y == p.y && this.x == p.x) {return 0;}
	if (this.y < p.y) {return -1;}
	if (this.y > p.y) {return 1;}
	if (this.x < p.x) {return -1;}
	return 1;
    }

    public String toString() {
	return "Position at ("+x+", "+y+")";
    }
}
