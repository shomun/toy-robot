package com.monirul.toyrobot.command.game;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.command.AbstractCommand;
import com.monirul.toyrobot.exception.ApplicationException;

public class ExitCmd extends AbstractCommand {

	/**
	 * exit from the game
	 * @param gameContext
	 * @throws ApplicationException
	 */
	@Override
	public void execute(GameContext gameContext) throws ApplicationException {
		System.exit(1);
	}

}
