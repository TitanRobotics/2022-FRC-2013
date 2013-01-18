package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Utils;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TargetTrackerCommand extends CommandBase {

    public TargetTrackerCommand() {
        requires(cam);
        requires(camServos);
    }

    protected void initialize() {
    }

    protected void execute() {
        ParticleAnalysisReport[] report = cam.analyze();
        if (report.length < 1) {
            SmartDashboard.putString("DEBUG"," None found");
            return;
        }
        ParticleAnalysisReport particle = report[0];
        double xpos = particle.center_mass_x_normalized;
        double ypos = particle.center_mass_y_normalized;

        double rotate = Utils.sign(xpos) * 1;
        double pitch = Utils.sign(ypos) * 1;

        SmartDashboard.putString("DEBUG", "X = " + xpos + ", Y= " + ypos + "; r=" + rotate + ",p=" + pitch);
        camServos.setRotateAngle(camServos.getRotateAngle() + rotate);
        camServos.setPitchAngle(camServos.getRotateAngle() + pitch);
        camServos.updateSD();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
