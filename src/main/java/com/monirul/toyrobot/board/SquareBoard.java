package com.monirul.toyrobot.board;

import com.monirul.toyrobot.exception.ApplicationException;

public class SquareBoard extends AbstractBoard{

	public SquareBoard(int size) throws ApplicationException {
		if(size <= 0){
			throw new ApplicationException("Board size cannot be negative or Zero.");
		}else{
			this.cols = this.rows = size;
		}
	}

}
