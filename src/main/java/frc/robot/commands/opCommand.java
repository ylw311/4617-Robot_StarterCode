// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved. */
// /* Open Source Software - may be modified and shared by FRC teams. The code
// */
// /* must be accompanied by the FIRST BSD license file in the root directory of
// */
// /* the project. */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands;

// import edu.wpi.first.wpilibj.GenericHID.Hand;
// import edu.wpi.first.wpilibj.command.Command;
// import edu.wpi.first.wpilibj.interfaces.Potentiometer;
// import frc.robot.Robot;

// public class opCommand extends Command
// {
// public opCommand()
// {
// // Use requires() here to declare subsystem dependencies
// requires( Robot.arm );
// requires( Robot.claw );
// requires( Robot.wrist );
// }

// // Called just before this Command runs the first time
// @Override
// protected void initialize()
// {
// }

// // Called repeatedly when this Command is scheduled to run
// @Override
// protected void execute()
// {
// manipulatorMap();
// }

// private void manipulatorMap()
// {
// // controlSet determines which set of mapping we're using, 0 corresponds to
// the
// // left bumper button, 1 to the right bumper
// // The mapping stays the same until either bumper buttonn is pressed
// boolean controllerMap1 = Robot.m_oi.opController.getBumperReleased(
// Hand.kLeft );// first contorller mapping set
// boolean controllerMap2 = Robot.m_oi.opController.getBumperReleased(
// Hand.kRight );// second controller mapping set
// if ( controllerMap1 )
// {
// Robot.controlSet = 0;
// }
// if ( controllerMap2 )
// {
// Robot.controlSet = 1;
// }
// boolean BackButton = Robot.m_oi.opController.getBackButtonReleased();
// boolean XButton = Robot.m_oi.opController.getXButtonReleased();
// boolean AButton = Robot.m_oi.opController.getAButtonReleased();
// boolean BButton = Robot.m_oi.opController.getBButtonReleased();
// boolean YButton = Robot.m_oi.opController.getYButtonReleased();
// boolean StartButton = Robot.m_oi.opController.getStartButtonReleased();
// double armPosition = Robot.m_oi.opController.getY( Hand.kLeft );
// double wristPosition = Robot.m_oi.opController.getY( Hand.kRight );

// /*
// * The following is the meaning of the different position variables:
// H0W0C0:ARM
// * IS CLOSED, WRIST IS CLOSED, CLAW IS CLOSED H1W1C0:ARM IS IN SANDSTORM
// * POSITION, WRIST IS IN HATCH POSITION, CLAW IS CLOSED H1W1C1:ARM IS IN
// * SANDSTORM POSITION, WRIST IS IN HATCH POSITION, CLAW IS IN HATCH POSITION
// * H2W1C0:ARM IS AT LOW ROCKET/CARGO SHIP HATCH HEIGHT, WRIST IS IN HATCH
// * POSITION, CLAW IS CLOSED H2W1C1:ARM IS AT LOW ROCKET/CARGO SHIP HATCH
// HEIGHT,
// * WRIST IS IN HATCH POSITION, CLAW IS IN HATCH POSITION H3W1C0:ARM IS AT
// MIDDLE
// * ROCKET HATCH HEIGHT, WRIST IS IN HATCH POSITION, CLAW IS CLOSED H3W1C1:ARM
// IS
// * AT MIDDLE ROCKET HATCH HEIGHT, WRIST IS IN HATCH POSITION, CLAW IS IN HATCH
// * POSITION H3W1C2:ARM IS AT MIDDLE ROCKET HATCH HEIGHT, WRIST IS IN HATCH
// * POSITION, CLAW IS IN BALL POSITION H3W1C3:ARM IS AT MIDDLE ROCKET HATCH
// * HEIGHT, WRIST IS IN HATCH POSITION, CLAW IS IN OPEN POSITION H4W2C2:ARM IS
// AT
// * CARGO PICKUP HEIGHT, WRIST IS DOWN, CLAW IS IN BALL POSITION H4W2C3:ARM IS
// AT
// * CARGO PICKUP HEIGHT, WRIST IS DOWN, CLAW IS IN OPEN POSITION H5W0C0:ARM
// * WHEELIE POSITION, WRIST IS CLOSED, CLAW IS CLOSED
// */

// if ( Robot.controlSet == 0 )
// { // first value (index 0) is arm encoder value, second value (index 1) is
// wrist
// // encoder value, third value (index 2) is claw encoder value
// double[] H0W0C0 = { 250, 250, 250 };
// double[] H1W1C0 = { 250, 250, 250 };
// double[] H1W1C1 = { 250, 250, 250 };
// double[] H2W1C0 = { 250, 250, 250 };
// double[] H2W1C1 = { 250, 250, 250 };
// double[] H5W0C0 = { 250, 250, 250 };

// if ( Math.abs( wristPosition ) > 0 )
// {
// wristControl( 0, true );
// }

// else if ( Math.abs( armPosition ) > 0 )
// {
// armControl( 0, true );
// }

// else if ( BackButton )
// {
// armControl( H0W0C0[0], false );
// wristControl( H0W0C0[1], false );
// clawControl( H0W0C0[2] );
// }
// else if ( XButton )
// {
// armControl( H1W1C0[0], false );
// wristControl( H1W1C0[1], false );
// clawControl( H1W1C0[2] );
// }
// else if ( AButton )
// {
// armControl( H1W1C1[0], false );
// wristControl( H1W1C1[1], false );
// clawControl( H1W1C1[2] );
// }
// else if ( BButton )
// {
// armControl( H2W1C0[0], false );
// wristControl( H2W1C0[1], false );
// clawControl( H2W1C0[2] );
// }
// else if ( YButton )
// {
// armControl( H2W1C1[0], false );
// wristControl( H2W1C1[1], false );
// clawControl( H2W1C1[2] );
// }
// else if ( StartButton )
// {
// armControl( H5W0C0[0], false );
// wristControl( H5W0C0[1], false );
// clawControl( H5W0C0[2] );
// }
// }

// if ( Robot.controlSet == 1 )
// {
// double[] H3W1C0 = { 250, 250, 250 };
// double[] H3W1C1 = { 250, 250, 250 };
// double[] H3W1C2 = { 250, 250, 250 };
// double[] H3W1C3 = { 250, 250, 250 };
// double[] H4W2C2 = { 250, 250, 250 };
// double[] H4W2C3 = { 250, 250, 250 };

// if ( Math.abs( wristPosition ) > 0 )
// {
// wristControl( 0, true );
// }

// else if ( Math.abs( armPosition ) > 0 )
// {
// armControl( 0, true );
// }
// else if ( AButton )
// {
// armControl( H3W1C1[0], false );
// wristControl( H3W1C1[1], false );
// clawControl( H3W1C1[2] );
// }
// else if ( BButton )
// {
// armControl( H3W1C2[0], false );
// wristControl( H3W1C2[1], false );
// clawControl( H3W1C2[2] );
// }
// else if ( XButton )
// {
// armControl( H3W1C0[0], false );
// wristControl( H3W1C0[1], false );
// clawControl( H3W1C0[2] );
// }
// else if ( YButton )
// {
// armControl( H3W1C3[0], false );
// wristControl( H3W1C3[1], false );
// clawControl( H3W1C3[2] );
// }
// else if ( BackButton )
// {
// armControl( H4W2C2[0], false );
// wristControl( H4W2C2[1], false );
// clawControl( H4W2C2[2] );
// }
// else if ( StartButton )
// {
// armControl( H4W2C3[0], false );
// wristControl( H4W2C3[1], false );
// clawControl( H4W2C3[2] );
// }
// }
// }

// private void armControl( double encval, boolean Override )
// {
// double scalar = 0.25; // multiplier for the speed
// if ( Override )
// {
// double armPosition = Robot.m_oi.opController.getY( Hand.kLeft );
// Robot.arm.armControl( scalar * armPosition );
// }
// else if ( !Override )
// {
// double potval = Robot.arm.potentiometer1.get();
// if ( potval != encval )
// {
// Robot.arm.armControl( scalar );
// }
// else if ( potval == encval )
// {
// Robot.arm.armControl( 0 );
// }
// }
// // Robot.arm.armControl(scalar);
// }

// private void wristControl( double encval, boolean Override )
// {
// double scalar = 0.25;// chssnged from 0.25 to 0.5

// if ( Override )
// {
// double wristPosition = Robot.m_oi.opController.getY( Hand.kRight );
// Robot.wrist.wristControl( scalar * wristPosition );
// }
// else if ( !Override )
// {
// // double potval = Robot.wrist.potentiometer1.get();
// // if ( potval != encval )
// // {
// // Robot.wrist.wristControl( scalar );
// // }
// // else if ( potval == encval )
// // {
// // Robot.wrist.wristControl( 0 );
// // }
// }
// }

// private void clawControl( double encval )
// {
// // double scalar = 0.25;

// // double potval = Robot.claw.potentiometer1.get();

// // if ( potval != encval )
// // {
// // Robot.claw.clawControl( scalar );
// // }
// // else if ( potval == encval )
// // {
// // Robot.claw.clawControl( 0 );
// // }
// }

// // Make this return true when this Command no longer needs to run execute()
// @Override
// protected boolean isFinished()
// {
// return false;
// }

// // Called once after isFinished returns true
// @Override
// protected void end()
// {
// Robot.driveTrain.stop();
// }

// // Called when another command which requires one or more of the same
// // subsystems is scheduled to run
// @Override
// protected void interrupted()
// {
// end();
// }

// }
