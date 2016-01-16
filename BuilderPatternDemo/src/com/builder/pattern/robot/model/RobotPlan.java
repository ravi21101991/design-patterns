package com.builder.pattern.robot.model;

/**
 * Public interface that defines the contract that a robot should fulfill in
 * order to be a robot.
 */
public interface RobotPlan {

	/**
	 * Sets a robot head to the passed head value.
	 * 
	 * @param head
	 *            String value representing robot head.
	 */
	void setRobotHead(String head);

	/**
	 * Sets a robot head to the passed torso value.
	 * 
	 * @param head
	 *            String value representing robot torso.
	 */
	void setRobotTorso(String torso);

	/**
	 * Sets a robot head to the passed arm value.
	 * 
	 * @param head
	 *            String value representing robot arms.
	 */
	void setRobotArms(String arms);

	/**
	 * Sets a robot head to the passed leg value.
	 * 
	 * @param head
	 *            String value representing robot legs.
	 */
	void setRobotLegs(String legs);
}
