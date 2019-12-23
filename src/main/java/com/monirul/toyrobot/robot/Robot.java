package com.monirul.toyrobot.robot;

import com.monirul.toyrobot.simulation.Position;
import com.monirul.toyrobot.exception.ApplicationException;

public interface Robot {
	/**
	 * Rotate Robot to Right by 45 degree i.e if the Robot is facing North, it will turn to East.
	 * @throws ApplicationException if Robot is not placed on Board
	 */
	void turnRight() throws ApplicationException;

	/**
	 * Rotate Robot to Left by 45 degree i.e if the Robot is facing North, it will turn to West.
	 * @throws ApplicationException if Robot is not placed on Board
	 */
	void turnLeft() throws ApplicationException;
	
	/**
	 * Set new position 
	 * @param newPosition
	 */
	void setNewPosition(Position newPosition);
	
	/**
	 * Get Current Position
	 * @return
	 */
	Position getCurrentPosition() throws ApplicationException;
	
	/**
	 * Check whether the Robot is placed already on the board
	 * @return
	 * @throws ApplicationException if Robot is not placed on Board
	 */
	boolean isPlaced() throws ApplicationException;

}
