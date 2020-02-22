/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class ManipulatorPreset
{
	public double arm, wrist, claw;

	public ManipulatorPreset( double arm, double wrist, double claw )
	{
		this.arm = arm;
		this.wrist = wrist;
		this.claw = claw;
	}
}
