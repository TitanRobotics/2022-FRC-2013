/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Joysticks.Xbox360;
import org.usfirst.frc2022.commands.CommandBase;

/**
 *
 * @author Michael
 */
public class PneumaticsCommand extends CommandBase{

    private Xbox360 Xbocks;
    
    protected void initialize() {
        requires(pneumatics);
        pneumatics.valveClose();
        pneumatics.disableValvesOperation();
        pneumatics.start();
        Xbocks = oi.getXbawks();
    }

    protected void execute() {
    
        /*
         * if statements to control the compressor's release of air
         */
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        pneumatics.stop();
        pneumatics.disableValvesOperation();
    }

    protected void interrupted() {
        pneumatics.stop();
        pneumatics.disableValvesOperation();
    }
    
}
