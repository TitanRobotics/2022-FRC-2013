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
public class HandlingCommand extends CommandBase {
    
    Attack3 mrTrollerAttacksThee;
    
    public HandlingCommand() {
        requires(handlingSpike);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        mrTrollerAttacksThee = oi.getAttack3();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        handlingSpike.activate();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        handlingSpike.deactivate();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        handlingSpike.deactivate();
    }
}
