package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2022.RobotMap;
import org.usfirst.frc2022.commands.InjectionCommand;


/**
 * This code is used to control the speed of Jaguars controlling the shooter for
 * picking up Frisbees by taking input as the rotation speed of the encoder And
 * for output giving ability to modify speed. Note: names with "_" are from the
 * program, no "_" are from RobotMap
 *
 * @author Malachi Loviska
 */
public class Injector extends Subsystem {

    Victor injectionVictor;

    /**
     * Constructs the Jaguar, Encoder, and Solenoid and assigns ports from robot
     * map. It also starts the Encoder
     */
    public Injector() {
        injectionVictor = new Victor(RobotMap.shooterVictorPort);
    }

    boolean first = true;
    ///////////////////// Injection Functions /////////////////////////
    /*
     * Activate Solenoid if the Jaguar is on
     * 
     */
    public void activate() {
        if(first){
        SmartDashboard.putNumber("Servosuff", injectionVictor.getSpeed());
        first=false;
        }
        injectionVictor.setPosition(90.0);
        SmartDashboard.putString("Thing", "ON");
    }

    /*
     * Deactivate Solenoid if Jaguar is off.
     * 
     */
    public void deactivate() {
        //servo.get() when the servo is off is 0. so i am going to just setRaw to 0. yolo.
        injectionVictor.set(0);//Paul tested this. It works. YOLO.
        SmartDashboard.putString("Thing", "OFF");
    }

    public void initDefaultCommand() {
        // setDefaultCommand(new InjectionCommand());
    }
}
