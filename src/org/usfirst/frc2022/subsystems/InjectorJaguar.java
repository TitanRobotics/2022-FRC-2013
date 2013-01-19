
package org.usfirst.frc2022.subsystems;


import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Encoder.PIDSourceParameter;
import org.usfirst.frc2022.RobotMap;
import com.sun.squawk.util.Arrays;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc2022.Utils;

/**
 *This code is used to control the speed of Jaguars controlling the injector for
 * picking up Frisbees by taking input as the rotation speed of the encoder
 * And for output giving ability to modify speed.
 * @author Malachi
 */
public class InjectorJaguar extends PIDSubsystem {  
   
    Encoder injector_Encoder;
    Jaguar Injector_Jaguar;
     /*
     * Initialize Jaguar and Encoder
     */
    private static final double Kp = 0.1;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0; 
    
    public InjectorJaguar () {
        super("InjectorJaguar", Kp, Ki, Kd);
        
     
        Injector_Jaguar = new Jaguar(RobotMap.InjectorJaguar);
       injector_Encoder = new Encoder(RobotMap.injectorEncoder[0],
               RobotMap.injectorEncoder[1]);
       injector_Encoder.start(); 
       /*
       * Constructs the Jaguar and Encoder and assigns ports from
       * robot map. It also starts the Encoder
       */
    }
   
    
    
    public void initDefaultCommand() {
        
    }
    
    protected double returnPIDInput() {
       return injector_Encoder.getRate();
        /*
         * returns the rotation speed of encoder for use of Jaguar
         * 
         */
    }
    protected void usePIDOutput(double output) {
       
        double injector = Utils.clamp(Injector_Jaguar.getSpeed(),1,-1);
        Injector_Jaguar.set(output+injector);
 
        /**
         * 
          * Using the output from encoder to give to change 
          * the acceleration of the Jaguar
          * @retun encoder values to jaguar  between 1 and -1
          */
        Injector_Jaguar.set(output);
         /*
          * Sets output for Jaguar movement
          */
    }
}
