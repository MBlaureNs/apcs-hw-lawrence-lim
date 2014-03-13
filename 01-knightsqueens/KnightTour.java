public class KnightTour {
    public int[][] solve(int z) {
	int[][] board = new int[z][z];
	Position p = new Position(0,0);
	return solve(board,p,1);
    }
    public int[][] solve(int[][] argboard, Position p, int n) {
	//printboard(argboard);
	int[][] board = new int[argboard.length][argboard[0].length];
	for(int y=0; y<board.length; y++) {
	    for(int x=0; x<board[0].length; x++) {
		board[x][y] = argboard[x][y];
	    }
	}
	board[p.x][p.y] = n;
	if(isSolved(board)) {return board;}
	KnightMove m;
	Position next;
	int[][] r;
	for(int i=0; i<KnightMove.MOVES.length; i++) {
	    m = KnightMove.MOVES[i];
	    next = new Position(p.x+m.x, p.y+m.y);
	    if(next.x>=0 && next.x<board[0].length &&
	       next.y>=0 && next.y<board.length) {
	        if(board[next.x][next.y]==0) {
		    r = solve(board,next,n+1);
		    if(r!=null) {return r;}
		}
	    }
	}
	return null;
    }
    
    private boolean isSolved(int[][] board) {
	for(int y=0; y<board.length; y++) {
	    for(int x=0; x<board[0].length; x++) {
		if(board[x][y]==0) {return false;}
	    }
	}
	return true;
    }

    public void printboard(int[][] board) {
	for(int y=0; y<board.length; y++) {
	    for(int x=0; x<board[0].length; x++) {
		if(board[x][y]<10){System.out.print(" ");}
		System.out.print(board[x][y]+"|");
	    }
	    System.out.println();
	}
	System.out.println();
    }
}
