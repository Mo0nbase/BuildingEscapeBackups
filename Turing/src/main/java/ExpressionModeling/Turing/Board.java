package ExpressionModeling.Turing;

public class Board {
	long[] board = new long[12];
	int counter = 0;
	
	public Board() {
		/**
		 * The board array is a set of 12 bitboards
		 * each a different kind of peice and color
		 * - Even indexes are white odd indexes are black
		 * - The order of peices is order of points 
		 *   Pawn, Knight, Bishop, Rook, Queen, King
		 * - The board is defined in this order (rook or index 6)
		 * 
		 *  8 7 6 5 4 3 2 1
		 * -----------------
		 *  0 0 0 0 0 0 0 0
		 *  0 0 0 0 0 0 0 0
		 *  0 0 0 0 0 0 0 0
		 *  0 0 0 0 0 0 0 0
		 *  0 0 0 0 0 0 0 0
		 *  0 0 0 0 0 0 0 0
		 *  0 0 0 0 0 0 0 0
		 *  1 0 0 0 0 0 0 1
		 *  
		 *  - otherwise described as 
		 *  0b0000000100000000000000000000000000000000000000000000000000000001L;
		 */
		
		
		// Pawns
		// White
		board[0] = 0b00000010_00000010_00000010_00000010_00000010_00000010_00000010_00000010L;
		// Black
		board[1] = 0b01000000_01000000_01000000_01000000_01000000_01000000_01000000_01000000L;
		
		// Knights
		// White
		board[2] = 0b00000000_00000001_00000000_00000000_00000000_00000000_00000001_00000000L;
		// Black
		board[3] = 0b00000000_10000000_00000000_00000000_00000000_00000000_10000000_00000000L;
		
		// Bishops
		// White
		board[4] = 0b00000000_00000000_00000001_00000000_00000000_00000001_00000000_00000000L;
		// Black
		board[5] = 0b00000000_00000000_10000000_00000000_00000000_10000000_00000000_00000000L;
		
		// Rooks
		// White
		board[6] = 0b00000001_00000000_00000000_00000000_00000000_00000000_00000000_00000001L;
		// Black
		board[7] = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_10000000L;
		
		// Queens
		// White
		board[8] = 0b00000000_00000000_00000000_00000000_00000001_00000000_00000000_00000000L;
		// Black
		board[9] = 0b00000000_00000000_00000000_00000000_10000000_00000000_00000000_00000000L;
		
		// Kings
		// White
		board[10] = 0b00000000_00000000_00000000_00000001_00000000_00000000_00000000_00000000L;
		// Black
		board[11] = 0b00000000_00000000_00000000_10000000_00000000_00000000_00000000_00000000L;
	}
	
	public void generateMoves() {
		
		
	}
	
	public long getOccupied() {
		long fullBoard = 0;
		for(int i = 0; i < board.length; i++) {
			fullBoard |= board[i];
		}
		return fullBoard;
	}
	
	
	public void generatePawn() {
		
	}
	
	public void generateKnight() {
		
	}
	
	public void generateBishop(){
		
	}
	
	public void generateRook() {
		
	}
	
	public void generateQueen() {
		
	}
	
	public String getBoard() {
		long fullBoard = 0;
		for(int i = 0; i < board.length; i++) {
			fullBoard |= board[i];
		}
		return Long.toBinaryString(fullBoard);
	}
}
