package org.usfirst.frc2022.subsystems;

import org.usfirst.frc2022.RobotMap;

import com.sun.squawk.util.Arrays;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
public class Sensors extends Subsystem {

	Gyro gyro;
	Ultrasonic ultrasonic;
	Encoder[] encoders;
	
	void Initialize(int[] encoderPorts, int usaport,int usbport)
	{
		ultrasonic=new Ultrasonic(usaport, usbport);
	   gyro = new Gyro(RobotMap.gyroPort);
	   encoders = new Encoder[encoderPorts.length/2];
	   for(int i=0; i<encoders.length;i+=1){
		   encoders[i]=new Encoder(encoderPorts[i], encoderPorts[i+1]);
	   }
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	public double getGyroAngle(){
		return gyro.getAngle();
	}

}
