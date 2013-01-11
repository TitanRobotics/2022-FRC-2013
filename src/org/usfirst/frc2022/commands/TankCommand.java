/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;
import org.usfirst.frc2022.subsystems.PWM_Generic;
import org.usfirst.frc2022.Joysticks.Xbox360;
/**
 *
 * @author Student
 */
public class TankCommand extends CommandBase{
    Xbox360 xbox;
    public TankCommand(){
        //initializes command system, system has no dependencies
        this.r;
    }
    
    protected void initialize(){
        stop(); //stops the motors when the robot starts up
    }
    
    protected void execute(){
        drive(); //the robot will move!
        if (GetAButton())
        then flipJags(); //flips if the flip button is pushed
    }

    protected boolean isFinished() {
        return(false); //It's not over until it's over!
    }

    protected void end() {
        stop(); //stop once the game ends
    }

    protected void interrupted() {
        stop(); //stop if everything goes crazy
    }
}
