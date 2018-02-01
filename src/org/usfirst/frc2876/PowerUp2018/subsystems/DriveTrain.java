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

import javax.security.auth.login.ConfigurationSpi;

import org.usfirst.frc2876.PowerUp2018.RobotMap;
import org.usfirst.frc2876.PowerUp2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SPI;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX rightTalonSRX1 = RobotMap.driveTrainRightTalonSRX1;
    private final WPI_TalonSRX rightTalonSRX2 = RobotMap.driveTrainRightTalonSRX2;
    private final SpeedControllerGroup speedControllerGroupRight = RobotMap.driveTrainSpeedControllerGroupRight;
    private final WPI_TalonSRX leftTalonSRX3 = RobotMap.driveTrainLeftTalonSRX3;
    private final WPI_TalonSRX leftTalonSRX4 = RobotMap.driveTrainLeftTalonSRX4;
    private final SpeedControllerGroup speedControllerGroupLeft = RobotMap.driveTrainSpeedControllerGroupLeft;
    private final DifferentialDrive differentialDrive = RobotMap.driveTrainDifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private final WPI_TalonSRX rightMaster = RobotMap.rightMaster;
    private final WPI_TalonSRX leftMaster = RobotMap.leftMaster;
    private final WPI_TalonSRX rightFollower = RobotMap.rightFollower;
    private final WPI_TalonSRX leftFollower = RobotMap.leftFollower;
    
    public PIDController distanceController;
    public AHRS navx;
    public CameraServer server;
    
    private int distanceOnTargets;
    
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new XboxDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

	public DriveTrain() {
		navx = new AHRS(SPI.Port.kMXP);
		
		rightMaster.setNeutralMode(NeutralMode.Coast);
		rightFollower.setNeutralMode(NeutralMode.Coast);
		leftMaster.setNeutralMode(NeutralMode.Coast);
		leftFollower.setNeutralMode(NeutralMode.Coast);
	
		rightMaster.configOpenloopRamp(0, 0);
		rightFollower.configOpenloopRamp(0, 0);
		leftMaster.configOpenloopRamp(0, 0);
		leftFollower.configOpenloopRamp(0, 0);
		
		rightMaster.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		leftMaster.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		
		leftMaster.setSensorPhase(true);
		rightMaster.setSensorPhase(false);
		
		
		//TODO: declare MAX_RPM and kDistanceTolerance
		//TODO: call a get method for MAX_RPM
		distanceController = new PIDController(.1, 0, 0, 0, new AvgEncoder(), new PIDOutput() {
			public void pidWrite(double output) {
				SmartDashboard.putNumber("DistancePid Output", output);
//				leftMaster.set(-output);
//				rightMaster.set(-output);
				tankDrive(-output, output);
			}
		});
//		distanceController.setOutputRange(-MAX_RPM, MAX_RPM);
		distanceController.setAbsoluteTolerance(1);
		
		
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public boolean isPIDRunning() {
		return distanceController.isEnabled();
	}
	
    public void arcadeDrive(double xSpeed, double zRotation){
    	differentialDrive.arcadeDrive(xSpeed, zRotation);
    	
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed){
    	differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }
    
    public void initializeCamera() {
		server = CameraServer.getInstance();
//		server.setQuality(50);
		UsbCamera serverUsb = server.startAutomaticCapture("cam0", 0);
		serverUsb.setFPS(15);
		serverUsb.setResolution(160, 120);

	}
    
    public void updateSmartDashboard() {
    	SmartDashboard.putData(this);
    	 
    	SmartDashboard.putData("NavX", navx);
		SmartDashboard.putNumber("navX angle", navx.getAngle());
//		SmartDashboard.putBoolean("is navx conneced?", navx.isConnected());
		SmartDashboard.putData("Differential Drive Data", differentialDrive);
		
		SmartDashboard.putData("DistancePID", distanceController);
		SmartDashboard.putNumber("DistancePID Error", distanceController.getError());
		//
		//SmartDashboard.putNumber("DistancePID get", distanceController.get());
		
		getDistance();
    }
    
    public void velocityDistance() {
		double distance = -distanceController.get();
		rightMaster.set(distance);
		leftMaster.set(distance);
	}
    
    public void startDistance(double distance) {
    	distanceOnTargets = 0;
		distanceController.reset();
		resetEncoders();
		distanceController.setSetpoint(distance);
		distanceController.enable();
	}

	public boolean isDistanceRunning() {
		return distanceController.isEnabled();
	}
   
	public boolean isDistanceDone() {
		if (distanceController.onTarget()) {
			distanceOnTargets++;
		}
		return (distanceOnTargets > 10); 
	}

	public void stopDistance() {
		distanceController.reset();
		leftMaster.set(0);
		rightMaster.set(0);
	}
    
    public PIDController getDistancePID(){
    	return distanceController;
    }
    
    private static final double WHEEL_DIAMETER = 6;
    private static final double PULSES_PER_REV = 4096;
    
    public double nativeToInches(double nativeUnits){
    	double circumference = Math.PI * WHEEL_DIAMETER;
    	return (nativeUnits / PULSES_PER_REV) * circumference;
    }
    
    public void resetEncoders() {
		leftMaster.setSelectedSensorPosition(leftMaster.getDeviceID(), 0, 100);
		rightMaster.setSelectedSensorPosition(rightMaster.getDeviceID(), 0, 100);
	}
    
    public double getDistance(){
    	double l = nativeToInches(leftMaster.getSelectedSensorPosition(0));
    	double r = nativeToInches(rightMaster.getSelectedSensorPosition(0));
    	double av = (r + l) / 2;
    	SmartDashboard.putNumber("Left Distance", l);
    	SmartDashboard.putNumber("Right Distance", r);
    	SmartDashboard.putNumber("Average Distance", av);
    	return av;
    }
    
    private class AvgEncoder implements PIDSource {
    	
    	public double pidGet(){
    		return getDistance();
    	}
    	
    	public PIDSourceType getPIDSourceType(){
    		return PIDSourceType.kDisplacement;
    	}

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
}

