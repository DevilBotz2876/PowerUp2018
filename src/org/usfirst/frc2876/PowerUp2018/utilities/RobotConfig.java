package org.usfirst.frc2876.PowerUp2018.utilities;

public abstract class RobotConfig {

	// DriveTrain configuration
	public abstract double getMaxRpm();
	public abstract double getKTurnToleranceDegrees();

	public abstract boolean getLeftSensorPhase();
	public abstract boolean getRightSensorPhase();
	public abstract boolean getLeftInverted();
	public abstract boolean getRightInverted();

	public abstract double getLeftKP();
	public abstract double getLeftKF();
	public abstract double getRightKP();
	public abstract double getRightKF();

	public abstract double getDistancePidP();
	public abstract double getDistancePidI();
	public abstract double getDistancePidD();
	public abstract double getDistancePidF();
	
	public abstract double getTurnPidP();
	public abstract double getTurnPidI();
	public abstract double getTurnPidD();
	public abstract double getTurnPidF();

	public abstract double getWheelDiameter();
	public abstract double getEncoderPulsesPerRevolution();
	
}
