package com.monirul.toyrobot.command.game;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.command.AbstractCommand;
import com.monirul.toyrobot.exception.ApplicationException;

public class ReportCmd extends AbstractCommand {

	/**
	 * print the report to console
	 * @param gameContext
	 * @throws ApplicationException
	 */
	@Override
	public void execute(GameContext gameContext) throws ApplicationException {
		System.out.println(gameContext.getRobot().getCurrentPosition());
	}

}
