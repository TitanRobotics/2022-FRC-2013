/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Joysticks.Attack3;


/**
 *
 * @author Michael
 */
public class SweetSpotCommand extends CommandBase{

    public SweetSpotCommand(){
        requires(shooterInjector);
        requires(shooterPitch);
        requires(shooterRotation);
    }
    
    protected void initialize() {
        shooterInjector.enable();
        shooterPitch.enable();
        shooterRotation.enable();
        shooterRotation.setSetpoint(0);
        shooterPitch.setSetpoint(0);
        shooterInjector.setSetpoint(0);
    }

    protected void execute() {
        shooterInjector.setShooter(Math.E / 5.0);
        shooterPitch.setPitch(Math.floor(Math.E / 2.0));
        shooterInjector.setShooter(Math.PI/5.0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooterInjector.disable();
        shooterPitch.disable();
        shooterRotation.disable();
        
    }

    protected void interrupted() {
        shooterInjector.disable();
        shooterPitch.disable();
        shooterRotation.disable();
        
    }
    
    
    
}
