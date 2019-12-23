package com.monirul.toyrobot;

import java.net.URL;

import static org.junit.Assert.*;

import com.monirul.toyrobot.command.GameCommandConfig;
import com.monirul.toyrobot.simulation.Direction;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;


import com.monirul.toyrobot.board.Board;
import com.monirul.toyrobot.board.SquareBoard;
import com.monirul.toyrobot.robot.Robot;
import com.monirul.toyrobot.robot.SimpleRobot;
import com.monirul.toyrobot.exception.ApplicationException;

public class GameTest {

	private Game game;
	private Board board;
	private Robot robot;
	@Before
	public void setUp() throws Exception {
		board = new SquareBoard(5);
		robot = new SimpleRobot();
		game = new Game(robot, board);
		game.setGameCommandConfig(GameCommandConfig.INSTANCE);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_initialize_game() {
		assertTrue( game.getRobot() instanceof SimpleRobot);
	}

	@Test
	public void play_should_success_from_file_instruction() throws ApplicationException {
		URL url =this.getClass().getResource("/robot_instruction.txt");
		game.play(url.getPath());
		assertEquals(5, game.getRobot().getCurrentPosition().getX());
		assertEquals(5, game.getRobot().getCurrentPosition().getY());
		assertEquals(Direction.EAST, game.getRobot().getCurrentPosition().getDirection());
	}

	@Test
	public void play_should_success_from_multiline_file_instruction() throws ApplicationException {
		URL url =this.getClass().getResource("/robot_instruction_muliline.txt");
		game.play(url.getPath());
		assertEquals(1, game.getRobot().getCurrentPosition().getX());
		assertEquals(5, game.getRobot().getCurrentPosition().getY());
		assertEquals(Direction.NORTH, game.getRobot().getCurrentPosition().getDirection());
	}

}
