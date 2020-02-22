/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.ConditionalCommand;
import frc.robot.ManipulatorPreset;
import frc.robot.Robot;

public class MoveManipulatorCommand extends CommandGroup
{
	ManipulatorPreset mapA, mapB;

	public MoveManipulatorCommand( ManipulatorPreset mapA, ManipulatorPreset mapB )
	{
		// this.mapA = mapA;
		// this.mapB = mapB;

		// if ( Robot.controlSet == 0 )
		// {
		// addSequential( new MovePIDCommand( Robot.claw, mapA.claw ) );
		// addSequential( new MovePIDCommand( Robot.wrist, mapA.wrist ) );
		// addSequential( new MovePIDCommand( Robot.arm, mapA.arm ) );
		// }
		// else if ( Robot.controlSet == 1 )
		// {
		// addSequential( new MovePIDCommand( Robot.claw, mapB.claw ) );
		// addSequential( new MovePIDCommand( Robot.wrist, mapB.wrist ) );
		// addSequential( new MovePIDCommand( Robot.arm, mapB.arm ) );
	}

	@Override
	public synchronized void start()
	{
		if ( Robot.controlSet == 0 )
			new RunManipulatorCommand( mapA ).start();

		else if ( Robot.controlSet == 1 )
			new RunManipulatorCommand( mapB ).start();

		super.start();
	}
}
