/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 * @author Michael
 */
public class Pneumatics extends Subsystem{

    private Compressor compressor;
    private DoubleSolenoid valve;
        
    public Pneumatics(int pressureSwitchChannel, int compressorRelayChannel, int valveChannel1, int valveChannel2){
        compressor = new Compressor(pressureSwitchChannel,compressorRelayChannel);
        valve = new DoubleSolenoid(valveChannel1,valveChannel2);
    }
    
    protected void initDefaultCommand() {
        
    }
    
    public void start(){
        compressor.start();
    }
    
    public void stop(){
        compressor.stop();
    }
    
    public void valveOpen(){
        valve.set(DoubleSolenoid.Value.kForward);
    }
    
    public void valveClose(){
        valve.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void disableValvesOperation(){
        valve.set(DoubleSolenoid.Value.kOff);
    }
    
}
