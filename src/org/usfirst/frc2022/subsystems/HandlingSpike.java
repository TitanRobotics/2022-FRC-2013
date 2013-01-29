package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2022.RobotMap;

/**
 * This subsystem is for activating and deactivating the solenoid for handling
 * system
 *
 * @author Malachi Loviska
 */
public class HandlingSpike extends Subsystem {

    Relay handling_Spike;
    /*
     * Initialize Solenoid
     */

    public HandlingSpike() {
        super("HandlingSolenoid");


        handling_Spike = new Relay(RobotMap.handlingSpike);
        /*
         * Constructs Solenoid
         */
    }

    public void initDefaultCommand() {
    }
    /*
     * Activates Solenoid
     */

    public void activate() {

        handling_Spike.set(Relay.Value.kForward);

    }

    /*
     * Deactivate Solenoid.
     * 
     */
    public void deactivate() {
        handling_Spike.set(Relay.Value.kOff);
    }
}