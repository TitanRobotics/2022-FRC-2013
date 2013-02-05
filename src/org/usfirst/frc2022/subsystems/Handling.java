package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2022.RobotMap;

/**
 * This subsystem is for activating and deactivating the solenoid for handling
 * system
 *
 * @author Malachi Loviska
 */
public class Handling extends Subsystem {

    Relay handling_Spike;
    Jaguar Handling_Solenoid;
    /*
     * Initialize Solenoid
     * And Spike
     */

    public Handling() {
        super("HandlingSolenoid");


        handling_Spike = new Relay(RobotMap.handlingSpike);
        Handling_Solenoid = new Jaguar(RobotMap.handlingsolenoid);
        
        /*
         * Constructs Solenoid and Jaguar
         */
    }

    public void initDefaultCommand() {
    }
    /*
     * Activates Solenoid and Jaguar
     */

    public void activate() {

        handling_Spike.set(Relay.Value.kForward);
        Handling_Solenoid.set(1);
    }

    /*
     * Deactivate Solenoid and Jaguar
     * 
     */
    public void deactivate() {
        handling_Spike.set(Relay.Value.kOff);
        Handling_Solenoid.set(0);
    }
}