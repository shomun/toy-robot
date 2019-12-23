package com.monirul.toyrobot.simulation;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_initilize() {
		Direction direction = Direction.NORTH;
		assertEquals(Direction.NORTH, direction);
	}
	
	@Test
	public void should_rotateRightNorth2East(){
		Direction direction = Direction.NORTH;
		Direction newDirection = direction.rotateRight();
		assertEquals(Direction.EAST, newDirection);
	}
	
	@Test
	public void should_rotateLeftNorth2West(){
		Direction direction = Direction.NORTH;
		Direction newDirection = direction.rotateLeft();
		assertEquals(Direction.WEST, newDirection);
	}
	
	@Test
	public void should_rotateRightEast2South(){
		Direction direction = Direction.EAST;
		Direction newDirection = direction.rotateRight();
		assertEquals(Direction.SOUTH, newDirection);
	}
	
	@Test
	public void should_rotateLeftEast2North(){
		Direction direction = Direction.EAST;
		Direction newDirection = direction.rotateLeft();
		assertEquals(Direction.NORTH, newDirection);
	}
	
	
	@Test
	public void should_rotateRightSouth2East(){
		Direction direction = Direction.SOUTH;
		Direction newDirection = direction.rotateRight();
		assertEquals(Direction.WEST, newDirection);
	}
	
	@Test
	public void should_rotateLeftSouth2West(){
		Direction direction = Direction.SOUTH;
		Direction newDirection = direction.rotateLeft();
		assertEquals(Direction.EAST, newDirection);
	}
	
	@Test
	public void should_rotateRightWest2North(){
		Direction direction = Direction.WEST;
		Direction newDirection = direction.rotateRight();
		assertEquals(Direction.NORTH, newDirection);
	}
	
	@Test
	public void should_rotateLeftWest2South(){
		Direction direction = Direction.WEST;
		Direction newDirection = direction.rotateLeft();
		assertEquals(Direction.SOUTH, newDirection);
	}


	

}
