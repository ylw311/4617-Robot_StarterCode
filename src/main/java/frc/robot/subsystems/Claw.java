/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

public class Claw extends PIDSubsystem
{
	static final double kP = 0.05;
	static final double kI = 0.0;
	static final double kD = 0.03;

	public Talon motor;
	public Servo claw1;
	public Servo claw2;
	public Servo claw3;

	Encoder encoder;

	public Claw()
	{
		super( kP, kI, kD );

		motor = new Talon( RobotMap.CLAW );

		claw1 = new Servo( RobotMap.SERVO[0] );
		claw2 = new Servo( RobotMap.SERVO[1] );
		claw3 = new Servo( RobotMap.SERVO[2] );

		encoder = new Encoder( RobotMap.CLAW_ENCODER[0], RobotMap.CLAW_ENCODER[1], false, EncodingType.k4X );
		encoder.setName( this.getName(), "Encoder" );
		encoder.setPIDSourceType( PIDSourceType.kDisplacement );
		encoder.setMaxPeriod( 0.2 );
		// encoder.setMinRate(10);
		encoder.setDistancePerPulse( 0.045 );
		encoder.setSamplesToAverage( 7 );
		encoder.reset();

		setAbsoluteTolerance( 0.1 );
		getPIDController().setContinuous( false );
		getPIDController().setInputRange( 0.0, 3600.0 );
	}

	@Override
	protected void initDefaultCommand()
	{
		// setDefaultCommand( new opCommand() );
	}

	@Override
	protected double returnPIDInput()
	{
		return encoder.get();
	}

	@Override
	protected void usePIDOutput( double output )
	{
		motor.set( output );
	}
}