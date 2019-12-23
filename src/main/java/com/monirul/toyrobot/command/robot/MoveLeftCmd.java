package com.monirul.toyrobot.command.robot;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.exception.ApplicationException;

public class MoveLeftCmd extends AbstractRobotCommand {

	/**
	 * Turn the robot towards left
	 * @param gameContext
	 * @throws ApplicationException
	 */
	@Override
	public void execute(GameContext gameContext) throws ApplicationException {
		gameContext.getRobot().turnLeft();
	}

	
}
