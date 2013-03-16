package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2022.RobotMap;
import org.usfirst.frc2022.Utils;
import org.usfirst.frc2022.commands.ShooterCommand;


/**
 * This code is used to control the speed of Jaguars controlling the shooter for
 * picking up Frisbees. The slow Jaguar is 0.1 less than the fast Jaguar.
 * Everything is now in manual control, not PID more. Note: names with "_" are from the
 * program, no "_" are from RobotMap
 *
 * @author Emma Sloan, Malachi Loviska
 */
public class Shooter extends Subsystem {

    Jaguar shooter_Jaguar_fast;
    Jaguar shooter_Jaguar_slow;

    /**
     * Constructs the Jaguars and assigns ports from robot
     * map.
     */
    public Shooter() {

        shooter_Jaguar_fast = new Jaguar(RobotMap.shooterJaguarfast);
        shooter_Jaguar_slow = new Jaguar(RobotMap.shooterJaguarslow);

        //TODO: Set DistancePerPulse() for the Encoder!!!
        
        //shooter_Endcoder.start();
    }
    
    public double getJagSpeed(){ //Gives the speed of the FAST jaguar: the slow one is 0.1 less
        return shooter_Jaguar_fast.get(); 
   }

          ///////////////////// PID Functions /////////////////////////
    
    
    /*
     *
     * We are no longer actually using any of these PID functions: they're all being kept
     * for legacy.
     * 
     * Get the value to be used for the PID Input
     * 
     * @return the rotation speed of encoder for use of Jaguar
     
    protected double returnPIDInput() {
        return shooter_Endcoder.getRate();

    }

    /**
     *
     * Using the output from encoder to give to change the acceleration of the
     * Jaguar
     *
     * @retun encoder values to jaguar between 1 and -1
     
    protected void usePIDOutput(double output) {

        double shoot = Utils.clamp(shooter_Jaguar.get(), 1, -1);
        shooter_Jaguar.set(output + shoot);

    }
    
    /**
     * Set state of PID Loop
     * 
     * @param pid Whether to enable PID loop or not
     *
    
    public void usePID(boolean pid) {
        if(pid) {
            this.enable();
        }
        else {
            this.disable();
        }
    }
    
    ///////////////////// Manual Functions /////////////////////////
    
    /**
     * 
     * Used for Manual control of the shooter.
     * We are using this now, not any of the PID stuff!
     * 
     * @param percent Value -1 to 1 for speed of the shooter.
     */
    public void setShooter(double percent) {
        shooter_Jaguar_fast.set(Utils.clamp(percent, 1, 0));
        shooter_Jaguar_slow.set(Utils.clamp(percent-0.1, 0.9, 0));
    }
    
    public void stop(){
        shooter_Jaguar_fast.set(0);
        shooter_Jaguar_slow.set(0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ShooterCommand());
    }   

}
