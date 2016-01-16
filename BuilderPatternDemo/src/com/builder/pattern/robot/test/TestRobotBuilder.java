package com.builder.pattern.robot.test;

import com.builder.pattern.robot.builder.RobotBuilder;
import com.builder.pattern.robot.builder.impl.ModernRobotBuilder;
import com.builder.pattern.robot.builder.impl.OldRobotBuilder;
import com.builder.pattern.robot.engineer.RobotEngineer;

public class TestRobotBuilder {
	
	public static void main(String[] args) {

		RobotBuilder robotBuilder = new OldRobotBuilder();
		RobotEngineer robotEngineer = new RobotEngineer(robotBuilder);
		robotEngineer.buildRobot();
		robotBuilder.printRobotDescription();

		robotBuilder = new ModernRobotBuilder();
		robotEngineer = new RobotEngineer(robotBuilder);
		robotEngineer.buildRobot();
		robotEngineer.printRobotDescription();
	}
}
