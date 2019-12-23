package com.monirul.toyrobot.command;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.exception.ApplicationException;

public interface UserCommand {

	/**
	 * check validity of the game context
	 * @param gameContext
	 * @return
	 * @throws ApplicationException
	 */
	boolean isValid(GameContext gameContext) throws ApplicationException;

	/**
	 * excute command
	 * @param gameContext
	 * @throws ApplicationException
	 */
	void execute(GameContext gameContext) throws ApplicationException;
}
