package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Utils;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

public class TargetTrackerCommand extends CommandBase {
	/**
	 * The portion of the image that the box can be in
	 */
	public final double middle = .2;

	protected void initialize() {
		requires(cam);
		requires(camServos);
	}

	protected void execute() {
		ParticleAnalysisReport[] report = cam.analyze();
		if (report.length < 1){
			return;
		}
		ParticleAnalysisReport particle = report[0];
		double xpos = particle.center_mass_x_normalized;
		double ypos = particle.center_mass_y_normalized;
		double rotate = Utils.sign(xpos)*3;
		double pitch = Utils.sign(ypos)*3;		
		camServos.setRotateAngle(camServos.getRotateAngle() + rotate);
		camServos.setPitchAngle(camServos.getRotateAngle() + pitch);
	}
	
	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
