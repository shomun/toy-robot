package com.monirul.toyrobot.robot;

import com.monirul.toyrobot.simulation.Direction;
import com.monirul.toyrobot.simulation.Position;
import com.monirul.toyrobot.exception.ApplicationException;

public abstract class AbstractRobot implements Robot {

	protected  Position currentPosition;



	@Override
	public void turnRight() throws ApplicationException {
		if(this.isPlaced()){
			Direction newDirection =  this.currentPosition.getDirection().rotateRight();
			this.currentPosition.setDirection(newDirection);
		}
	}

	@Override
	public void turnLeft() throws ApplicationException {
		if(this.isPlaced()){
			Direction newDirection = this.currentPosition.getDirection().rotateLeft();
			this.currentPosition.setDirection(newDirection);
		}
	}
	
	/**
	 * check whether Robot has been placed on board or not
	 * @return
	 * @throws ApplicationException
	 */
	public boolean isPlaced() throws ApplicationException{
		if(this.currentPosition == null){
			throw new ApplicationException("ROBOT is required to be placed on the Board first.");
		}
		return true;
	}

	@Override
	public void setNewPosition(Position newPosition) {
		this.currentPosition = newPosition;
	}

	@Override
	public Position getCurrentPosition() throws ApplicationException{
		this.isPlaced();
		return this.currentPosition;
	}


}
