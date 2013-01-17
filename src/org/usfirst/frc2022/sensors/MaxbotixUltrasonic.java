package org.usfirst.frc2022.sensors;
 
import edu.wpi.first.wpilibj.*;
//PWH
//Voltage * 106.23+0.3793
public class MaxbotixUltrasonic extends SensorBase {
 AnalogChannel channel;
   
    
    public MaxbotixUltrasonic(int channel){
    	this.channel=new AnalogChannel(channel);
    }
    
    // Just get the voltage.
    double GetVoltage() {
        return channel.getVoltage();
    }
    double GetDistance(){
    	return GetVoltage()*106.23+0.3793;
    }
}