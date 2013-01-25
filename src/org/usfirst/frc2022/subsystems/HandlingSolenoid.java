package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2022.RobotMap;

/**
 * This subsystem is for activating and deactivating the solenoid for handling
 * system
 *
 * @author Malachi Loviska
 */
public class HandlingSolenoid extends Subsystem {

    Solenoid handling_Solenoid;
    /*
     * Initialize Solenoid
     */

    public HandlingSolenoid() {
        super("HandlingSolenoid");


        handling_Solenoid = new Solenoid(RobotMap.handlingSolenoid);
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

        handling_Solenoid.set(true);

    }

    /*
     * Deactivate Solenoid.
     * 
     */
    public void deactivate() {
        handling_Solenoid.set(false);
    }
}