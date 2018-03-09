package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;
import org.usfirst.frc2876.PowerUp2018.utilities.Distances;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCGLine extends CommandGroup {

	public AutoCGLine() {

		// TODO we need to raise arms to release kick-stand
		// addParallel(new ElevatorPosition(10));

		System.out.println("Not Working");
		if (Robot.getRobotPos() == Robot.RobotPosition.Center) {
			int angleMultiplier = Robot.isSwitchLeft() ? 1 : -1;
			addSequential(new AutoDriveStraightDistance(Distances.CENTER_WALL_TO_TURN));
			addSequential(new AutoDriveTurn(60 * angleMultiplier));
			addSequential(new AutoDriveStraightDistance(Distances.CENTER_TURN_TO_SWITCH));
			addSequential(new AutoDriveTurn(30 * angleMultiplier));
		} else {
			addSequential(new AutoDriveStraightDistance(Distances.WALL_TO_PLATFORM_ZONE));
		}
	}
}
