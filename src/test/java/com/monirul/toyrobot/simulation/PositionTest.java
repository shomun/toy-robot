package com.monirul.toyrobot.simulation;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.monirul.toyrobot.exception.ApplicationException;

public class PositionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void initPosition_should_success() throws ApplicationException {
		Position postion = new Position(1, 2, Direction.NORTH);
		assertEquals(1,postion.getX());
		assertEquals(2,postion.getY());
		assertEquals(Direction.NORTH,postion.getDirection());
	}

	@Test(expected = ApplicationException.class)
	public void should_not_init_position_with_negative_value() throws ApplicationException {
		Position postion = new Position(-1, -2, Direction.NORTH);
		assertEquals(-1,postion.getX());
		assertEquals(-2,postion.getY());
		assertEquals(Direction.NORTH,postion.getDirection());
	}
	
	@Test(expected=ApplicationException.class)
	public void should_not_init_position_with_invalid_direction() throws ApplicationException {
		Position postion = new Position(1, 2, null);
		assertEquals(1,postion.getX());
		assertEquals(2,postion.getY());
		assertEquals(Direction.NORTH,postion.getDirection());
	}

	@Test
	public void should_move_one_position_to_north() throws ApplicationException {
		Position postion = new Position(1, 2, Direction.NORTH);
		Position newPosition =  postion.getNextPosition(1);
		assertEquals(3, newPosition.getY());
	}

	@Test
	public void should_move_one_position_to_east() throws ApplicationException {
		Position postion = new Position(1, 2, Direction.EAST);
		Position newPosition =  postion.getNextPosition(1);
		assertEquals(2, newPosition.getX());
	}

	@Test
	public void should_move_one_position_to_west() throws ApplicationException {
		Position postion = new Position(1, 2, Direction.WEST);
		Position newPosition =  postion.getNextPosition(1);
		assertEquals(0, newPosition.getX());
	}
}
