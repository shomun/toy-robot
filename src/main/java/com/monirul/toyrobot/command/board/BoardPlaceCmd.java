package com.monirul.toyrobot.command.board;

import com.monirul.toyrobot.GameContext;
import com.monirul.toyrobot.command.AbstractCommand;
import com.monirul.toyrobot.simulation.Direction;
import com.monirul.toyrobot.simulation.Position;
import com.monirul.toyrobot.exception.ApplicationException;

public class BoardPlaceCmd extends AbstractCommand {
	
	private final String INVALID_MSG = "Invalid PLACE command";

	/**
	 * Place the robot on board
	 * @param gameContext
	 * @throws ApplicationException
	 */
	@Override
	public void execute(GameContext gameContext) throws ApplicationException {
		String[] userCmd = gameContext.getUserCommand().split(" ");
		if(userCmd.length < 2){
			throw new ApplicationException(INVALID_MSG);
		}
		String[] params = userCmd[1].split(",");
		try{
				int x = Integer.parseInt(params[0]);
				int y = Integer.parseInt(params[1]);
				Direction direction = Direction.valueOf(params[2]);
				Position position = new Position(x, y, direction);
				gameContext.getBoard().placeRobot(gameContext.getRobot(), position);
				
		}catch(Exception e){
			throw new ApplicationException(INVALID_MSG);
		}

	}

}
