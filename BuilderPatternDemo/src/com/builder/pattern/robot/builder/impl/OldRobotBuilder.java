package com.builder.pattern.robot.builder.impl;

import com.builder.pattern.robot.builder.RobotBuilder;
import com.builder.pattern.robot.model.Robot;

/**
 * This class deals with creating an older model of an robot.
 */
public class OldRobotBuilder extends RobotBuilder {

	private Robot robot;

	public OldRobotBuilder() {
		this.robot = new Robot();
	}

	@Override
	public void buildRobotHead() {
		this.robot.setRobotHead("tin robot head");
	}

	@Override
	public void buildRobotTorso() {
		this.robot.setRobotTorso("tin torso");
	}

	@Override
	public void buildRobotArms() {
		this.robot.setRobotArms("blowtorch arms");
	}

	@Override
	public void buildRobotLegs() {
		this.robot.setRobotLegs("skater legs");
	}

	@Override
	public Robot getRobot() {
		return this.robot;
	}
}
