// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved. */
// /* Open Source Software - may be modified and shared by FRC teams. The code
// */
// /* must be accompanied by the FIRST BSD license file in the root directory of
// */
// /* the project. */
// /*----------------------------------------------------------------------------*/

// package frc.robot.subsystems;

// //import edu.wpi.first.wpilibj.AnalogInput;
// import edu.wpi.first.wpilibj.AnalogPotentiometer;
// import edu.wpi.first.wpilibj.Talon;
// import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.interfaces.Potentiometer;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.RobotMap;
// import frc.robot.commands.opCommand;

// public class Arm extends Subsystem
// {
// public Talon motor1;
// public Talon motor2;
// // public AnalogInput armenca;
// // public AnalogInput armencb;
// public AnalogPotentiometer potentiometer1;
// public AnalogPotentiometer potentiometer2;

// public Arm()
// {
// motor1 = new Talon( RobotMap.ARM1 );
// motor2 = new Talon( RobotMap.ARM2 );
// // armenca = new AnalogInput(RobotMap.ARMENC[0]);
// // armencb = new AnalogInput(RobotMap.ARMENC[1]);
// potentiometer1 = new AnalogPotentiometer( RobotMap.ARM_POTENTIOMETER[0], 345,
// 0 );
// potentiometer2 = new AnalogPotentiometer( RobotMap.ARM_POTENTIOMETER[1], 345,
// 0 );

// // SmartDashboard.putNumber("Potentiometer", potentiometer2.get());

// }

// @Override
// public void initDefaultCommand()
// {
// // Set the default command for a subsystem here.
// // setDefaultCommand(new MySpecialCommand());
// setDefaultCommand( new opCommand() );
// }

// public void armControl( double speed )
// {
// double scalar = 1;
// double turnPointLow = 161;
// double turnPointHigh = 244;
// if ( turnPointLow < potentiometer2.get() && potentiometer2.get() <
// turnPointHigh )
// {
// scalar = 0.5;
// }
// motor1.setSpeed( scalar * speed );
// motor2.setSpeed( scalar * speed );
// SmartDashboard.putBoolean( "Slow Mode",
// turnPointLow < potentiometer2.get() && potentiometer2.get() < turnPointHigh
// );
// SmartDashboard.putNumber( "Potentiometer", potentiometer2.get() );
// }
// }
