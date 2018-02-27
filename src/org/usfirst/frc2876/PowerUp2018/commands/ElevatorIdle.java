package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorIdle extends Command {

    public ElevatorIdle() {
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.setPosition(Robot.elevator.getCurrentPosition());
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
