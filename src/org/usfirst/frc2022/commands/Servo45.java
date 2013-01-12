package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.OI;
import org.usfirst.frc2022.Joysticks.Xbox360;

public class Servo45 extends CommandBase {

    Xbox360 xbox;

    public Servo45() {
        requires(camServos);
        //requires(pwmGeneric);
    }

    protected void initialize() {
        xbox = oi.getXbawks();
    }

    protected void execute() {
        camServos.updateSD();

        camServos.setPitchAngle(90 * (xbox.GetRightY() / 2 + .5));
        camServos.setRotateAngle(90 * (xbox.GetRightX() / 2 + .5));
        System.out.println("Servo45 Running");
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
