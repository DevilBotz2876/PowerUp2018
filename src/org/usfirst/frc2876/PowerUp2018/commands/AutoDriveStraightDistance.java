package org.usfirst.frc2876.PowerUp2018.commands;

import org.usfirst.frc2876.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveStraightDistance extends Command {

	private double m_distance;
	private boolean hasMoved = false;
	
    public AutoDriveStraightDistance(double distance) {
    	m_distance = distance;
    	// Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.driveTrain.setBrakeMode(true);
    	Robot.driveTrain.startDistance(m_distance);
    	Robot.driveTrain.startStraight();
    	Robot.oi.putSmartDashboardDriveCommand(this);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.setVelocityStraightDistance();
    	if (Robot.driveTrain.navxIsMoving()) {
    		hasMoved = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean retval = Robot.driveTrain.isDistanceDone() || (hasMoved && !Robot.driveTrain.navxIsMoving());
//        if (retval) {
//        	System.out.println("isFinished = true");
//        }
        return retval;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stopDistance();
    	Robot.driveTrain.stopStraight();
//    	System.out.println("Distance reached");
    	//Robot.driveTrain.setBrakeMode(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	System.out.println("AutoDriveStraightDistance.interrupted called");
    	end();
    }
}
