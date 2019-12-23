package com.monirul.toyrobot.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.board.SquareBoard;
import com.monirul.toyrobot.command.game.ReportCmd;
import com.monirul.toyrobot.simulation.Direction;
import com.monirul.toyrobot.simulation.Position;
import com.monirul.toyrobot.robot.SimpleRobot;
import com.monirul.toyrobot.exception.ApplicationException;

public class TestGeneralCommand {

	private SimpleRobot robot;
	@Before
	public void setup() throws ApplicationException{
		robot = new SimpleRobot();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_report() throws ApplicationException {
		Position position = new Position(2, 2, Direction.NORTH);
		robot.setNewPosition(position);
		GameContext gameContext = new GameContext(robot, new SquareBoard(5));
		new ReportCmd().execute(gameContext);
		Position currentPosition =  gameContext.getRobot().getCurrentPosition();
		assertEquals(2, currentPosition.getX());
		assertEquals(2, currentPosition.getY());

	}

}
