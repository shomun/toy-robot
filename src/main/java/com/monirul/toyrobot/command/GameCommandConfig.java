package com.monirul.toyrobot.command;

import java.util.HashMap;
import java.util.Map;

import com.monirul.toyrobot.command.board.BoardPlaceCmd;
import com.monirul.toyrobot.command.game.ExitCmd;
import com.monirul.toyrobot.command.game.ReportCmd;
import com.monirul.toyrobot.command.robot.MoveForwardCmd;
import com.monirul.toyrobot.command.robot.MoveLeftCmd;
import com.monirul.toyrobot.command.robot.MoveRightCmd;
import com.monirul.toyrobot.exception.ApplicationException;

public enum GameCommandConfig implements CommandConfig{
	
	INSTANCE;
		
	private Map<String, UserCommand> commands= new HashMap<>();
	
	private GameCommandConfig(){
		this.populate();
	}
	
	private void populate(){
		this.commands.put("EXIT", new ExitCmd());
		this.commands.put("REPORT", new ReportCmd());
		this.commands.put("PLACE", new BoardPlaceCmd());
		this.commands.put("RIGHT", new MoveRightCmd());
		this.commands.put("LEFT", new MoveLeftCmd());
		this.commands.put("MOVE", new MoveForwardCmd());
	}
	
	public UserCommand getCommand(String command)throws ApplicationException{
		String key = command.trim().toUpperCase();
		if(this.commands.containsKey(key)){
			return this.commands.get(key);
		}else{
			throw new ApplicationException("Command not supported");
		}
		
	}
}
