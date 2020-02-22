/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command
{
	public DriveCommand()
	{
		// Use requires() here to declare subsystem dependencies
		requires( Robot.driveTrain );
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
		curvatureDrive();
		// arcadeDrive();
	}

	private void curvatureDrive()
	{
		double scalar = 0.25; // multiplier for the speed
		// boolean slowSpeed = Robot.m_oi.driveController.getXButtonReleased();
		// if (slowSpeed) //check to see if slowspeed mode button (x) pushed and toggle
		// between slow and fast
		// {
		// if (scalar == 1)
		// {scalar =0.5;}
		// else {scalar=1;}
		// }
		// rahma edit added scalar for drive speed 0.25 to slow down
		double speed = /* 0.25 * */ Robot.m_oi.driveController.getY( Hand.kLeft );
		double turnSpeed = /* 0.25 * */ Robot.m_oi.driveController.getX( Hand.kRight );
		boolean slow = Robot.m_oi.driveController.getBumper( Hand.kRight );
		boolean quickTurn = false;
		if ( Math.abs( speed ) < 0.3 )
		{
			quickTurn = true;
		}
		if ( slow )
		{
			// not working???
			System.out.println( "Pressed bumper" );
			scalar = 1;
		}
		// else
		// {
		// System.out.println("Not Pressed bumper");
		// }
		speed = speed * scalar * -1;
		turnSpeed = turnSpeed * scalar;
		Robot.driveTrain.curvatureDrive( speed, turnSpeed, quickTurn );
	}

	private void arcadeDrive()
	{
		double speed = Robot.m_oi.driveController.getY( Hand.kLeft );
		double turnSpeed = Robot.m_oi.driveController.getX( Hand.kLeft );
		Robot.driveTrain.arcadeDrive( speed, turnSpeed );
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
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		end();
	}
}
