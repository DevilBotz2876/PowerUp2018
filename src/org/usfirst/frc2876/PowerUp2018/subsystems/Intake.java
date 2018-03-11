
// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.PowerUp2018.subsystems;

import org.usfirst.frc2876.PowerUp2018.RobotMap;
import org.usfirst.frc2876.PowerUp2018.commands.*;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.NeutralMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Intake extends Subsystem {

 
    private final WPI_TalonSRX rightMotor = RobotMap.intakeIntakeRightTalonSRX7;
    private final WPI_TalonSRX leftMotor = RobotMap.intakeIntakeLeftTalonSRX8;
    
    private final double DISTANCE_WHEN_BOX_IN = 8; // distance in inches
    private final double IN_SPEED = -.8;
    private final double OUT_SPEED = .7;
   
    private Ultrasonic usIntakeSensor = RobotMap.usIntakeSensor;
    
    public Intake() {
    	leftMotor.setInverted(false);    	
    	rightMotor.setInverted(true);
    	
    	leftMotor.setNeutralMode(NeutralMode.Coast);
    	rightMotor.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public void initDefaultCommand() {
       
    }
    
    
    public void inLeft() {
    	leftMotor.set(IN_SPEED);
    }
    
    public void inRight() {
    	rightMotor.set(IN_SPEED);
    }
    
    public void outLeft() {
    	leftMotor.set(OUT_SPEED);
    }
    
    public void outRight() {
    	rightMotor.set(OUT_SPEED);
    }
    
    public void stopLeft() {
    	leftMotor.set(0);
    }
    
    public void stopRight() {
    	rightMotor.set(0);
    }
    
    public void stop() {
    	leftMotor.set(0);
    	rightMotor.set(0);
    }

    public void spinInwards(double output){
    	leftMotor.set(output);
    	rightMotor.set(output);
    }
    
    public void spinOutwards(double output){
    	leftMotor.set(output);
    	rightMotor.set(output);
    }
    
    public void setBothMotors(double output){
    	leftMotor.set(output);
    	rightMotor.set(output);
    }
    
    public void updateSmartDashboard() {
//		SmartDashboard.putNumber("Intake Ultrasonic  in mm ",usIntakeSensor.getRangeMM());
  
//    	SmartDashboard.putNumber("Intake Ultrasonic distance in Inches ",usIntakeSensor.getRangeInches());
//      	usIntakeSensor.ping();
//    	SmartDashboard.putBoolean("Intake Ultrasonic Enabled", usIntakeSensor.isEnabled());
//       	SmartDashboard.putBoolean("Intake Ultrasonic isRangeValid", usIntakeSensor.isRangeValid());
//       	SmartDashboard.putBoolean("isBoxIn", isBoxIn());
//       	SmartDashboard.putBoolean("isBoxOut", isBoxOut());
   	
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    
    public boolean isBoxIn (){
    	boolean result = false;
    	double ultraSonicDistance = usIntakeSensor.getRangeInches();
    	 if(ultraSonicDistance > 1.0 && ultraSonicDistance < DISTANCE_WHEN_BOX_IN)
    		 result = true;
    	return result;
    }
    
    public boolean isBoxOut (){
    	boolean result = false;
    	double ultraSonicDistance = usIntakeSensor.getRangeMM();
    	 if(ultraSonicDistance > DISTANCE_WHEN_BOX_IN)
    		 result = true;
    	return result;
    }

}

