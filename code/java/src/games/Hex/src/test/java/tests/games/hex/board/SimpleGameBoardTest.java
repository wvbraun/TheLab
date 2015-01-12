package tests.games.hex.board;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import code.games.hex.board.SimpleGameBoard;
import code.games.hex.board.Tile;
import code.games.hex.gameMechanics.Move;
import code.games.hex.gameMechanics.PlayerColor;

public class SimpleGameBoardTest {

	private SimpleGameBoard board;
	private int size = 10;

	Class<?> c;

	@Before
	public void setup() throws ClassNotFoundException {
		try {
			c = Class.forName("edu.indiana.cs.c212.board.SimpleGameBoard");
		} finally {
		}
	}
	
	@Before
	public void setUp() throws Exception {
		board = new SimpleGameBoard(size);
	}	
	
	@Test
	public void testSimpleGameBoardConstructor() {
		assertNotNull(board);
	}

	@Test
	public void testSimpleGameBoardCopyConstructorGoalNodes(){
		SimpleGameBoard copy = new SimpleGameBoard(board);
		assertNotNull(copy);
		assertNotSame(board.getTileAt(-1, 0), copy.getTileAt(-1, 0));
		assertNotSame(board.getTileAt(size, 0), copy.getTileAt(size, 0));
		assertNotSame(board.getTileAt(0, -1), copy.getTileAt(0, -1));
		assertNotSame(board.getTileAt(0, size), copy.getTileAt(0, size));
		assertEquals(board.getTileAt(-1, 0), copy.getTileAt(-1, 0));
		assertEquals(board.getTileAt(size, 0), copy.getTileAt(size, 0));
		assertEquals(board.getTileAt(0, -1), copy.getTileAt(0, -1));
		assertEquals(board.getTileAt(0, size), copy.getTileAt(0, size));	
	}
	
	@Test
	public void testSimpleGameBoardCopyConstructorInnerNodes(){
		SimpleGameBoard copy = new SimpleGameBoard(board);	
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				assertNotSame(board.getTileAt(i, j), copy.getTileAt(i, j));
				assertEquals(board.getTileAt(i, j), copy.getTileAt(i, j));
			}
		}
	}
	
	@Test
	public void testSimpleGameBoardCopyConstructorSize(){
		SimpleGameBoard copy = new SimpleGameBoard(board);
		assertEquals(board.getSize(), copy.getSize());
	}
	
	
	@Test
	public void testSimpleGameBoardInheritance() throws ClassNotFoundException,
			NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {
		assertEquals(c.getDeclaredConstructors().length, 2);
		board = new SimpleGameBoard(4);
		assertNotNull(board);

		assertEquals("You forgot to set your board size",board.getSize(), 4);
		
	}

	@Test
	public void testGetTileAt() {		
		Tile t = board.getTileAt(3, 2);
		assertNotNull(t);
		assertEquals("The X value of your returned Tile is incorrect", t
				.getPoint().x, new Point(3, 2).x);
		assertEquals("The Y value of your returned Tile is incorrect", t
				.getPoint().y, new Point(3, 2).y);
	}

	@Test
	public void testGetTileAtNegative() {
		Tile t = board.getTileAt(-3, -2);
		assertNull(t);
	}
	
	@Test
	public void testGetTileAtNegative2() {
		Tile t = board.getTileAt(-3, 2);
		assertNull(t);
	}
	
	@Test
	public void testGetTileAtNegative3() {
		Tile t = board.getTileAt(3, -2);
		assertNull(t);
	}

	@Test
	public void testGetTileAtEastGoal() {
		Tile t = board.getTileAt(-1, 2);
		assertNotNull(t);
		assertEquals("The X value of your returned Tile is incorrect",
				t.getPoint().x, new Point(-1, 2).x);

	}

	@Test
	public void testGetTileAtNorthGoal() {
		Tile t = board.getTileAt(3, -1);
		assertNotNull(t);
		assertEquals("The Y value of your returned Tile is incorrect", t
				.getPoint().y, new Point(3, -1).y);
	}

	@Test
	public void testGetTileAtWestGoal() {
		Tile t = board.getTileAt(4, 2);
		assertNotNull(t);
		assertEquals("The X value of your returned Tile is incorrect", t
				.getPoint().x, new Point(4, 2).x);
	}

	@Test
	public void testGetTileAtSouthGoal() {

		Tile t = board.getTileAt(3, 4);
		assertNotNull(t);
		assertEquals("The Y value of your returned Tile is incorrect", t
				.getPoint().y, new Point(3, 4).y);
	}

	
	@Test
	public void testMakeMove() {
		board = new SimpleGameBoard(4);
		board.makeMove(new Move(2, 3), PlayerColor.RED);
		assertEquals("You are not changing the board's Tiles correctly", board
				.getTileAt(2,3).getColor(), PlayerColor.RED);
	}
	
	@Test (expected = Throwable.class)
	public void testMakeMove2()  {
		board = new SimpleGameBoard(4);
		//this line will throw an exception because it's an invalid move for a SimpleGameBoard
		//rules handle validity, this should make your code vomit, but it's okay
		//because we have a bucket and were totally expecting it.
		board.makeMove(new Move(-2, 3), PlayerColor.RED);
		
	}

	@Test
	public void testGetSize() {
		board = new SimpleGameBoard(4);
		assertEquals(board.getSize(), 4);
		assertEquals(board.getSize(), 4);
	}		

	@Test(timeout = 1000)
	public void testGetNeighborsNormal() {
		Set<Tile> testSet = new HashSet<Tile>();
		Tile testTile = new Tile(PlayerColor.BLANK, new Point(2, 2));
		testSet.add(board.getTileAt(2, 1));
		testSet.add(board.getTileAt(2, 3));
		testSet.add(board.getTileAt(1, 2));
		testSet.add(board.getTileAt(1, 3));
		testSet.add(board.getTileAt(3, 2));
		testSet.add(board.getTileAt(3, 1));
		assertEquals(testSet, board.getNeighbors(testTile));
 
	}

	@Test(timeout = 1000)
	public void testGetNeighborsTopLeftCorner() {
		Set<Tile> testSet = new HashSet<Tile>();
		Tile testTile = new Tile(PlayerColor.BLANK, new Point(0, 0));
		testSet.add(board.getTileAt(0, -1));
		testSet.add(board.getTileAt(0, 1));
		testSet.add(board.getTileAt(-1, 0));
		testSet.add(board.getTileAt(1, 0));

		assertEquals(testSet, board.getNeighbors(testTile));

	}

	@Test(timeout = 1000)
	public void testGetNeighborsTopRightCorner() {
		Set<Tile> testSet = new HashSet<Tile>();
		Tile testTile = new Tile(PlayerColor.BLANK, new Point(size - 1, 0));
		testSet.add(board.getTileAt(0, -1));
		testSet.add(board.getTileAt(size, 0));
		testSet.add(board.getTileAt(size - 2, 0));
		testSet.add(board.getTileAt(size - 1, 1));
		testSet.add(board.getTileAt(size - 2, 1));

		assertEquals(testSet, board.getNeighbors(testTile));

	}

	@Test(timeout = 1000)
	public void testGetNeighborsBottomRightCorner() {
		Set<Tile> testSet = new HashSet<Tile>();
		Tile testTile = new Tile(PlayerColor.BLANK, new Point(size - 1,
				size - 1));
		testSet.add(board.getTileAt(0, size));
		testSet.add(board.getTileAt(size, 0));
		testSet.add(board.getTileAt(size - 1, size - 2));
		testSet.add(board.getTileAt(size - 2, size - 1));

		assertEquals(testSet, board.getNeighbors(testTile));

	}

	@Test(timeout = 1000)
	public void testGetNeighborsBottomLeftCorner() {
		Set<Tile> testSet = new HashSet<Tile>();
		Tile testTile = new Tile(PlayerColor.BLANK, new Point(0, size - 1));
		testSet.add(board.getTileAt(-1, 0));
		testSet.add(board.getTileAt(0, size));
		testSet.add(board.getTileAt(0, size - 2));
		testSet.add(board.getTileAt(1, size - 1));
		testSet.add(board.getTileAt(1, size - 2));

		assertEquals(testSet, board.getNeighbors(testTile));

	}

	@Test(timeout = 1000)
	public void testGetNeighborsTopRedGoal() {
		Set<Tile> testSet = new HashSet<Tile>();
		Tile testTile = new Tile(PlayerColor.RED, new Point(0, -1));
		for (int i = 0; i < size; i++)
			testSet.add(board.getTileAt(i, 0));

		assertEquals(testSet, board.getNeighbors(testTile));
	}

	@Test(timeout = 100)
	public void testGetNeighborsBottomRedGoal() {
		Set<Tile> testSet = new HashSet<Tile>();
		Tile testTile = new Tile(PlayerColor.RED, new Point(0, size));
		for (int i = 0; i < size; i++)
			testSet.add(board.getTileAt(i, size - 1));

		assertEquals(testSet, board.getNeighbors(testTile));
	}

	@Test(timeout = 100)
	public void testGetNeighborsLeftBlueGoal() {
		Set<Tile> testSet = new HashSet<Tile>();
		Tile testTile = new Tile(PlayerColor.BLUE, new Point(-1, 0));
		for (int i = 0; i < size; i++)
			testSet.add(board.getTileAt(0, i));

		assertEquals(testSet, board.getNeighbors(testTile));
	}

	@Test(timeout = 100)
	public void testGetNeighborsRightBlueGoal() {
		Set<Tile> testSet = new HashSet<Tile>();
		Tile testTile = new Tile(PlayerColor.BLUE, new Point(size, 0));
		for (int i = 0; i < size; i++)
			testSet.add(board.getTileAt(size - 1, i));

		assertEquals(testSet, board.getNeighbors(testTile));
	}

}

