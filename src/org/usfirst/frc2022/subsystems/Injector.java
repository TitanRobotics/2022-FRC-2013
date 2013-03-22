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

    Servo shooter_servo;
    
    /**
     * Constructs the Jaguar, Encoder, and Solenoid and assigns ports from robot
     * map. It also starts the Encoder
     */
    public Injector() {
        shooter_servo = new Servo(RobotMap.shooterServo);
    }
    
    
    ///////////////////// Injection Functions /////////////////////////
    /*
     * Activate Solenoid if the Jaguar is on
     * 
     */
    public void activate(double value) {
        
            shooter_servo.set(Utils.clamp(value, 1.0, -1.0));
        
    }

    /*
     * Deactivate Solenoid if Jaguar is off.
     * 
     */
    public void deactivate() {
        shooter_servo.set(0.0);
    }


    public void initDefaultCommand() {
        setDefaultCommand(new InjectionCommand());
    }   

}
