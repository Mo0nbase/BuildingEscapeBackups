package ExpressionModeling.Turing;

import java.util.HashMap;

public class Rays {
	private long[][] rays = new long[8][64];
	private HashMap<String, Integer> dir = new HashMap<String, Integer>() {{
		put("NORTH", 1);
		put("SOUTH", 2);
		put("EAST", 3);
		put("WEST", 4);
		put("NORTH_WEST", 5);
		put("NORTH_EAST", 6);
		put("SOUTH_WEST", 7);
		put("SOUTH_EAST", 8);
	}};
	private long ONE = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;
	private long FILE_A = 0x101010101010101L;
	private long FILE_H = 0x8080808080808080L;
	
	public Rays() {
		for(int square = 0; square < 64; square++) {
		    // North
		    rays[dir.get("NORTH")][square] = 0x0101010101010100L << square;

		    // South
		    rays[dir.get("SOUTH")][square] = 0x0080808080808080L >> (63 - square);

		    // East
		    rays[dir.get("EAST")][square] = 2 * ((ONE << (square | 7)) - (ONE << square));

		    // West
		    rays[dir.get("WEST")][square] = (ONE << square) - (ONE << (square & 56));

		    // North West
		    rays[dir.get("NORTH_WEST")][square] = _westN(0x102040810204000L, 7 - (square % 8)) << ((square / 8) * 8);

		    // North East
		    rays[dir.get("NORTH_EAST")][square] = _eastN(0x8040201008040200L, (square % 8)) << ((square / 8) * 8);

		    // South West
		    rays[dir.get("SOUTH_WEST")][square] = _westN(0x40201008040201L, 7 - (square % 8)) >> ((7 - (square / 8)) * 8);

		    // South East
		    rays[dir.get("SOUTH_EAST")][square] = _eastN(0x2040810204080L, (square % 8)) >> ((7 - (square / 8)) * 8);	
		}
	}
	
	public long getRay(String direction, int square) {
		return rays[dir.get(direction)][square];
	}
	

	private long _eastN(long board, int n) {
	  long newBoard = board;
	  for (int i = 0; i < n; i++) {
	    newBoard = ((newBoard << 1) & (~FILE_A));
	  }

	  return newBoard;
	}


	private long _westN(long board, int n) {
	  long newBoard = board;
	  for (int i = 0; i < n; i++) {
	    newBoard = ((newBoard >> 1) & (~FILE_H));
	  }

	  return newBoard;
	}
}
