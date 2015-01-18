package tests.games.hex.board;


import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import code.games.hex.board.Tile;
import code.games.hex.gameMechanics.PlayerColor;

public class TileTest {

	Tile t;

	@Before
	public void setUp() {
		t = new Tile(PlayerColor.BLANK, new Point(2, 2));
	}

	@Test
	public void testTile() {		
		assertNotNull(t);
	}
	
	@Test
	public void testTileTile(){
		Tile t2 = new Tile(t);
		//System.out.println(t.toString() + t2);
		//System.out.println(t.getPoint().toString() + t2.getPoint());
		assertNotSame(t, t2);
		assertNotSame(t.getPoint(), t2.getPoint());
		assertEquals(t.getColor(), t2.getColor());
		assertEquals(t.getPoint(), t2.getPoint());
	}
	
	@Test
	public void testGetColor(){
		// make sure the the value from that field (if the
		// function performs properly) is not null
		PlayerColor p = t.getColor();
		assertNotNull(p);
		assertEquals(PlayerColor.BLANK, p);
	}
	
	@Test
	public void testGetColor2(){	
		t = new Tile(PlayerColor.RED, new Point(2, 2));
		PlayerColor p = t.getColor();
		assertNotNull(p);
		assertEquals(PlayerColor.RED, p);
	}
	
	@Test
	public void testGetColor3(){	
		t = new Tile(PlayerColor.BLUE, new Point(2, 2));
		PlayerColor p = t.getColor();
		assertNotNull(p);
		assertEquals(PlayerColor.BLUE, p);
	}

	@Test
	public void testSetColor(){
		PlayerColor pc = t.getColor();
		assertNotNull(pc);		
		t.setColor(PlayerColor.RED);
		assertEquals(PlayerColor.RED, t.getColor());
	}


	@Test
	public void testEqualsObject() {
		Tile s = new Tile(PlayerColor.BLANK, new Point(2, 2));		
		assertTrue(t.equals(s));
		assertTrue(s.equals(t));
	}
	
	@Test
	public void testEqualsObject2() {
		Tile s = new Tile(PlayerColor.RED, new Point(2, 2));		
		assertFalse(t.equals(s));
		assertFalse(s.equals(t));
	}
	
	@Test
	public void testEqualsObject3() {
		Tile s = new Tile(PlayerColor.BLANK, new Point(1, 2));		
		assertFalse(t.equals(s));
		assertFalse(s.equals(t));
	}
	
	@Test
	public void testEqualsObject4() {
		Tile s = new Tile(PlayerColor.RED, new Point(1, 2));		
		assertFalse(t.equals(s));
		assertFalse(s.equals(t));
	}


	@Test
	public void testGetPoint() {
		Tile t = new Tile(PlayerColor.RED, new Point(0,0));
		assertEquals(new Point(0,0), t.getPoint());
	}


	@Test
	public void testToString() {
		Tile t = new Tile(PlayerColor.RED, new Point(0,0));
		assertEquals("java.awt.Point[x=0,y=0] RED", t.toString());
	}

}
