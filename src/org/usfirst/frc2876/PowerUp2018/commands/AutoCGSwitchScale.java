package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;
import org.usfirst.frc2876.PowerUp2018.utilities.Distances;

import edu.wpi.first.wpilibj.command.CommandGroup;

//  DECISION TABLE:
//    Note: Assumption is that the team that argued for center will attempt cube in switch
//
//                     Game Data
//    RobotPos     LL*      LR*      RL*      RR*
//    Center       <----------do switch -------->
//    Left         scale    switch   scale    scale
//    Right        scale    scale    switch   scale

/**
 *
 */
public class AutoCGSwitchScale extends CommandGroup {
	
    public AutoCGSwitchScale() {
    	
    	System.out.println("Running AutoCGSwitchScale: " + Robot.getRobotPos() + " " + Robot.isSwitchLeft());
		
		// TODO we need to raise arms to release kick-stand
		// addParallel(new ElevatorPosition(10));

		if (Robot.getRobotPos() == Robot.RobotPosition.Center) {
			fromCenterDoSwitch();
		} else if (Robot.getRobotPos() == Robot.RobotPosition.Left) {
			if(Robot.isSwitchLeft() && Robot.isScaleRight()){
				fromSideDoSameSwitch(true);
			} else if (Robot.isSwitchRight() && Robot.isScaleRight()){
				fromSideDoOppositeScale(true);
			} else {
				// Go to scale on same side as robot start.
			    fromSideDoSameScale(true);
			}
		} else if (Robot.getRobotPos() == Robot.RobotPosition.Right) {
			if(Robot.isSwitchRight() && Robot.isScaleLeft()){
				fromSideDoSameSwitch(false);
			} else if (Robot.isSwitchLeft() && Robot.isScaleLeft()){
				fromSideDoOppositeScale(false);
			} else {
			    fromSideDoSameScale(false);
			}
		} else {
			// Huh?  RobotPos is screwed up!
			// Let's drive at slight right angle and log to a log file
		}
    	
		// Raise to switch / scale height
		//addSequential(new somecommandwehaventwrittenyet)
		//addSequential(new IntakeForward());
    }
    
    private void fromCenterDoSwitch() {
		int angleMultiplier = Robot.isSwitchLeft() ? -1 : 1;
		addSequential(new AutoDriveStraightDistance(Distances.CENTER_WALL_TO_TURN));
		addSequential(new AutoDriveTurn(60 * angleMultiplier));
		addSequential(new AutoDriveStraightDistance(Distances.CENTER_TURN_TO_SWITCH));
		addSequential(new AutoDriveTurn(-60 * angleMultiplier));
		addSequential(new AutoDriveStraightDistance(20));
    }
    
    private void fromSideDoSameSwitch(boolean turnClockwise) {
    	int turnAngleModifier = turnClockwise ? 1 : -1;
		addSequential(new AutoDriveStraightDistance(Distances.WALL_TO_SWITCH));
		addSequential(new AutoDriveTurn(90 * turnAngleModifier));
		addSequential(new AutoDriveStraightDistance(Distances.AT_SWITCH));
    }
    
    private void fromSideDoOppositeScale(boolean turnClockwise) {
    	int turnAngleModifier = turnClockwise ? 1 : -1;
		addSequential(new AutoDriveStraightDistance(Distances.WALL_TO_PLATFORM_ZONE));
		addSequential(new AutoDriveTurn(90 * turnAngleModifier));
		addSequential(new AutoDriveStraightDistance(Distances.PLATFORM_ZONE_WIDTH));
		addSequential(new AutoDriveTurn(-90 * turnAngleModifier));
		addSequential(new AutoDriveStraightDistance(Distances.PLATFORM_ZONE_TO_SCALE));
    }
    
    private void fromSideDoSameScale(boolean turnClockwise) {
    	int turnAngleModifier = turnClockwise ? 1 : -1;
		addSequential(new AutoDriveStraightDistance(Distances.WALL_TO_SCALE));
		addSequential(new AutoDriveTurn(90 * turnAngleModifier));
		addSequential(new AutoDriveStraightDistance(Distances.AT_SCALE));
    }
}
