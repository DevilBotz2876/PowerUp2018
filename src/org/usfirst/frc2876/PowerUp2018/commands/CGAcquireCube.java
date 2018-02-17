package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;
import org.usfirst.frc2876.PowerUp2018.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CGAcquireCube extends CommandGroup {
	ElevatorPosition acquire, drive;
	IntakeForward intake;
	
	public CGAcquireCube() {
//		acquire = new ElevatorPosition(RobotMap.ELEVATOR_POSITION_ACQUIRE_CUBE);
//		addParallel(acquire);
		intake = new IntakeForward();
		addSequential(intake);
		drive = new ElevatorPosition(RobotMap.ELEVATOR_POSITION_DRIVE_CUBE);
		addSequential(drive);


		// TODO We need to know what command to use for intake
		// addSequential(new IntakeForward());
	}

//	public void execute() {
//		if (intake.isCompleted()) {
//			acquire.cancel();
//		}
//	}
}
