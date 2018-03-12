package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;
import org.usfirst.frc2876.PowerUp2018.RobotMap;
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
    	boolean expel = true;
    			System.out.println("Working");
		// we need to raise arms to release kick-stand
//    	addParallel(new ElevatorGoToPosition(RobotMap.ELEVATOR_POSITION_SWITCH_CUBE));

		if (Robot.getRobotPos() == Robot.RobotPosition.Center) {
			fromCenterDoSwitch();
		} else if (Robot.getRobotPos() == Robot.RobotPosition.Left) {
			if (Robot.isSwitchLeft() && Robot.isScaleRight()) {
				fromSideDoSameSwitch(true);
			} else if (Robot.isSwitchRight() && Robot.isScaleRight()) {
				fromSideDoOppositeScale(true);
				expel = false;
			} else if (Robot.isSwitchRight() && Robot.isScaleLeft()) {
				fromSideDoSameScale(true);
//				expel = false;
			} else {
				fromSideDoSameSwitch(true);
			}
		} else if (Robot.getRobotPos() == Robot.RobotPosition.Right) {
			if (Robot.isSwitchRight() && Robot.isScaleLeft()){
				fromSideDoSameSwitch(false);
			} else if (Robot.isSwitchLeft() && Robot.isScaleLeft()){
				fromSideDoOppositeScale(false);
				expel = false;
			} else if (Robot.isSwitchLeft() && Robot.isScaleRight()) {
				fromSideDoSameScale(false);
//				expel = false;
			}else {
				fromSideDoSameSwitch(false);
			}
		} else {
			// Huh?  RobotPos is screwed up! Drive at slight right angle and log to a log file
			// TODO - log to a log file
			fromUnknownDoAutoLine();
		}
    	
		if (expel) {
		// Expel cube
//			addSequential(new IntakeBackward(), 2);
		}
//		System.out.println("Auto finished");
//		System.out.print("\n");
    }
    
    private void fromCenterDoSwitch() {
		int angleMultiplier = Robot.isSwitchLeft() ? -1 : 1;
		int fudgeDistance = Robot.isSwitchLeft() ? -3 : -6;
		System.out.println("fromCenterDoSwitch 1");
		addSequential(new AutoDriveStraightDistance(Distances.CENTER_WALL_TO_TURN));
		addSequential(new AutoDriveTurn(60 * angleMultiplier));
		System.out.println("fromCenterDoSwitch 2");
		addSequential(new AutoDriveStraightDistance(Distances.CENTER_TURN_TO_SWITCH));
		addSequential(new AutoDriveTurn(-60 * angleMultiplier));
		System.out.println("fromCenterDoSwitch 3");
		addSequential(new AutoDriveStraightDistance(Distances.CENTER_DRIVE_TO_SWITCH_AFTER_TURN + fudgeDistance));
		System.out.println("fromCenterDoSwitch finished");

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
		//addSequential(new AutoDriveTurn(-90 * turnAngleModifier));
		//addSequential(new AutoDriveStraightDistance(Distances.PLATFORM_ZONE_TO_SCALE));
		//addSequential(new ElevatorGoToPosition(RobotMap.ELEVATOR_POSITION_SCALE_CUBE));
    }
    
    private void fromSideDoSameScale(boolean turnClockwise) {
    	int turnAngleModifier = turnClockwise ? 1 : -1;
		addSequential(new AutoDriveStraightDistance(Distances.WALL_TO_SCALE));
		addSequential(new AutoDriveTurn(70 * turnAngleModifier));
		addSequential(new AutoDriveStraightDistance(Distances.AT_SCALE));
//		addSequential(new ElevatorGoToPosition(RobotMap.ELEVATOR_POSITION_SCALE_CUBE));
    }
    
    private void fromUnknownDoAutoLine(){
		addParallel(new AutoDriveTurn(20));
    	addSequential(new AutoDriveStraightDistance(Distances.WALL_TO_AUTOLINE));
    }
}
