package com.monirul.toyrobot.simulation;

public enum Direction {

	NORTH(1), EAST(2), SOUTH(3), WEST(4);
	
	private int direction;
	
	private Direction(int direction){
		this.direction = direction;
	}
	
	public Direction rotateLeft(){
		return this.rotate(-1);
	}
	public Direction rotateRight(){
		return this.rotate(1);
	}
	
	private Direction rotate(int side){
		Direction dir = Direction.getDirectionByValue(this.direction);
		int newDirection = this.direction + (side);
		if(newDirection < 1){
			dir = Direction.WEST;
		}else if(newDirection > 4){
			dir = Direction.NORTH;
		}else{
			dir = Direction.getDirectionByValue(newDirection);
		}
		return dir;
	}
	
	public static Direction getDirectionByValue(int direction){
		Direction dir = null;
		switch (direction) {
		case 1:
			dir = Direction.NORTH;
			break;
		case 2:
			dir = Direction.EAST;
			break;	
		case 3:
			dir = Direction.SOUTH;
			break;
		case 4:
			dir = Direction.WEST;
			break;	
		}
		return dir;
	}
	
}
