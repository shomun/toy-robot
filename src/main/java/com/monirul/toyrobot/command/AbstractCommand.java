package com.monirul.toyrobot.command;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.exception.ApplicationException;

public abstract class AbstractCommand implements UserCommand {

	@Override
	public boolean isValid(GameContext gameContext) throws ApplicationException {
		return (gameContext.getRobot() !=null && gameContext.getBoard() != null);
	}

	
}
