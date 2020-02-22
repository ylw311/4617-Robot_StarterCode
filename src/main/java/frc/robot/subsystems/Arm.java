/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveArmCommand;

public class Arm extends PIDSubsystem
{
	static final double kP = 0.05;
	static final double kI = 0.0;
	static final double kD = 0.03;

	public Talon[] motors;

	AnalogPotentiometer potentiometer;

	public Arm()
	{
		super( kP, kI, kD );

		motors = new Talon[RobotMap.ARM_MOTORS.length];
		for ( int i = 0; i < motors.length; i++ )
		{
			motors[i] = new Talon( RobotMap.ARM_MOTORS[i] );
		}

		potentiometer = new AnalogPotentiometer( RobotMap.ARM_POTENTIOMETER[0], 3600, 0 );

		potentiometer.setPIDSourceType( PIDSourceType.kDisplacement );

		setAbsoluteTolerance( 0.1 );
		getPIDController().setContinuous( false );
		getPIDController().setInputRange( 0.0, 3600.0 );
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand( new MoveArmCommand() );
	}

	@Override
	protected double returnPIDInput()
	{
		return potentiometer.get();
	}

	@Override
	protected void usePIDOutput( double output )
	{
		setSpeed( output );
	}

	public void setSpeed( double speed )
	{
		for ( int i = 0; i < motors.length; i++ )
			motors[i].set( speed );
	}
}