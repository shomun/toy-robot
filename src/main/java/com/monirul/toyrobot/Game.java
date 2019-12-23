package com.monirul.toyrobot;


import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.monirul.toyrobot.board.Board;
import com.monirul.toyrobot.command.CommandConfig;
import com.monirul.toyrobot.command.GameCommandConfig;
import com.monirul.toyrobot.command.CommandExecutor;
import com.monirul.toyrobot.command.UserCommand;
import com.monirul.toyrobot.robot.Robot;
import com.monirul.toyrobot.exception.ApplicationException;

public class Game {

	private Robot robot;
	private Board board;
	
	private GameContext gameContext;

	private CommandConfig gameCommandConfig;
	public Game(Robot robot, Board board) throws ApplicationException{
		this.board = board;
		this.robot = robot;
		gameContext = new GameContext(this.robot, this.board);
	}

	public CommandConfig getGameCommandConfig() {
		return gameCommandConfig;
	}

	public void setGameCommandConfig(CommandConfig gameCommandConfig) {
		this.gameCommandConfig = gameCommandConfig;
	}

	/**
	 * start playing game. Game instruction are given in file.each line can contain ';' delimated game commands
	 * eg. place2,2,NORTH;move;left;move;move;report;right
	 * if file name is not provided game starts in manual mode. 
	 * @param fileName
	 * @throws ApplicationException
	 */
	public void play(String fileName) throws ApplicationException{
		if(fileName != null){
			this.playFromFile(fileName);
		}else{
			this.playFromConsole();
		}
	}
	
	/**
	 * start playing the game in manual mode.
	 * @throws ApplicationException
	 */
	public void play() throws ApplicationException{
		this.play(null);
	}
	
	
	/**
	 * read instructions from a file. each line can contain ';' delimited game commands
	 * eg. place2,2,NORTH;move;left;move;move;report;right
	 * @param fileName
	 * @throws ApplicationException
	 */
	private void playFromFile(String fileName) throws ApplicationException{
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = null;
			line = reader.readLine();
			do{
				
				System.out.println("Input from file : "+ line);
				this.simulate(line);
				line = reader.readLine();
			}while(line != null);
		} catch (FileNotFoundException e) {
			throw new ApplicationException("Input file not found");
		} catch (IOException e) {
			throw new ApplicationException("Input file access problem");
		}
		
		
		
		
	}
	
	/**
	 * start the console to play game manually
	 */
	private void playFromConsole(){
		Scanner scanIn = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter a Command, Valid Commands are: ");
		System.out.println("'PLACE X,Y,NORTH|WEST|SOUTH|EAST ', MOVE, LEFT, RIGHT, REPORT or EXIT");
		boolean keepRunning = true;
		while(keepRunning){
			String inputString = scanIn.nextLine().trim();
			this.simulate(inputString);
		}
	}
	
	/**
	 * Do game Simulation
	 * @param inputString
	 * @return
	 */
	private void simulate(String inputString){
		String[] inputCmd = inputString.split(";");
			UserCommand userCommand = null;
			for (String input : inputCmd) {
				input = input.trim().toUpperCase();
				String userCmd[] = input.split(" ");
				
				try {
					userCommand = gameCommandConfig.getCommand(userCmd[0]);
					gameContext.setUserCommand(input);
					CommandExecutor.INSTANCE.executeCommand(userCommand, gameContext);
				} catch (ApplicationException e) {
					System.out.println(e.getMessage());
				}
			}	

	}


	public Robot getRobot() {
		return robot;
	}


	public void setRobot(Robot robot) {
		this.robot = robot;
	}


	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}
	
	
}
