package com.monirul.toyrobot.robot;

import static org.junit.Assert.*;

import com.monirul.toyrobot.simulation.Direction;
import com.monirul.toyrobot.simulation.Position;
import org.junit.Before;
import org.junit.Test;

import com.monirul.toyrobot.exception.ApplicationException;
import static org.mockito.Mockito.*;

public class SimpleRobotTest {

	private SimpleRobot robot;

	//private Bo

	@Before
	public void setup() throws ApplicationException{
		robot = new SimpleRobot();
	}
	
	@Test
	public void should_initializeSimpleRobot() {
		assertTrue(robot instanceof SimpleRobot);;
	}

	@Test(expected = ApplicationException.class)
	public void should_not_turn_when_not_placed_onBoard() throws ApplicationException {
		robot.turnRight();
	}


	
	

}
