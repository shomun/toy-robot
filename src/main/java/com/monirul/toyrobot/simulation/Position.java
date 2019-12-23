package com.monirul.toyrobot.simulation;

import com.monirul.toyrobot.exception.ApplicationException;

public class Position {

	private int x;
	private int y;
	private Direction direction;
	
	public Position(int x,int y, Direction direction)throws ApplicationException{
		if(direction == null || x < 0 || y < 0){
			throw new ApplicationException("Direction cannot be NULL");
		}
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Position getNextPosition(int distance) throws ApplicationException{
		Position newPosition = new Position(this.x, this.y, this.direction);
		switch (this.direction) {
		case NORTH:
			newPosition.change(0,distance);
			break;
		case EAST:
			newPosition.change(distance,0);
			break;
		case SOUTH:
			newPosition.change(0,-distance);
			break;
		case WEST:
			newPosition.change(-distance,0);
			break;	
		}
		return newPosition;
	}
	
	public void change(int x,int y){
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public String toString(){
		return this.x +","+ this.y +","+ this.direction.toString();
	}
}
