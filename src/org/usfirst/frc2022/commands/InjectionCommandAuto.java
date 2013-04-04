package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Joysticks.Attack3;


/**
 * Command to activate and deactivate the injector (does not use the
 * shooter)
 */
public class InjectionCommandAuto extends CommandBase {
    
    Attack3 attack3;
    
    public InjectionCommandAuto() {
        requires(injector);
    }

    // Sets the solenoid value to zero
    protected void initialize() {
       injector.deactivate();       
    }

    // Activates the solenoid
    protected void execute() {
        if (shooter.isOn())
        {
                injector.activate();
        }
    }

    protected boolean isFinished() {
        return true;
    }

    // Sets the solenoid value to zero
    protected void end() {
        injector.deactivate();
    }

    // Sets the solenoid value to zero
    protected void interrupted() {
        injector.deactivate();
    }
}
