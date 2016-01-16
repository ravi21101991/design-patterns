package com.builder.pattern.robot.builder;

import com.builder.pattern.robot.model.Robot;

/**
 * This abstract class defines a contract that the implementing classes should
 * adhere to, to create a Robot instance.
 */
public abstract class RobotBuilder {

	public abstract void buildRobotHead();

	public abstract void buildRobotTorso();

	public abstract void buildRobotArms();

	public abstract void buildRobotLegs();

	public abstract Robot getRobot();

	public void printRobotDescription() {
		
		System.out.println("****Printing the robot description****");
		System.out.println("Robot head : " + getRobot().getRobotHead());
		System.out.println("Robot torso: " + getRobot().getRobotTorso());
		System.out.println("Robot arms : " + getRobot().getRobotArms());
		System.out.println("Robot legs : " + getRobot().getRobotLegs());
	}
}
