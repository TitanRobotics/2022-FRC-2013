package org.usfirst.frc2022.commands;

import edu.wpi.first.wpilibj.command.Command;

public class TargetTrackerCommand extends CommandBase {

    /*
     * The portion of the image that the box can be in
     */
    public final double middle = .01;

    public TargetTrackerCommand() {
        requires(camServos);
    }

    protected void initialize() {
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
