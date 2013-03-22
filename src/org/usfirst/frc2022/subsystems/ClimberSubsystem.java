/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Paul
 */
public class ClimberSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private DoubleSolenoid valve;
    
    public ClimberSubsystem(int valveChannel1,int valveChannel2){
        valve = new DoubleSolenoid(valveChannel1,valveChannel2);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
    
    public void climbUp(){
        valve.set(DoubleSolenoid.Value.kForward);
    }
    
    public void climbDown(){
        valve.set(DoubleSolenoid.Value.kReverse);
    }
}
