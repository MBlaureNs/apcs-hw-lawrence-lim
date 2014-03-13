public enum KnightMove {
    UPLEFT      (-1,-2),
    UPRIGHT     ( 1,-2),
    DOWNLEFT    (-1, 2),
    DOWNRIGHT   ( 1, 2),
    LEFTUP      (-2,-1),
    LEFTDOWN    (-2, 1),
    RIGHTUP     ( 2,-1),
    RIGHTDOWN   ( 2, 1); 

    public static final KnightMove[] MOVES = {
	UPLEFT,UPRIGHT,DOWNLEFT,DOWNRIGHT,
	LEFTUP,LEFTDOWN,RIGHTUP,RIGHTDOWN
    };
    
    public int x;
    public int y;

    KnightMove(int dx, int dy) {
	x=dx;
	y=dy;
    }
}
