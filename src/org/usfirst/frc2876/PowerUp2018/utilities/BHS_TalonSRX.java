package org.usfirst.frc2876.PowerUp2018.utilities;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BHS_TalonSRX extends WPI_TalonSRX {

	private ControlMode _mode;
	
	public BHS_TalonSRX(int deviceNumber) {
		super(deviceNumber);
		_mode = ControlMode.PercentOutput;
	}

	public BHS_TalonSRX(int deviceNumber, ControlMode mode) {
		super(deviceNumber);
		_mode = mode;
	}
	
	public void setMode(ControlMode mode) {
		_mode = mode;
	}

	public ControlMode getMode() {
		return _mode;
	}

	// ------ set/get routines for WPILIB interfaces ------//
	@Override
	public void set(double speed) {
		super.set(_mode, speed);
	}

	@Override
	public void pidWrite(double output) {
		super.set(_mode, output);
	}
}
