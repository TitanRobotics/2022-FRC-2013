package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;

public class CameraServos extends Subsystem {
	
	private Servo pitchServo;
	private Servo rotateServo;
	
	public CameraServos(int pitchChannel, int rotateChannel){
		pitchServo = new Servo(pitchChannel);
		rotateServo = new Servo(rotateChannel);		
	}
	
	public CameraServos(int pitchSlot, int pitchChannel, int rotateSlot, int rotateChannel){
		pitchServo = new Servo(pitchSlot, pitchChannel);
		rotateServo = new Servo(rotateSlot, rotateChannel);
		
	}
	
	public void setPitchAngle(double angle){
		pitchServo.setAngle(angle);
	}
	
	public void setRotateAngle(double angle){
		rotateServo.setAngle(angle);
	}
	
	public double getPitchAngle(){
		return pitchServo.getAngle();
	}
	
	public double getRotateAngle(){
		return rotateServo.getAngle();
	}
	
	protected void initDefaultCommand() {
		
	}

}
