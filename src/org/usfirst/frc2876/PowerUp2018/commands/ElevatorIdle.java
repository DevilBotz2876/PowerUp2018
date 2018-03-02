package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorIdle extends Command {

	private boolean isPosSet = true;

    public ElevatorIdle() {
    	requires(Robot.elevator);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.setPosition(Robot.elevator.getCurrentPosition());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftTrigger = Robot.oi.getLeftTrigger();
		double rightTrigger = Robot.oi.getRightTrigger();
		
		if (leftTrigger > .1 || rightTrigger > .1){
			Robot.elevator.elevatorTriggers(rightTrigger, leftTrigger);
			isPosSet = false;
		} else if (!isPosSet) {
			Robot.elevator.setPosition(Robot.elevator.getCurrentPosition());
			isPosSet = true;
		}
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
