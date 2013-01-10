package org.usfirst.frc2022.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Servo45 extends CommandBase {

	protected void initialize() {
		requires(camServos);
	}

	protected void execute() {
		camServos.setPitchAngle(45.0);
		camServos.setRotateAngle(45.0);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
