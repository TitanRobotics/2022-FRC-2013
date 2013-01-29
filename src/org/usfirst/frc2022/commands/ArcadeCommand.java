/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Joysticks.Xbox360;
import org.usfirst.frc2022.Utils;

/**
 * The command designed for use with an Arcade drive. All controls and functions
 * needed to run it are here.
 *
 * @author Titan Robotics (2022)
 * @author Michael Hrcek
 */
public class ArcadeCommand extends CommandBase {

    //declare variables
    Xbox360 controller;

    /**
     * The constructor. It requires a generic PWM.
     *
     * @param
     * @return
     */
    public ArcadeCommand() {
        requires(pwmDriveBase);

    }

    /**
     * This function is called when the command starts. It registers the
     * controller and sets the speeds to zero.
     *
     * @param
     * @return
     */
    protected void initialize() {
        controller = oi.getXbawks();
    }

    /**
     * The primary loop for the arcade drive. Gets controller input and commands
     * the generic PWM to move the bot.
     *
     * @param
     * @return
     */
    protected void execute() {

        //The direction and magnitude and rotation

        double x = Utils.clamp(controller.GetLeftX(), 1, -1);
        double y = Utils.clamp(controller.GetLeftY(), 1, -1);
        if (Math.abs(x) < 0.2) {
            x = 0;
        }
        if (Math.abs(y) < 0.2) {
            y = 0;
        }

        pwmDriveBase.drive((y + x), (y - x));
    }

    protected boolean isFinished() {
        return false;
    }

    /**
     * This function is called when the command ends.
     *
     * @param
     * @return
     */
    protected void end() {
        pwmDriveBase.stop();
    }

    /**
     * This function is called when the command is interrupted.
     *
     * @param
     * @return
     */
    protected void interrupted() {
        pwmDriveBase.stop();
    }
}
