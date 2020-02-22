/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	// public static int[] LEFT_MOTORS = new int[]{0};
	// public static int[] LEFT_MOTORS = new int[]{2};
	// public static int[] LEFT_MOTORS = new int[] { 6, 7 };
	public static int[] LEFT_MOTORS = new int[] { 0 };
	public static int[] RIGHT_MOTORS = new int[] { 1 };

	public static int[] ARM_MOTORS = new int[] { 2, 3 };

	public static int WRIST = 4;// changed from 4 to 5 for test temporary
	public static int CLAW = 5;
	public static int[] SERVO = new int[] { 6, 7, 8 };

	public static int DRIVER_CONTROLLER_PORT = 0;
	public static int OP_CONTROLLER_PORT = 1;

	// public static int[] ARMENC = new int[]{0,1};
	public static int[] ARM_POTENTIOMETER = new int[] { 0, 1 };
	public static int[] WRIST_ENCODER = new int[] { 0, 1 };
	public static int[] CLAW_ENCODER = new int[] { 2, 3 };
	public static int LIMSW_WRIST = 4;
	public static int LIMSW_CLAW = 5;

}
