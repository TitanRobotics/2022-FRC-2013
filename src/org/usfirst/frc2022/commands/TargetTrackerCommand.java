package org.usfirst.frc2022.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TargetTrackerCommand extends CommandBase {

    public TargetTrackerCommand() {
        requires(cam);
        requires(camServos);
    }

    protected void initialize() {
    }

    protected void execute() {
        double[] analysis = cam.analyze();
        String type;
        if (analysis[3] > 0) {
            if (analysis[0] == 1.0){
                type = "Middle goal";
            }
            else if (analysis[0] == 2.0){
                type = "High goal";
            }
            else{
                type = "Not a goal";
            }
            
            SmartDashboard.putString(type + ": ", "(" + Double.toString(analysis[1]) + "), (" + Double.toString(analysis[2]) + ")");
        }
        else{
            type = "Not a goal";
            SmartDashboard.putString("No goal found: ", type);
        }
        
        /*
         *   double rotate = Utils.sign(analysis[1]) * 1;
         *   double pitch = Utils.sign(analysis[2]) * 1;        
         *   camServos.setRotateAngle(camServos.getRotateAngle() + rotate);
         *   camServos.setPitchAngle(camServos.getPitchAngle() + pitch);
         *   camServos.updateSD();
         */
    }


    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
