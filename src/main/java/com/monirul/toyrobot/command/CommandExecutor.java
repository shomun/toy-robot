package com.monirul.toyrobot.command;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.exception.ApplicationException;

public enum CommandExecutor {

	INSTANCE;

	/**
	 * execute game command
	 * @param userCommand
	 * @param gameContext
	 * @throws ApplicationException
	 */
	public void executeCommand(UserCommand userCommand, GameContext gameContext) throws ApplicationException{
		if(userCommand.isValid(gameContext)){
			userCommand.execute(gameContext);
		}else{
			throw new ApplicationException("Command Not Supported");
		}
	}
}
