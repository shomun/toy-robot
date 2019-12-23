package com.monirul.toyrobot.board;

import com.monirul.toyrobot.simulation.Position;
import com.monirul.toyrobot.robot.Robot;
import com.monirul.toyrobot.exception.ApplicationException;

public abstract class AbstractBoard implements Board {

	protected int cols;
	protected int rows;

	public int getCols() {
		return cols;
	}

	public void setXCols(int cols) {
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	

	public boolean isValidPosition(Position position) throws ApplicationException {
		boolean isValid = !(position.getX() > this.cols || position.getX() < 0
				|| position.getY() > this.rows || position.getY() < 0
		);
		if(!isValid){
			throw new ApplicationException("Cannot MOVE, already at the Edge");
		}
		return isValid;
	}



	@Override
	public void placeRobot(Robot robot, Position newPosition) throws ApplicationException {
		if(this.isValidPosition(newPosition)){
			robot.setNewPosition(newPosition);
		}
		
	}
}
