package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2022.RobotMap;
import org.usfirst.frc2022.Utils;
import org.usfirst.frc2022.commands.InjectionCommand;
import org.usfirst.frc2022.commands.ShooterCommand;


/**
 * This code is used to control the speed of Jaguars controlling the shooter for
 * picking up Frisbees by taking input as the rotation speed of the encoder And
 * for output giving ability to modify speed. Note: names with "_" are from the
 * program, no "_" are from RobotMap
 *
 * @author Malachi Loviska
 */
public class Injector extends Subsystem {

    Relay shooter_Spikezor;
    
    /**
     * Constructs the Jaguar, Encoder, and Solenoid and assigns ports from robot
     * map. It also starts the Encoder
     */
    public Injector() {
        shooter_Spikezor = new Relay(RobotMap.shooterSpike);
        
    }
    
    
    ///////////////////// Injection Functions /////////////////////////
    /*
     * Activate Solenoid if the Jaguar is on
     * 
     */
    public void activate() {
        
            shooter_Spikezor.set(Relay.Value.kForward);
        
    }

    /*
     * Deactivate Solenoid if Jaguar is off.
     * 
     */
    public void deactivate() {
        shooter_Spikezor.set(Relay.Value.kOff);
    }


    public void initDefaultCommand() {
        setDefaultCommand(new InjectionCommand());
    }   

}
