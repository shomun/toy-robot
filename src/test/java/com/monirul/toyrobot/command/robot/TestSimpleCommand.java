package com.monirul.toyrobot.command.robot;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.board.SquareBoard;
import com.monirul.toyrobot.simulation.Direction;
import com.monirul.toyrobot.simulation.Position;
import com.monirul.toyrobot.robot.SimpleRobot;
import com.monirul.toyrobot.exception.ApplicationException;

public class TestSimpleCommand {

	private SimpleRobot robot;
	@Before
	public void setup() throws ApplicationException{
		robot = new SimpleRobot();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void turnLeft() throws ApplicationException {
		Position position = new Position(2, 2, Direction.NORTH);
		robot.setNewPosition(position);
		GameContext gameContext = new GameContext(robot, new SquareBoard(5));
		new MoveLeftCmd().execute(gameContext);
		Assert.assertEquals(Direction.WEST, robot.getCurrentPosition().getDirection());
	}
	
	@Test
	public void turnRight() throws ApplicationException {
		Position position = new Position(2, 2, Direction.NORTH);
		robot.setNewPosition(position);
		GameContext gameContext = new GameContext(robot, new SquareBoard(5));
		new MoveRightCmd().execute(gameContext);
		Assert.assertEquals(Direction.EAST, robot.getCurrentPosition().getDirection());
	}
	
	@Test(expected = ApplicationException.class)
	public void turnLeftWithoutPlacing() throws ApplicationException {
		GameContext gameContext = new GameContext(robot, new SquareBoard(5));
		new MoveLeftCmd().execute(gameContext);
	}
	
	@Test(expected = ApplicationException.class)
	public void turnRightWithoutPlacing() throws ApplicationException {
		GameContext gameContext = new GameContext(robot, new SquareBoard(5));
		new MoveRightCmd().execute(gameContext);
	}
	
	@Test
	public void moveRobot() throws ApplicationException {
		Position position = new Position(2, 2, Direction.NORTH);
		robot.setNewPosition(position);
		GameContext gameContext = new GameContext(robot, new SquareBoard(5));
		new MoveForwardCmd().execute(gameContext);
		Assert.assertEquals(3, robot.getCurrentPosition().getY());
	}
	
	@Test(expected = ApplicationException.class)
	public void moveWithoutPlacing() throws ApplicationException {
		GameContext gameContext = new GameContext(robot, new SquareBoard(5));
		new MoveForwardCmd().execute(gameContext);
	}

}
