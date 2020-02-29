package ExpressionModeling.Turing;


public class App 
{
    public static void main( String[] args )
    {
//    	Board game = new Board();
//    	displayBoard(Long.toBinaryString(game.getOccupied()));
//    	System.out.println(0xa8002c000108020L);
//    	long blockers = 0b00011110_00000000_00000000_00000000_00000000_10000000_10000000_00000000L;
//    	long attack = 0b01111110_10000000_10000000_10000000_10000000_10000000_10000000_00000000L;
//    	long peices = attack & blockers;
//    	displayBoard((peices * 0xa8002c000108020L) >> 52);
//    	System.out.println((peices * 0xa8002c000108020L) >> 52);
//    	int magicIndex = (int) ((peices * 0xa8002c000108020L) >> 52);
//    	
//    	
//    	MagicNumbers attacks = new MagicNumbers();
//    	for(int i = 0; i < attacks.attackSets.length; i++) {
//    		if(attacks.attackSets[magicIndex] == magicIndex) {
//    			System.out.println("Match:" + i);
//    		}
//    	}
//    	displayBoard(attacks.attackSets[magicIndex]);
    	displayBoard(0b00010000_00000000_00000000_00000000_00000000_10000000_00000000_00000000L);
    	System.out.println(Long.bit(0b00010000_00000000_00000000_00000000_00000000_10000000_00000000_00000000L));
   
    	
    }
    
    public static void displayBoard(long given) {
    	System.out.println();
    	String board = Long.toBinaryString(given);
    	
    	while(board.length() < 64) {
    		board = "0" + board;
    	}

    	char[][] tempBoard = new char[8][8];
    	for(int row = 0; row < 8; row++) {
    		for(int col = 0; col < 8; col++) {
    			tempBoard[row][col] = board.charAt((row * 8) + col);
    		}
    	}
    	
    	System.out.println(" -------------------------------");
    	for(int row = 7; row >= 0; row--) {
    		System.out.print("| ");
    		for(int col = 0; col < 8; col++) {
    			System.out.print(tempBoard[row][col] + " | ");
    		} 
    		System.out.println();
    	}
    	System.out.println(" -------------------------------");
    	System.out.println();
    }
}
