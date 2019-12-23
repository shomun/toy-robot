package com.monirul.toyrobot.board;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.monirul.toyrobot.simulation.Direction;
import com.monirul.toyrobot.simulation.Position;
import com.monirul.toyrobot.exception.ApplicationException;

public class TestBoard {

	private SquareBoard board;
	@Before
	public void setUp() throws Exception {
		board = new SquareBoard(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_initialize_board() {
		Assert.assertEquals(5,board.getCols());
		Assert.assertEquals(5,board.getRows());
	}

	@Test
	public void should_return_true_for_valid_position() {
		try {
			Position position = new Position(1, 2, Direction.EAST);
			Assert.assertEquals(true,board.isValidPosition(position));
		} catch (ApplicationException e) {
			
		}
	}
	
	@Test(expected=ApplicationException.class)
	public void should_return_error_on_invalid_position() throws ApplicationException {
		Position position = new Position(-1, 0, Direction.EAST);
		board.isValidPosition(position);
		
	}
	
	@Test(expected=ApplicationException.class)
	public void should_return_error_on_invalid_position_out_of_range() throws ApplicationException {
		Position position = new Position(1, 6, Direction.EAST);
		board.isValidPosition(position);
		
	}

}
