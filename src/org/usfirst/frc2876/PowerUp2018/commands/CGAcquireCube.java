package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;
import org.usfirst.frc2876.PowerUp2018.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGAcquireCube extends CommandGroup {
	
	public CGAcquireCube() {
		addSequential(new ElevatorGoToPosition(RobotMap.ELEVATOR_POSITION_ACQUIRE_CUBE));
		addSequential(new IntakeIn());
		addSequential(new ElevatorGoToPosition(RobotMap.ELEVATOR_POSITION_DRIVE_CUBE));
	}

}
