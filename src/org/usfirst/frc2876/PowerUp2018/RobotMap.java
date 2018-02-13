// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2876.PowerUp2018;

import org.usfirst.frc2876.PowerUp2018.utilities.BHS_TalonSRX;

import com.ctre.phoenix.motorcontrol.ControlMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static BHS_TalonSRX driveTrainRightTalonSRX1;
	public static BHS_TalonSRX driveTrainRightTalonSRX2;
	public static SpeedControllerGroup driveTrainSpeedControllerGroupRight;
	public static BHS_TalonSRX driveTrainLeftTalonSRX3;
	public static BHS_TalonSRX driveTrainLeftTalonSRX4;
	public static SpeedControllerGroup driveTrainSpeedControllerGroupLeft;
	public static DifferentialDrive driveTrainDifferentialDrive;
	public static WPI_TalonSRX intakeIntakeRightTalonSRX7;
	public static WPI_TalonSRX intakeIntakeLeftTalonSRX8;
	public static WPI_TalonSRX elevatorElevatorTalonSRX5;
	public static WPI_TalonSRX elevatorElevatorTalonSRX6;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static BHS_TalonSRX rightMaster;
	public static BHS_TalonSRX rightFollower;
	public static BHS_TalonSRX leftMaster;
	public static BHS_TalonSRX leftFollower;

	public static DigitalInput roboRioDIOIRBeam;
	public static Ultrasonic usSensor;

	public static WPI_TalonSRX elevatorMaster;
	public static WPI_TalonSRX elevatorFollower;

	public static void init() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		driveTrainRightTalonSRX1 = new BHS_TalonSRX(1);

		driveTrainRightTalonSRX2 = new BHS_TalonSRX(2);

		driveTrainSpeedControllerGroupRight = new SpeedControllerGroup(driveTrainRightTalonSRX1,
				driveTrainRightTalonSRX2);
		LiveWindow.addActuator("DriveTrain", "SpeedControllerGroupRight", driveTrainSpeedControllerGroupRight);

		driveTrainLeftTalonSRX3 = new BHS_TalonSRX(3);

		driveTrainLeftTalonSRX4 = new BHS_TalonSRX(4);

		driveTrainSpeedControllerGroupLeft = new SpeedControllerGroup(driveTrainLeftTalonSRX3, driveTrainLeftTalonSRX4);
		LiveWindow.addActuator("DriveTrain", "SpeedControllerGroupLeft", driveTrainSpeedControllerGroupLeft);

		driveTrainDifferentialDrive = new DifferentialDrive(driveTrainSpeedControllerGroupLeft,
				driveTrainSpeedControllerGroupRight);
		LiveWindow.addActuator("DriveTrain", "DifferentialDrive", driveTrainDifferentialDrive);
		driveTrainDifferentialDrive.setSafetyEnabled(true);
		driveTrainDifferentialDrive.setExpiration(0.1);
		driveTrainDifferentialDrive.setMaxOutput(1.0);

		intakeIntakeRightTalonSRX7 = new WPI_TalonSRX(7);

		intakeIntakeLeftTalonSRX8 = new WPI_TalonSRX(8);

		elevatorElevatorTalonSRX5 = new WPI_TalonSRX(5);

		elevatorElevatorTalonSRX6 = new WPI_TalonSRX(6);

		roboRioDIOIRBeam = new DigitalInput(8);
		LiveWindow.addSensor("RoboRioDIO", "IR Beam", roboRioDIOIRBeam);

		usSensor = new Ultrasonic(0, 1);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		rightMaster = driveTrainRightTalonSRX1;
		rightFollower = driveTrainRightTalonSRX2;
		leftMaster = driveTrainLeftTalonSRX4;
		leftFollower = driveTrainLeftTalonSRX3;

		rightFollower.set(ControlMode.Follower, rightMaster.getDeviceID());
		leftFollower.set(ControlMode.Follower, leftMaster.getDeviceID());

		elevatorMaster = elevatorElevatorTalonSRX5;
		elevatorFollower = elevatorElevatorTalonSRX6;

		elevatorFollower.set(ControlMode.Follower, elevatorMaster.getDeviceID());
	}
}
