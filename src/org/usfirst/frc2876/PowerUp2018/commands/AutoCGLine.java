package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCGLine extends CommandGroup {

    public AutoCGLine() {
    	
    	System.out.println("Running AutoCGLine: " + Robot.getRobotPos() + " " + Robot.isSwitchLeft());
		
		// TODO we need to raise arms to release kick-stand
		// addParallel(new ElevatorPosition(10));

		if (Robot.getRobotPos() == Robot.RobotPosition.Center) {
			int angleMultiplier = Robot.isSwitchLeft() ? 1 : -1;
			
			addSequential(new AutoDriveStraightDistance(20));
			addSequential(new AutoDriveTurn(60 * angleMultiplier));
			addSequential(new AutoDriveStraightDistance(60));
			addSequential(new AutoDriveTurn(30 * angleMultiplier));
			
		} else if(Robot.getRobotPos() == Robot.RobotPosition.Left){
			
			if(Robot.isSwitchLeft()){
				
				// TODO decide which path to take to opposite side
				
			} else { // is right
				
				addSequential(new AutoDriveStraightDistance(100));
				
			}
		} else if(Robot.getRobotPos() == Robot.RobotPosition.Right){
			
			if(Robot.isSwitchLeft()){
				
				addSequential(new AutoDriveStraightDistance(100));
				
			} else { // is right
				
				// TODO decide which path to take to opposite side
				
			}
		}
    }
}
