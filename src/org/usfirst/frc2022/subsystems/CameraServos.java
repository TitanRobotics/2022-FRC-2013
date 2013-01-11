package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;
import org.usfirst.frc2022.RobotMap;
import org.usfirst.frc2022.commands.Servo45;
import org.usfirst.frc2022.commands.TargetTrackerCommand;

/**
 * This subsystem is for use with the camera on Clifford. It uses two
 * servos, one for changing the camera's pitch and another for the 
 * camera's rotation. *
 */

public class CameraServos extends Subsystem {
	
	private Servo pitchServo;
	private Servo rotateServo;
	
	/**
	 * Creates a new CameraServos subsystem that assumes the default
	 * digital servos module using channels in the RobotMap
	 * 
	 */
	public CameraServos(){
		pitchServo = new Servo(RobotMap.pitchServo);
		rotateServo = new Servo(RobotMap.rotateServo);		
	}
	
	/**
	 * Creates a new CameraServos subsystem that assumes the default
	 * digital servos module.
	 * 
	 * @param pitchChannel - channel for the pitch servo
	 * @param rotateChannel - channel for the rotate servo
	 * 
	 */
	public CameraServos(int pitchChannel, int rotateChannel){
		pitchServo = new Servo(pitchChannel);
		rotateServo = new Servo(rotateChannel);		
	}
	
	/**
	 * Creates a new CameraServos subsystem that specifies the 
	 * digital servo module.
	 * 
	 * @param pitchSlot - slot for the pitch servo
	 * @param pitchChannel - channel for the pitch servo
	 * @param rotateSlot - slot for the rotate servo
	 * @param rotateChannel - channel for the rotate servo
	 * 
	 */
	public CameraServos(int pitchSlot, int pitchChannel, int rotateSlot, int rotateChannel){
		pitchServo = new Servo(pitchSlot, pitchChannel);
		rotateServo = new Servo(rotateSlot, rotateChannel);
		
	}
	
	/**
	 * Sets the angle for the pitch servo
	 * 
	 * @param angle - angle to pitch
	 * 
	 */
	public void setPitchAngle(double angle){
		if(angle > 90.0){
			angle = 90.0;
		}
		else if(angle < 0.0){
			angle = 0.0;
		}
		pitchServo.setAngle(angle);
		System.out.print(angle);
	}
	
	/**
	 * Sets the angle for the rotate servo
	 * 
	 * @param angle - angle to rotate
	 * 
	 */
	public void setRotateAngle(double angle){
		if(angle > 90.0){
			angle = 90.0;
		}
		else if(angle < 0.0){
			angle = 0.0;
		}
		rotateServo.setAngle(angle);
		System.out.print(angle);
	}
	
	/**
	 * Gives the angle for the pitch servo
	 * 
	 * @return getAngle() - angle of the pitch servo
	 * 
	 */
	public double getPitchAngle(){
		return pitchServo.getAngle();
	}
	
	/**
	 * Gives the angle for the rotate servo
	 * 
	 * @return getAngle() - angle of the rotate servo
	 * 
	 */
	public double getRotateAngle(){
		return rotateServo.getAngle();
	}
	
	public void updateSD(){
		SmartDashboard.putDouble("Camera rotation", this.getRotateAngle());
		SmartDashboard.putDouble("Camera pitch", this.getPitchAngle());
	}
	
	/**
	 * Default command for the CameraServos subsystem
	 */
	protected void initDefaultCommand() {
		setDefaultCommand(new Servo45());
	}

}
