package com.monirul.toyrobot;

import com.monirul.toyrobot.board.Board;
import com.monirul.toyrobot.robot.Robot;

/**
 * Container to carry Robot and Board instance to be used by the Commands
 * @author Monirul
 *
 */
public class GameContext {

	private Robot robot;
	
	private Board board;
	
	private String userCommand;
	
	public GameContext(Robot robot, Board board){
		this.robot = robot;
		this.board = board;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public String getUserCommand() {
		return userCommand;
	}

	public void setUserCommand(String userCommand) {
		this.userCommand = userCommand;
	}
	
	
}
