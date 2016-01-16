package com.builder.pattern.robot.engineer;

import com.builder.pattern.robot.builder.RobotBuilder;
import com.builder.pattern.robot.model.Robot;

/**
 * This class deals with creating a robot instance with the help of the robot
 * builder instance passed to it.
 */
public class RobotEngineer {

	private RobotBuilder robotBuilder;

	public RobotEngineer(RobotBuilder robotBuilder) {
		this.robotBuilder = robotBuilder;
	}

	/**
	 * This method is used to build a robot by calling the corresponding robot
	 * builder's build methods.
	 */
	public void buildRobot() {
		this.robotBuilder.buildRobotHead();
		this.robotBuilder.buildRobotArms();
		this.robotBuilder.buildRobotTorso();
		this.robotBuilder.buildRobotLegs();
	}

	/**
	 * This method prints the robot description of the created robot instance.
	 */
	public void printRobotDescription() {
		this.robotBuilder.printRobotDescription();
	}

	/**
	 * This method returns the built robot instance.
	 * 
	 * @return Robot robot instance.
	 */
	public Robot getRobot() {
		return this.robotBuilder.getRobot();
	}
}
