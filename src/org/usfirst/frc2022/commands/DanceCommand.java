/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

/**
 *
 * @author Michael
 */
public class DanceCommand extends CommandBase {
    
    public DanceCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pwmDriveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        pwmDriveBase.drive(-.5, .5);
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
