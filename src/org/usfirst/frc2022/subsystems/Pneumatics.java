/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Michael
 */
public class Pneumatics extends Subsystem{

    private Compressor compressor;
    private Solenoid openValve;
    private Solenoid closeValve;
    
    public Pneumatics(int pressureSwitchSlot, int pressureSwitchChannel, int compresssorRelaySlot, int compressorRelayChannel, int solenoidChannelOpenValve, int solenoidChannelCloseValve){
        compressor = new Compressor(pressureSwitchSlot,pressureSwitchChannel,compresssorRelaySlot,compressorRelayChannel);
        openValve = new Solenoid(solenoidChannelOpenValve);
        closeValve = new Solenoid(solenoidChannelCloseValve);
    }
    
    public Pneumatics(int pressureSwitchChannel, int compressorRelayChannel, int solenoidChannelOpenValve, int solenoidChannelCloseValve){
        compressor = new Compressor(pressureSwitchChannel,compressorRelayChannel);
        openValve = new Solenoid(solenoidChannelOpenValve);
        closeValve = new Solenoid(solenoidChannelCloseValve);
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
        openValve.set(true);
        closeValve.set(false);
    }
    
    public void valveClose(){
        closeValve.set(true);
        openValve.set(false);
    }
    
    public void disableValvesOperation(){
        openValve.set(false);
        closeValve.set(false);
    }
    
}
