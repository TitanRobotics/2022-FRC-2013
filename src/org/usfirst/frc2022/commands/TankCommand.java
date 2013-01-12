/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;
import org.usfirst.frc2022.Joysticks.Xbox360;
/**
 *
 * @author Student
 */
public class TankCommand extends CommandBase{
    Xbox360 xbox;
    public TankCommand(){
        //initializes command system, system has no dependencies
        requires(pwmDriveBase);
    }
    
    protected void initialize(){
        pwmDriveBase.stop(); //stops the motors when the robot starts up
    }
    
    protected void execute(){
        xbox=oi.getXbawks();
        double leftSpeed, rightSpeed;
        leftSpeed = xbox.GetLeftY();
        rightSpeed = xbox.GetRightY();
        if(Math.abs(leftSpeed)<0.2) {
            leftSpeed = 0;
        }
        if(Math.abs(rightSpeed)<0.2) {
            rightSpeed = 0;
        }
        pwmDriveBase.drive(leftSpeed, rightSpeed); //the robot will move!
        if (xbox.GetAValue()){
        pwmDriveBase.flipJags(); //flips if the flip button is pushed
        }
    }

    protected boolean isFinished() {
        return(false); //It's not over until it's over!
    }

    protected void end() {
        pwmDriveBase.stop(); //stop once the game ends
    }

    protected void interrupted() {
        pwmDriveBase.stop(); //stop if everything goes crazy
    }
}
