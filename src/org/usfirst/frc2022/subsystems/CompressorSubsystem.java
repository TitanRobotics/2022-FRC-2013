/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Paul
 */
public class CompressorSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Compressor compressor;
    
    public CompressorSubsystem(int pressureSwitchChannel, int compressorRelayChannel){
        compressor = new Compressor(pressureSwitchChannel,compressorRelayChannel);
        compressor.start();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
