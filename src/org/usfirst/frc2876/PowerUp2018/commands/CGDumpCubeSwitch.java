package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;
import org.usfirst.frc2876.PowerUp2018.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGDumpCubeSwitch extends CommandGroup {
	
	public CGDumpCubeSwitch() {
		addSequential(new ElevatorGoToPosition(RobotMap.ELEVATOR_POSITION_SWITCH_CUBE));
		addSequential(new IntakeOut());
		addSequential(new ElevatorGoToPosition(RobotMap.ELEVATOR_POSITION_DRIVE_CUBE));
	}

}
