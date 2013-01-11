/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Joysticks.Xbox360;

/**
 *
 * @author Michael
 */
public class MecanumCommand extends CommandBase{

    Xbox360 controller;
    double speedLeftFront;
    double speedRightFront;
    double speedLeftBack;
    double speedRightBack;
    
    public MecanumCommand(){
        requires(pwmGeneric);
        controller = new Xbox360(0);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        
        if(controller.GetAValue()){
            pwmGeneric.flipJags();
        }
        getSpeeds();
        pwmGeneric.driveMecanum(speedLeftFront, speedRightFront, speedLeftBack, speedRightBack);
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

    private void getSpeeds() {
        speedLeftFront = controller.GetLeftY();
        speedLeftBack = controller.GetLeftY();
        speedRightFront = controller.GetRightY();
        speedRightBack = controller.GetRightY();
    }
    
}
