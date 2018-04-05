// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.PowerUp2018.commands;
import org.usfirst.frc2876.PowerUp2018.Robot;
import org.usfirst.frc2876.PowerUp2018.RobotMap;
import org.usfirst.frc2876.PowerUp2018.utilities.BHS_TalonSRX;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class XboxDrive extends Command {

	boolean isStraightBeginning = true;
	int straightTimer = 0;
	
	private final BHS_TalonSRX rightMaster = RobotMap.rightMaster;
	private final BHS_TalonSRX leftMaster = RobotMap.leftMaster;
	private final BHS_TalonSRX rightFollower = RobotMap.rightFollower;
	private final BHS_TalonSRX leftFollower = RobotMap.leftFollower;

    public XboxDrive() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	Joystick xbox = Robot.oi.getXboxController();
//    	if (!Robot.driveTrain.isTurnPIDRunning() && !Robot.driveTrain.isDistancePIDRunning()){
//    		Robot.driveTrain.arcadeDrive(-Robot.oi.getRightX(), Robot.oi.getLeftY());
//    		Robot.driveTrain.tankDrive(Robot.oi.getLeftY(), -Robot.oi.getRightY());

//    		if(Math.abs(Robot.oi.getRightX()) <= .1 && !(Math.abs(Robot.oi.getLeftY()) <= .1)){
//    			if(isStraightBeginning){
//    				Robot.driveTrain.startStraight();
//    				isStraightBeginning = false;
//    			}
//    			Robot.driveTrain.setStraightVelocityArcadeJoysticks(Robot.oi.getLeftY());
//    		}else{
//    			isStraightBeginning = true;
//    			Robot.driveTrain.stopStraight();
//    			Robot.driveTrain.setVelocityArcadeJoysticks(
//    					Robot.driveTrain.adjustJoystickElevator(Robot.oi.getRightX()), 
//    					Robot.driveTrain.adjustJoystickElevator(Robot.oi.getLeftY()));
//    		}
    		if(xbox.getRawButton(7)){
    			double targetPos = Robot.oi.getLeftY() * 100;
    			leftMaster.set(ControlMode.MotionMagic, targetPos);
    			rightMaster.set(ControlMode.MotionMagic, targetPos);
    		}else{
    			leftMaster.set(ControlMode.PercentOutput, Robot.oi.getLeftY());
    			rightMaster.set(ControlMode.PercentOutput, Robot.oi.getLeftY());
    		}
//    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
