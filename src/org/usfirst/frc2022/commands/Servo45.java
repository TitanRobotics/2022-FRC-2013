package org.usfirst.frc2022.commands;

public class Servo45 extends CommandBase {

	public Servo45(){
		requires(camServos);
	}
	protected void initialize() {
		
	}

	protected void execute() {
		camServos.setPitchAngle(45.0);
		camServos.setRotateAngle(45.0);
		camServos.updateSD();
		System.out.println("\n\n PRINT........... \n\n");
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
