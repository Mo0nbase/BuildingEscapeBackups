package ExpressionModeling.Turing;

public class MagicNumbers {
	private final long ONE = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;
	private final long ZERO = 0b00000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;

	
	private final long RANK_1 = 0xffL;
	private final long RANK_2 = 0xff00L;
	private final long RANK_3 = 0xff0000L;
	private final long RANK_4 = 0xff000000L;
	private final long RANK_5 = 0xff00000000L;
	private final long RANK_6 = 0xff0000000000L;
	private final long RANK_7 = 0xff000000000000L;
	private final long RANK_8 = 0xff00000000000000L;

	private final long FILE_H = 0x8080808080808080L;
	private final long FILE_G = 0x4040404040404040L;
	private final long FILE_F = 0x2020202020202020L;
	private final long FILE_E = 0x1010101010101010L;
	private final long FILE_D = 0x808080808080808L;
	private final long FILE_C = 0x404040404040404L;
	private final long FILE_B = 0x202020202020202L;
	private final long FILE_A = 0x101010101010101L;

	private final long[] rookMagics = {
	    0xa8002c000108020L, 0x6c00049b0002001L, 0x100200010090040L, 0x2480041000800801L, 0x280028004000800L,
	    0x900410008040022L, 0x280020001001080L, 0x2880002041000080L, 0xa000800080400034L, 0x4808020004000L,
	    0x2290802004801000L, 0x411000d00100020L, 0x402800800040080L, 0xb000401004208L, 0x2409000100040200L,
	    0x1002100004082L, 0x22878001e24000L, 0x1090810021004010L, 0x801030040200012L, 0x500808008001000L,
	    0xa08018014000880L, 0x8000808004000200L, 0x201008080010200L, 0x801020000441091L, 0x800080204005L,
	    0x1040200040100048L, 0x120200402082L, 0xd14880480100080L, 0x12040280080080L, 0x100040080020080L,
	    0x9020010080800200L, 0x813241200148449L, 0x491604001800080L, 0x100401000402001L, 0x4820010021001040L,
	    0x400402202000812L, 0x209009005000802L, 0x810800601800400L, 0x4301083214000150L, 0x204026458e001401L,
	    0x40204000808000L, 0x8001008040010020L, 0x8410820820420010L, 0x1003001000090020L, 0x804040008008080L,
	    0x12000810020004L, 0x1000100200040208L, 0x430000a044020001L, 0x280009023410300L, 0xe0100040002240L,
	    0x200100401700L, 0x2244100408008080L, 0x8000400801980L, 0x2000810040200L, 0x8010100228810400L,
	    0x2000009044210200L, 0x4080008040102101L, 0x40002080411d01L, 0x2005524060000901L, 0x502001008400422L,
	    0x489a000810200402L, 0x1004400080a13L, 0x4000011008020084L, 0x26002114058042L
	};
	private final long[] bishopMagics = {
	    0x89a1121896040240L, 0x2004844802002010L, 0x2068080051921000L, 0x62880a0220200808L, 0x4042004000000L,
	    0x100822020200011L, 0xc00444222012000aL, 0x28808801216001L, 0x400492088408100L, 0x201c401040c0084L,
	    0x840800910a0010L, 0x82080240060L, 0x2000840504006000L, 0x30010c4108405004L, 0x1008005410080802L,
	    0x8144042209100900L, 0x208081020014400L, 0x4800201208ca00L, 0xf18140408012008L, 0x1004002802102001L,
	    0x841000820080811L, 0x40200200a42008L, 0x800054042000L, 0x88010400410c9000L, 0x520040470104290L,
	    0x1004040051500081L, 0x2002081833080021L, 0x400c00c010142L, 0x941408200c002000L, 0x658810000806011L,
	    0x188071040440a00L, 0x4800404002011c00L, 0x104442040404200L, 0x511080202091021L, 0x4022401120400L,
	    0x80c0040400080120L, 0x8040010040820802L, 0x480810700020090L, 0x102008e00040242L, 0x809005202050100L,
	    0x8002024220104080L, 0x431008804142000L, 0x19001802081400L, 0x200014208040080L, 0x3308082008200100L,
	    0x41010500040c020L, 0x4012020c04210308L, 0x208220a202004080L, 0x111040120082000L, 0x6803040141280a00L,
	    0x2101004202410000L, 0x8200000041108022L, 0x21082088000L, 0x2410204010040L, 0x40100400809000L,
	    0x822088220820214L, 0x40808090012004L, 0x910224040218c9L, 0x402814422015008L, 0x90014004842410L,
	    0x1000042304105L, 0x10008830412a00L, 0x2520081090008908L, 0x40102000a0a60140L,
	};
	
	private final long[] rookIndexBits = {
	    12, 11, 11, 11, 11, 11, 11, 12,
	    11, 10, 10, 10, 10, 10, 10, 11,
	    11, 10, 10, 10, 10, 10, 10, 11,
	    11, 10, 10, 10, 10, 10, 10, 11,
	    11, 10, 10, 10, 10, 10, 10, 11,
	    11, 10, 10, 10, 10, 10, 10, 11,
	    11, 10, 10, 10, 10, 10, 10, 11,
	    12, 11, 11, 11, 11, 11, 11, 12
	};
	
	private final long[] bishopIndexBits = {
	    6, 5, 5, 5, 5, 5, 5, 6,
	    5, 5, 5, 5, 5, 5, 5, 5,
	    5, 5, 7, 7, 7, 7, 5, 5,
	    5, 5, 7, 9, 9, 7, 5, 5,
	    5, 5, 7, 9, 9, 7, 5, 5,
	    5, 5, 7, 7, 7, 7, 5, 5,
	    5, 5, 5, 5, 5, 5, 5, 5,
	    6, 5, 5, 5, 5, 5, 5, 6
	};
	
	private final long[] rookMasks = new long[64];
	private final long[] bishopMasks = new long[64];

	
	private final long[][] rookTable = new long[64][4096];
	private final long[][] bishopTable = new long[64][1024];
	
	Rays rays = new Rays();

	public MagicNumbers() {
		initRookMasks();
		initBishopMasks();
	
	}
	
	
	private void initRookMasks() {
		for (int square = 0; square < 64; square++) {
		    rookMasks[square] = (rays.getRay("NORTH", square) & ~RANK_8) |
		        (rays.getRay("SOUTH", square) & ~RANK_1) |
		        (rays.getRay("EAST", square) & ~FILE_H) |
		        (rays.getRay("WEST", square) & ~FILE_A);
	   }
	}

	private void initBishopMasks() {
	  long edgeSquares = FILE_A | FILE_H | RANK_1 | RANK_8;
	  for (int square = 0; square < 64; square++) {
	    bishopMasks[square] = (rays.getRay("NORTH_EAST", square) | rays.getRay("NORTH_WEST", square) |
	        rays.getRay("SOUTH_WEST", square) | rays.getRay("SOUTH_EAST", square)) & ~(edgeSquares);
	  }
	}
	
	long getBlockersFromIndex(int index, long mask) {
		  long blockers = ZERO;
		  int bits = Long.bitCount(mask);
		  for (int i = 0; i < bits; i++) {
		    int bitPos = popLsb(mask);
		    if (index & (1 << i)) {
		      blockers |= (ONE << bitPos);
		    }
		  }
		  return blockers;
	}

	private int popLsb(long board) {
		int lsbIndex = __builtin_ffsll(board) - 1;
		board &= board - 1;
		return lsbIndex;
	}

}
