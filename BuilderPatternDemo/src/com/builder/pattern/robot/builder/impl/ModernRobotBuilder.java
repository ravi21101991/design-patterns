package com.builder.pattern.robot.builder.impl;

import com.builder.pattern.robot.builder.RobotBuilder;
import com.builder.pattern.robot.model.Robot;

/**
 * This class deals with creating modern era robot.
 */
public class ModernRobotBuilder extends RobotBuilder {
	private Robot robot;

	public ModernRobotBuilder() {
		this.robot = new Robot();
	}

	@Override
	public void buildRobotHead() {
		this.robot.setRobotHead("LED display head");
	}

	@Override
	public void buildRobotTorso() {
		this.robot.setRobotTorso("metal torso");
	}

	@Override
	public void buildRobotArms() {
		this.robot.setRobotArms("swiss knife arms");
	}

	@Override
	public void buildRobotLegs() {
		this.robot.setRobotLegs("michellin tyre legs");
	}

	@Override
	public Robot getRobot() {
		return this.robot;
	}
}
