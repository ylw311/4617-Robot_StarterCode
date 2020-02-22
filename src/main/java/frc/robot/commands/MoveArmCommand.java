/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveArmCommand extends Command
{
	public MoveArmCommand()
	{
		requires( Robot.arm );
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		double armSpeed = -Robot.m_oi.driveController.getTriggerAxis( Hand.kLeft )
				+ Robot.m_oi.driveController.getTriggerAxis( Hand.kRight );

		Robot.arm.setSpeed( armSpeed * 0.4 );
		// Robot.arm.setSpeed( -0.5 * ( Robot.m_oi.opController.getY( Hand.kLeft ) )
		// );// scaled down to 35%
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
		Robot.arm.setSpeed( 0.0 );
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		end();
	}
}
