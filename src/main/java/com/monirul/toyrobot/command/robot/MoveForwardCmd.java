package com.monirul.toyrobot.command.robot;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.simulation.Position;
import com.monirul.toyrobot.exception.ApplicationException;

public class MoveForwardCmd extends AbstractRobotCommand {


	/**
	 * check for valid move and move the robot 1 step forward
	 * @param gameContext
	 * @throws ApplicationException
	 */
	@Override
	public void execute(GameContext gameContext) throws ApplicationException {
		if(gameContext.getRobot().isPlaced()){
			Position newPosition = gameContext.getRobot().getCurrentPosition().getNextPosition(1);
			gameContext.getBoard().placeRobot(gameContext.getRobot(), newPosition);
		}
	}

	
}
