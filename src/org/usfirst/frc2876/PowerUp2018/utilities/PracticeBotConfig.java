package org.usfirst.frc2876.PowerUp2018.utilities;

public class PracticeBotConfig extends RobotConfig {

	// Drive Train settings
	private double maxRpm = 3127.0f;
	private double kTurnToleranceDegrees = 1.0f;
		
	private boolean isLeftSensorPhase = false;
	private boolean isRightSensorPhase = true;

	private boolean isLeftInverted = true;
	private boolean isRightInverted = false;

	private double leftKP = 0.3729;
	private double leftKF = 0.3761;
	private double rightKP = 0.3639;
	private double rightKF = 0.3503;

	private double distancePidP = 0.1;
	private double distancePidI = 0;
	private double distancePidD = 0;
	private double distancePidF = 0;

	private double turnPidP = 0.011;
	private double turnPidI = 0;
	private double turnPidD = 0;
	private double turnPidF = 0;

	private double wheelDiameter = 6.5;
	private double encoderPulsesPerRevolution = 4096;

	@Override
	public double getMaxRpm() {
		return this.maxRpm;
	}

	@Override
	public double getKTurnToleranceDegrees() {
		return this.kTurnToleranceDegrees;
	}

	@Override
	public boolean getLeftSensorPhase() {
		return this.isLeftSensorPhase;
	}

	@Override
	public boolean getRightSensorPhase() {
		return this.isRightSensorPhase;
	}

	@Override
	public boolean getLeftInverted() {
		return this.isLeftInverted;
	}

	@Override
	public boolean getRightInverted() {
		return this.isRightInverted;
	}

	@Override
	public double getLeftKP() {
		return this.leftKP;
	}

	@Override
	public double getLeftKF() {
		return this.leftKF;
	}

	@Override
	public double getRightKP() {
		return this.rightKP;
	}

	@Override
	public double getRightKF() {
		return this.rightKF;
	}

	@Override
	public double getDistancePidP() {
		return this.distancePidP;
	}

	@Override
	public double getDistancePidI() {
		return this.distancePidI;
	}

	@Override
	public double getDistancePidD() {
		return this.distancePidD;
	}

	@Override
	public double getDistancePidF() {
		return this.distancePidF;
	}

	@Override
	public double getTurnPidP() {
		return this.turnPidP;
	}

	@Override
	public double getTurnPidI() {
		return this.turnPidI;
	}

	@Override
	public double getTurnPidD() {
		return this.turnPidD;
	}

	@Override
	public double getTurnPidF() {
		return this.turnPidF;
	}

	@Override
	public double getWheelDiameter() {
		return this.wheelDiameter;
	}

	@Override
	public double getEncoderPulsesPerRevolution() {
		return this.encoderPulsesPerRevolution;
	}

}
