/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.ManipulatorPreset;
import frc.robot.Robot;

public class RunManipulatorCommand extends CommandGroup
{
	public RunManipulatorCommand( ManipulatorPreset preset )
	{
		addSequential( new MovePIDCommand( Robot.claw, preset.claw ) );
		addSequential( new MovePIDCommand( Robot.wrist, preset.wrist ) );
		addSequential( new MovePIDCommand( Robot.arm, preset.arm ) );
	}
}
