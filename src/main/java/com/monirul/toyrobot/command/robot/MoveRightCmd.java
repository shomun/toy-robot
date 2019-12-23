package com.monirul.toyrobot.command.robot;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.exception.ApplicationException;

public class MoveRightCmd extends AbstractRobotCommand {


	/**
	 * turn the robot towards right
	 * @param gameContext
	 * @throws ApplicationException
	 */
	@Override
	public void execute(GameContext gameContext) throws ApplicationException {
		gameContext.getRobot().turnRight();
	}


}
