/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2022.Joysticks.Attack3;
import org.usfirst.frc2022.Utils;

/**
 * This has an idea what position it is in, and limits the user.
 * @author PRosa
 */
public class NewTurretCommand extends CommandBase {
    Attack3 attack3;
    /**
     * The desired pitch, in degrees.
     */
    double pitch = 0;
    
    /**
     * The desired rotation, in degrees.
     */
    double rotation = 0;
    
    //Don't let the user get out of these ranges.
    //Seriously.
    final double minPitch = 0;
    final double maxPitch = 50;
    final double minRotation = -45;
    final double maxRotation = 45;
    
    final double controlerDeadZone = .1;
    final double maxRotationSpeed = 30;
    
    
    public NewTurretCommand() {
        requires(shooterPitch);
        requires(shooterRotation);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        attack3 = oi.getAttack3();
        shooterPitch.enable();
        shooterRotation.enable();
        
    }

    // Called repeatedly when this Command is scheduled to run
    long lastTimeMS=0;
    protected void execute() {
        if(lastTimeMS==0)
            lastTimeMS=System.currentTimeMillis();
        
        double dTime = (lastTimeMS-System.currentTimeMillis())/1000.0;
        lastTimeMS=System.currentTimeMillis();
        SmartDashboard.putNumber("dTime", dTime);
        
        //manual command to set the pitch to the attack 3 y axis value        
        //TODO Comment code. Ask prosa.
        double pitchScale, pitchDeadzone, pitchChangeSpeed, rotationScale, rotationDeadzone, rotationChangeSpeed;

        pitchScale = 0.5;
        pitchDeadzone = 0.1;
        pitchChangeSpeed = Utils.controllerMath(attack3.GetY(), 1, pitchDeadzone, pitchScale);
        
        rotationScale = -0.5;
        rotationDeadzone = .1;
        rotationChangeSpeed = Utils.controllerMath(attack3.GetX(), 0.75, rotationDeadzone, rotationScale);

        
        pitch+=pitchChangeSpeed*dTime;
        SmartDashboard.putNumber("Pitch", attack3.GetY());
        SmartDashboard.putNumber("Pitch Final", pitchChangeSpeed);

        //manual command to set the rotation to the attack 3 x axis value
        rotation+=rotationChangeSpeed*dTime;
        SmartDashboard.putNumber("Rotation", attack3.GetX());
        SmartDashboard.putNumber("Rotaiton Final", rotationChangeSpeed);
        
        //Clamp and set!
        pitch=Utils.clamp(pitch, minPitch, maxPitch);
        rotation=Utils.clamp(rotation, minRotation, maxRotation);
        shooterPitch.setSetpoint(pitch);
        shooterRotation.setSetpoint(rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
