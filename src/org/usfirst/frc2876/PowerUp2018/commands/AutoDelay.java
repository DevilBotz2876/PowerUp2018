package org.usfirst.frc2876.PowerUp2018.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDelay extends Command {

	Long m_delay;
	
    public AutoDelay(Long d) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_delay = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	try {
			Thread.sleep(m_delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
