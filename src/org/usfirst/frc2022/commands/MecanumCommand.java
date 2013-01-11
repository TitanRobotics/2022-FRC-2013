/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Joysticks.Xbox360;
import org.usfirst.frc2022.Utils;


/**
 *
 * @author Michael
 */
public class MecanumCommand extends CommandBase{

    //declare variables
    Xbox360 controller;
    double speedLeftFront;
    double speedRightFront;
    double speedLeftBack;
    double speedRightBack;
    
    /**
     * The constructor. It requires pwmDriveBase from CommandBase.java
     * 
     * @author Titan Robotics (2022)
     * @param
     * @return
     */
    public MecanumCommand(){
        requires(pwmDriveBase);
        
    }
    
    /**
     * This function is called when the command starts.
     * It registers the controller and sets the speeds.
     * 
     * @author Titan Robotics (2022)
     * @param
     * @return 
     */
    protected void initialize() {
        controller = oi.getXbawks();
        speedLeftFront = 0;
        speedRightFront = 0;
        speedLeftBack = 0;
        speedRightBack = 0;
    }

    /**
     * The primary loop for the mecanum drive. Gets controller input
     * and does sends commands to PWM_Generic.java to move the bot.
     * It also contains the mecanum algorithms.
     * 
     * @author Titan Robotics (2022)
     * @param
     * @return 
     */
    protected void execute() {
        
        //The direction and magnitude and rotation
        double direction = (controller.GetLeftAngle(false) * 180) / Math.PI;
	double magnitude = (controller.GetLeftMagnitude() / 2);
	double rotation = controller.GetRightX() / 3;
	
	//Set Deadband on Translation and Rotation
	if(magnitude < 0.2) {
            magnitude = 0;
        }
	if((Math.abs(rotation) * 3) < 0.2) {
            rotation = 0;
        }
	
	if(controller.GetTriggers() > .5) {
            magnitude /= 2;
        }
	if(controller.GetTriggers() < -.5) {
            magnitude *= 2;
        }
	
        //define custom cosine and sine functions
	double cosD = Math.cos((direction + 45.0) * Math.PI / 180.0);
	double sinD = Math.cos((direction - 45.0) * Math.PI / 180.0);

        //set speeds and clamp at 1 and -1
	speedLeftFront = Utils.clamp((sinD * magnitude + rotation) * 2,1,-1);
	speedLeftBack = Utils.clamp((cosD * magnitude + rotation) * 2,1,-1);
	speedRightFront = Utils.clamp((cosD * magnitude - rotation) * 2,1,-1);
	speedRightBack = Utils.clamp((sinD * magnitude - rotation) * 2,1,-1);
			
	//Update Mecanum Subsystem
	pwmDriveBase.driveMecanum(-speedLeftFront, -speedRightFront, speedLeftBack, speedRightBack);
        
    }

    protected boolean isFinished() {
        return false;
    }
    
    /**
     * This function is called when the command ends.
     * 
     * @author Titan Robotics (2022)
     * @param
     * @return 
     */
    protected void end() {
        pwmDriveBase.stop();
    }

    /**
     * This function is called when the command is interrupted.
     * 
     * @author Titan Robotics (2022)
     * @param
     * @return 
     */
    protected void interrupted() {
        pwmDriveBase.stop();
    }

    /*
     *Function is useless and had a use at one point
     * but I'm too lazy to take it out...
     * 
    private void getSpeeds() {
        speedLeftFront = controller.GetLeftY();
        speedLeftBack = controller.GetLeftY();
        speedRightFront = -controller.GetRightY();
        speedRightBack = -controller.GetRightY();
    }*/
    
}
