package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

    Jaguar shooter_Jaguar_fast_left;
    Jaguar shooter_Jaguar_slow_left;
    Jaguar shooter_Jaguar_fast_right;
    Jaguar shooter_Jaguar_slow_right;
    boolean on;

    /**
     * Constructs the Jaguars and assigns ports from robot
     * map.
     */
    public Shooter() {

        shooter_Jaguar_fast_left = new Jaguar(RobotMap.shooterJaguarfastLeft);
        shooter_Jaguar_slow_left = new Jaguar(RobotMap.shooterJaguarslowLeft);
        shooter_Jaguar_fast_right = new Jaguar(RobotMap.shooterJaguarfastRight);
        shooter_Jaguar_slow_right = new Jaguar(RobotMap.shooterJaguarslowRight);
        on = false;
        SmartDashboard.putNumber("Speed",5);
        //TODO: Set DistancePerPulse() for the Encoder!!!
        
        //shooter_Endcoder.start();
    }
    
    public double getJagSpeedLeft(){ //Gives the speed of the FAST jaguar: the slow one is 0.1 less
        return shooter_Jaguar_slow_left.get(); 
   }
    
    public double getJagSpeedRight(){ //Gives the speed of the FAST jaguar: the slow one is 0.1 less
        return shooter_Jaguar_slow_right.get(); 
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
        double slowSpeed = percent;
        double fastSpeed = 0;
        if(percent > 0) {
            fastSpeed = 1;
        }
        SmartDashboard.putNumber("Slow Shoter", slowSpeed);
        SmartDashboard.putNumber("Fast Shooter", fastSpeed);
        double tmp= SmartDashboard.getNumber("Speed");
        SmartDashboard.putNumber("Tmp", tmp);
        shooter_Jaguar_fast_left.set(-fastSpeed);
        shooter_Jaguar_slow_left.set(-Utils.clamp(slowSpeed, 0.9, 0));
        shooter_Jaguar_fast_right.set(-fastSpeed);
        shooter_Jaguar_slow_right.set(-Utils.clamp(slowSpeed, 0.9, 0));
        on = true;
    }
    
    /**
     * 
     * Used for Manual control of the shooter.
     * We are using this now, not any of the PID stuff!
     * 
     * @param percent Value -1 to 1 for speed of the shooter.
     */
    public void setShooter(double percentLeft, double percentRight) {
        double slowSpeedL = percentLeft;
        double slowSpeedR = percentRight;
        double fastSpeed = 0;
        if((percentLeft > 0)&&(percentRight > 0)) {
            fastSpeed = 1;
        }
        SmartDashboard.putNumber("Left Shoot", slowSpeedL);
        SmartDashboard.putNumber("right Shoot", slowSpeedR);
        double tmp= SmartDashboard.getNumber("Speed");
        SmartDashboard.putNumber("Tmp", tmp);
        shooter_Jaguar_fast_left.set(-fastSpeed);
        shooter_Jaguar_slow_left.set(-Utils.clamp(slowSpeedL, 0.9, 0));
        shooter_Jaguar_fast_right.set(-fastSpeed);
        shooter_Jaguar_slow_right.set(-Utils.clamp(slowSpeedR, 0.9, 0));
        on = true;
    }
    
    public boolean isOn(){
        return on;
    }
    
    public void stop(){
        shooter_Jaguar_fast_left.set(0);
        shooter_Jaguar_slow_left.set(0);
        shooter_Jaguar_fast_right.set(0);
        shooter_Jaguar_slow_right.set(0);
        on = false;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ShooterCommand());
    }   

}
