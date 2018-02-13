package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoSwitch extends Command {

    public AutoSwitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.isScaleLeft()) {
    		if (Robot.getRobotPosition() == Robot.RobotPosition.CENTER) {
    			// NOTE - these numbers are sample guesses, not verified by game manual
    			// driveForward 12 inches
    			// turnLeft 90 degrees
    			// driveForward 60 inches
    			// turnRight 90 degrees
    			// raise elevator
    			// driveForward 60 inches
    			// intake out
    		}
    	} else {
    		
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
