/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.utils.XboxButton;
import frc.robot.utils.XboxControllerButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	public XboxController driveController = new XboxController( RobotMap.DRIVER_CONTROLLER_PORT );
	public XboxController opController = new XboxController( RobotMap.OP_CONTROLLER_PORT );

	public OI()
	{
		// Bumpers
		XboxControllerButton op_BumperLeft = new XboxControllerButton( opController, XboxButton.kBumperLeft );
		op_BumperLeft.whenPressed( new ChangeControlSetCommand( 0 ) );

		XboxControllerButton op_BumperRight = new XboxControllerButton( opController, XboxButton.kBumperRight );
		op_BumperRight.whenPressed( new ChangeControlSetCommand( 1 ) );

		// Thumbsticks
		XboxControllerButton op_StickLeft = new XboxControllerButton( opController, XboxButton.kStickLeft );
		op_StickLeft.whenPressed( new DisablePIDCommand( Robot.arm ) );

		XboxControllerButton op_StickRight = new XboxControllerButton( opController, XboxButton.kStickRight );
		op_StickRight.whenPressed( new DisablePIDCommand( Robot.wrist ) );

		// Buttons
		// make sure to change claw presets in movepidcommand too
		XboxControllerButton op_ButtonA = new XboxControllerButton( opController, XboxButton.kButtonA ); // ball
		op_ButtonA.whenPressed(
				new MoveManipulatorCommand( new ManipulatorPreset( 255, 255, 2 ), new ManipulatorPreset( 255, 255, 2 ) ) );

		XboxControllerButton op_ButtonB = new XboxControllerButton( opController, XboxButton.kButtonB ); // open
		op_ButtonB.whenPressed(
				new MoveManipulatorCommand( new ManipulatorPreset( 255, 255, 3 ), new ManipulatorPreset( 255, 255, 3 ) ) );

		XboxControllerButton op_ButtonX = new XboxControllerButton( opController, XboxButton.kButtonX );
		op_ButtonX.whenPressed( new MoveManipulatorCommand( new ManipulatorPreset( 255, 255, 255 ),
				new ManipulatorPreset( 255, 255, 255 ) ) );

		XboxControllerButton op_ButtonY = new XboxControllerButton( opController, XboxButton.kButtonY );
		op_ButtonY.whenPressed( new MoveManipulatorCommand( new ManipulatorPreset( 255, 255, 255 ),
				new ManipulatorPreset( 255, 255, 255 ) ) );
	}
}
