/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

public class MovePIDCommand extends Command
{
	PIDSubsystem subsystem;

	double startAngle;
	double targetAngle;
	double currentAngle;
	double speed = 100;
	double speedarm = 100;
	boolean onTarget;
	double slowrangelow = 0;// value for slow range lower threshold
	double slowrangehigh = 100;// value for slow range higher threshold
	double clawspClosed = 0;// preset for claw if closed
	double clawspHatch = 1;// preset for claw if hatch position
	double clawspBall = 2;// preset for claw if ball holding position
	double clawspOpen = 3;// preset for claw if open to grab ball position

	public MovePIDCommand( PIDSubsystem subsystem, double target )
	{
		this.subsystem = subsystem;
		this.targetAngle = target;

		requires( subsystem );
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		startAngle = subsystem.getPosition();
		currentAngle = startAngle;
		onTarget = false;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		currentAngle = subsystem.getPosition();

		// checks if current encoder preset for claw is equal to certain preset and
		// change talon position accordingly
		// range for set is 0-1 (both extremes) the servos are 0-180 degree range
		if ( subsystem == Robot.claw )
		{
			if ( targetAngle == clawspClosed /* || true */ ) // rahmedit removed || true at end
			{
				Robot.claw.claw1.set( 0 );
				Robot.claw.claw2.set( 0 );
				Robot.claw.claw3.set( 0 );
			}
			if ( targetAngle == clawspHatch )
			{
				Robot.claw.claw1.set( 1 );
				Robot.claw.claw2.set( 1 );
				Robot.claw.claw3.set( 1 );
			}
			if ( targetAngle == clawspBall )
			{
				Robot.claw.claw1.set( 0.8 );
				Robot.claw.claw2.set( 1 );
				Robot.claw.claw3.set( 1 );
			}
			if ( targetAngle == clawspOpen )
			{
				Robot.claw.claw1.set( 0.3 );
				Robot.claw.claw2.set( 0.5 );
				Robot.claw.claw3.set( 0.5 );
			}
		}
		// rahma cmmented below out because it was being weird

		// // calculates the difference between the startSetpoint and targetSetpoint.
		// // If startAngle < targetAngle, set speed as positive (keep going in this
		// // direction)
		// // else, set speed as negative (reverse direction)
		// double delta;
		// delta = ( startAngle < targetAngle ) ? speed : -speed;

		// // Checks to see if subsystem is arm then checks to see if current value is
		// in
		// // slow speed range
		// // and adjusts speed by factor of 1/3
		// if ( subsystem == Robot.arm )
		// {
		// speedarm = ( currentAngle >= slowrangelow && currentAngle <= slowrangehigh )
		// ? speed / 3 : speed;
		// delta = ( startAngle < targetAngle ) ? speedarm : -speedarm;
		// }

		// // Tells the program when the setpoint has been achieved.
		// // if startAngle < targetAngle, set onTarget to be true (end program) when
		// the
		// // angle
		// // is greater than or equal to the target
		// // else (if startAngle > targetAngle) set onTarget to be true when the angle
		// is
		// // smaller than or equal to target
		// onTarget = ( startAngle < targetAngle ) ? currentAngle >= targetAngle :
		// currentAngle <= targetAngle;

		// // if not yet onTarget, set the next setpoint/angle to be the currentAngle +
		// // delta
		// // else, set the next setpoint to be the targetAngle (in case it overshoots)
		// if ( !onTarget )
		// currentAngle += delta;
		// else
		// currentAngle = targetAngle;

		// // set the next location to move the arm motor such that the motion is
		// // continuous
		// subsystem.setSetpoint( currentAngle );
		subsystem.enable();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return subsystem.onTarget() && onTarget;
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
	}
}