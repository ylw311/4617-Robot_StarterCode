/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem
{
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public DifferentialDrive drive;

	public DriveTrain()
	{
		SpeedControllerGroup leftMotors = new SpeedControllerGroup( new Talon( RobotMap.LEFT_MOTORS[0] ) );
		// SpeedControllerGroup leftMotors = new SpeedControllerGroup( new Talon(
		// RobotMap.LEFT_MOTORS[0] ),
		// new Talon( RobotMap.LEFT_MOTORS[1] ) );
		SpeedControllerGroup rightMotors = new SpeedControllerGroup( new Talon( RobotMap.RIGHT_MOTORS[0] ) );
		drive = new DifferentialDrive( leftMotors, rightMotors );// test
	}

	@Override
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		setDefaultCommand( new DriveCommand() );
	}

	public void curvatureDrive( double xSpeed, double zRotation, boolean isQuickTurn )
	{
		drive.curvatureDrive( xSpeed, zRotation, isQuickTurn );
	}

	public void arcadeDrive( double xSpeed, double zRotation )
	{
		drive.arcadeDrive( xSpeed, zRotation );
	}

	public void stop()
	{
		drive.stopMotor();
	}
}
