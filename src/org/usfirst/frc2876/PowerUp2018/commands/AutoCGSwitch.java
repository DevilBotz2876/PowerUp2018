package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCGSwitch extends CommandGroup {

	public AutoCGSwitch() {

		// TODO we need to raise arms to release kick-stand
		// addParallel(new ElevatorPosition(10));

		if (Robot.getRobotPos() == Robot.RobotPosition.Center) {
			int angleMultiplier = Robot.isSwitchLeft() ? -1 : 1;

			// these are guesstimates
			addSequential(new AutoDriveStraightDistance(20));
			addSequential(new AutoDriveTurn(60 * angleMultiplier));
			addSequential(new AutoDriveStraightDistance(100));
			addSequential(new AutoDriveTurn(-60 * angleMultiplier));
			addSequential(new AutoDriveStraightDistance(20));

		} else if (Robot.getRobotPos() == Robot.RobotPosition.Left) {

			if (Robot.isSwitchLeft()) {

				// these are guesstimates
				addSequential(new AutoDriveStraightDistance(150));
				addSequential(new AutoDriveTurn(90));
				addSequential(new AutoDriveStraightDistance(10));

			} else { // is right

				// TODO decide which path to take to opposite side

			}
		} else if (Robot.getRobotPos() == Robot.RobotPosition.Right) {

			if (Robot.isSwitchLeft()) {

				// TODO decide which path to take to opposite side

			} else {

				addSequential(new AutoDriveStraightDistance(150));
				addSequential(new AutoDriveTurn(-90));
				addSequential(new AutoDriveStraightDistance(10));

			}

		}

		// TODO We need to know what command to use for intake
		// addSequential(new IntakeForward());
	}
}
