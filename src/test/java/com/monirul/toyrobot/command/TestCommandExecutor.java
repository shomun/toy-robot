package com.monirul.toyrobot.command;

import com.monirul.toyrobot.command.robot.MoveForwardCmd;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.board.SquareBoard;
import com.monirul.toyrobot.command.game.ReportCmd;
import com.monirul.toyrobot.simulation.Direction;
import com.monirul.toyrobot.simulation.Position;
import com.monirul.toyrobot.robot.SimpleRobot;
import com.monirul.toyrobot.exception.ApplicationException;

import static org.junit.Assert.assertEquals;

public class TestCommandExecutor {

	private SimpleRobot robot;
	@Before
	public void setup() throws ApplicationException{
		robot = new SimpleRobot();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_execute_report_command() throws ApplicationException {
		Position position = new Position(2, 2, Direction.NORTH);
		robot.setNewPosition(position);
		GameContext gameContext = new GameContext(robot, new SquareBoard(5));
		
		CommandExecutor.INSTANCE.executeCommand(new ReportCmd(), gameContext);
		Position currentPosition =  gameContext.getRobot().getCurrentPosition();
		assertEquals(2, currentPosition.getX());
		assertEquals(2, currentPosition.getY());
	}

	@Test
	public void should_execute_move_command() throws ApplicationException {
		Position position = new Position(2, 2, Direction.NORTH);
		robot.setNewPosition(position);
		GameContext gameContext = new GameContext(robot, new SquareBoard(5));

		CommandExecutor.INSTANCE.executeCommand(new MoveForwardCmd(), gameContext);
		Position currentPosition =  gameContext.getRobot().getCurrentPosition();
		assertEquals(2, currentPosition.getX());
		assertEquals(3, currentPosition.getY());
	}

}
