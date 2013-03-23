/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2022.Joysticks.Attack3;
import org.usfirst.frc2022.Utils;

/**
 *
 * @author Emma Sloan
 */
public class RotationPitchCommand extends CommandBase {

    Attack3 attack3;

    public RotationPitchCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooterPitch);
        requires(shooterRotation);
        attack3 = oi.getAttack3();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooterPitch.disable(); //Disables the PID loop for the pitch
        shooterRotation.disable(); //Disables the PID loop for the rotation
        shooterPitch.setPitch(0);
        shooterRotation.setRotation(0);
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //manual command to set the pitch to the attack 3 y axis value        
        //TODO Comment code. Ask prosa.
        double ps, pd, pf, rs, rd, rf;

        ps = 0.5;
        pd = 0.1;
        pf = Utils.controllerMath(attack3.GetY(), 1, pd, ps);
        
        rs = 0.5;
        rd = .1;
        rf = Utils.controllerMath(attack3.GetX(), 0.75, rd, rs);

        shooterPitch.setPitch(pf);
        SmartDashboard.putNumber("Pitch", attack3.GetY());
        SmartDashboard.putNumber("Pitch Findal", pf);

        //manual command to set the rotation to the attack 3 x axis value
        shooterRotation.setRotation(rf);
        SmartDashboard.putNumber("Pitch", attack3.GetX());
        SmartDashboard.putNumber("Pitch Findal", rf);
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
        shooterPitch.setPitch(0);
        shooterRotation.setRotation(0);
    }
}
