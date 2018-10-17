package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoArmDown extends Command {

	int counter = 0;
	
    public AutoArmDown() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intake.armDown(0.5);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	counter++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return counter >= 35000;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.armStop(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
