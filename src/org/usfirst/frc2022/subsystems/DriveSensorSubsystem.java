package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2022.RobotMap;


/**
 *Subsystem created to get the distance and speed the wheels are moving in Autonomous
 * @author Malachi Loviska
 */
public class DriveSensorSubsystem extends Subsystem {

    Encoder Drive_Encoder1;
    Encoder Drive_Encoder2;
    Gyro Gyro_Sensor1;

    /*
     * Initialize  Encoders 
     */
    /**
     * Constructs the Jaguar, Encoder, and Solenoid and assigns ports from robot
     * map. It also starts the Encoder
     */
    public DriveSensorSubsystem() {



        Drive_Encoder1 = new Encoder(RobotMap.DriveEncoder1[5],
                RobotMap.DriveEncoder1[6]);
        Drive_Encoder2 = new Encoder(RobotMap.DriveEncoder2[7],
                RobotMap.DriveEncoder1[8]);
        Gyro_Sensor1.reset();




        this.init();

    }
    
    public void ResetGyro()
    {
        Gyro_Sensor1.reset();
    }
    
    public double GetGyroAngle()
    {
        return Gyro_Sensor1.getAngle();
    }
    
    public void initDefaultCommand(){
        
    }

    public void init() {

        Drive_Encoder1.setDistancePerPulse(1.0472 / 360);
        Drive_Encoder2.setDistancePerPulse(1.0472 / 360);
        Drive_Encoder1.start();
        Drive_Encoder2.start();
    }

    public void reset() {

        Drive_Encoder1.reset();
        Drive_Encoder2.reset();
    }

    public double getRightSpeed() {
        return Drive_Encoder1.getRate();

    }

    public double getLeftSpeed() {
        return Drive_Encoder2.getRate();
    }

    public double GetRightDistance() {
        return Drive_Encoder1.getDistance();
    }

    public double GetLeftDistance() {
        return Drive_Encoder2.getDistance();
    }
}
