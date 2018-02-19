package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;

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

	// Guesstimates!
	private static final int CENTER_WALL_TO_TURN_DIST = 20;
	private static final int WALL_TO_SWITCH_DIST = 50;
	private static final int AT_SWITCH_DIST = 10;
	private static final int WALL_TO_SCALE_DIST = 100;
	private static final int WALL_TO_PLATFORM_ZONE_DIST = 75;
	private static final int PLATFORM_ZONE_WIDTH_DIST = 75;
	private static final int PLATFORM_ZONE_TO_SCALE_DIST = 15;
	private static final int AT_SCALE_DIST = 5;
	
	
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
			} else { // 'LL' or 'RL'
			    fromSideDoSameScale(true);
			}
		} else if (Robot.getRobotPos() == Robot.RobotPosition.Right) {
			if(Robot.isSwitchRight() && Robot.isScaleLeft()){
				fromSideDoSameSwitch(false);
			} else if (Robot.isSwitchLeft() && Robot.isScaleLeft()){
				fromSideDoOppositeScale(false);
			} else { // 'RR' or 'LR'
			    fromSideDoSameScale(false);
			}
		} else {
			// Huh?  RobotPos is screwed up!
		}
    	
		//addSequential(new IntakeForward());
    }
    
    private void fromCenterDoSwitch() {
		int angleMultiplier = Robot.isSwitchLeft() ? -1 : 1;
		addSequential(new AutoDriveStraightDistance(CENTER_WALL_TO_TURN_DIST));
		addSequential(new AutoDriveTurn(60 * angleMultiplier));
		addSequential(new AutoDriveStraightDistance(100));
		addSequential(new AutoDriveTurn(-60 * angleMultiplier));
		addSequential(new AutoDriveStraightDistance(20));
    }
    
    private void fromSideDoSameSwitch(boolean turnClockwise) {
    	int turnAngleModifier = turnClockwise ? 1 : -1;
		addSequential(new AutoDriveStraightDistance(WALL_TO_SWITCH_DIST));
		addSequential(new AutoDriveTurn(90 * turnAngleModifier));
		addSequential(new AutoDriveStraightDistance(AT_SWITCH_DIST));
    }
    
    private void fromSideDoOppositeScale(boolean turnClockwise) {
    	int turnAngleModifier = turnClockwise ? 1 : -1;
		addSequential(new AutoDriveStraightDistance(WALL_TO_PLATFORM_ZONE_DIST));
		addSequential(new AutoDriveTurn(90 * turnAngleModifier));
		addSequential(new AutoDriveStraightDistance(PLATFORM_ZONE_WIDTH_DIST));
		addSequential(new AutoDriveTurn(-90 * turnAngleModifier));
		addSequential(new AutoDriveStraightDistance(PLATFORM_ZONE_TO_SCALE_DIST));
    }
    
    private void fromSideDoSameScale(boolean turnClockwise) {
    	int turnAngleModifier = turnClockwise ? 1 : -1;
		addSequential(new AutoDriveStraightDistance(WALL_TO_SCALE_DIST));
		addSequential(new AutoDriveTurn(90 * turnAngleModifier));
		addSequential(new AutoDriveStraightDistance(AT_SCALE_DIST));
    }
}
