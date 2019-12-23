package com.monirul.toyrobot.board;

import com.monirul.toyrobot.simulation.Position;
import com.monirul.toyrobot.robot.Robot;
import com.monirul.toyrobot.exception.ApplicationException;

public interface Board {

	/**
	 * Check whether a given Position is valid position in the Board.
	 * A Position is invalid if it falls outside of the edges
	 * @param position
	 * @return true if it is valid Position 
	 * @throws ApplicationException for Invalid Position
	 */
	boolean isValidPosition(Position position) throws ApplicationException;
	
	/**
	 * Place a Robot on the Board 
	 * @param robot 
	 * @param newPosition
	 * @throws ApplicationException
	 */
	void placeRobot(Robot robot, Position newPosition)throws ApplicationException;
	
}
