package com.monirul.toyrobot;


import com.monirul.toyrobot.board.Board;
import com.monirul.toyrobot.board.SquareBoard;
import com.monirul.toyrobot.command.GameCommandConfig;
import com.monirul.toyrobot.robot.Robot;
import com.monirul.toyrobot.robot.SimpleRobot;
import com.monirul.toyrobot.exception.ApplicationException;

public class AppMain {

	public static void main(String[] args) {
		try{
			Board board = new SquareBoard(5);
			Robot robot = new SimpleRobot();
			
			Game game = new Game(robot, board);

			game.setGameCommandConfig(GameCommandConfig.INSTANCE);
			game.play();
			
		}catch(ApplicationException e){
			System.out.println(e.getMessage());
		}
	}
}
