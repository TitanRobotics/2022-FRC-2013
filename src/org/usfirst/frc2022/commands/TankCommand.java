/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Joysticks.Xbox360;

/**
 *
 * @author Andrew Kazenas
 */
public class TankCommand extends CommandBase {

    Xbox360 xbox;

    public TankCommand() {
        //initializes command system, system has no dependencies
        requires(pwmDriveBase);
        pwmDriveBase.flipJags();
    }

    protected void initialize() {
        pwmDriveBase.stop(); //stops the motors when the robot starts up
    }

    protected void execute() {
        xbox = oi.getXbawks();
        double xboxTriggers = xbox.GetTriggers();
        double leftSpeed, rightSpeed;
        leftSpeed = xbox.GetLeftY()/2.0;
        rightSpeed = xbox.GetRightY()/2.0;
        
        if (xboxTriggers > 0.5) {
            leftSpeed /= 2.0;
            rightSpeed /= 2.0;
        } else if (xboxTriggers < -0.5) {
            leftSpeed *= 2.0;
            rightSpeed *= 2.0;
        }
        
        if (Math.abs(leftSpeed) < 0.1) {
            leftSpeed = 0;
        }
        if (Math.abs(rightSpeed) < 0.1) {
            rightSpeed = 0;
        }
        pwmDriveBase.drive(-leftSpeed, rightSpeed); //the robot will move!
        
    }

    protected boolean isFinished() {
        return (false); //It's not over until it's over!
    }

    protected void end() {
        pwmDriveBase.stop(); //stop once the game ends
    }

    protected void interrupted() {
        pwmDriveBase.stop(); //stop if everything goes crazy
    }
}
