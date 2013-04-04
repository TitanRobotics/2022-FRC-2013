/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

/**
 *
 * @author Paul
 */
public class ClimbCommand extends CommandBase {
    
    public ClimbCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        climber.extend();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        climber.pullUp();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        climber.pullUp();
    }
}
