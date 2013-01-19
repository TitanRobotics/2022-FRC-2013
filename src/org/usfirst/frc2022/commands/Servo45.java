package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.OI;
import org.usfirst.frc2022.Joysticks.Xbox360;

public class Servo45 extends CommandBase {

    public Servo45() {
        requires(camServos);
    }

    protected void initialize() {
    }

    protected void execute() {
        camServos.updateSD();
        Xbox360 xbox = oi.getXbawks();
        camServos.setPitchAngle(90*(xbox.GetRightY()/2+.5));
        camServos.setRotateAngle(90*(xbox.GetRightY()/2+.5));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
