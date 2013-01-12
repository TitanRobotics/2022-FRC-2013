package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc2022.RobotMap;
import org.usfirst.frc2022.commands.Servo45;
import org.usfirst.frc2022.commands.TargetTrackerCommand;

/**
 * This subsystem is for use with the camera on Clifford. It uses two servos,
 * one for changing the camera's pitch and another for the camera's rotation. *
 */
public class CameraServos extends Subsystem {

    private Servo pitchServo;
    private Servo rotateServo;

    /**
     * Creates a new CameraServos subsystem that assumes the default digital
     * servos module using channels in the RobotMap
     *
     */
    public CameraServos() {
        pitchServo = new Servo(RobotMap.pitchServo);
        rotateServo = new Servo(RobotMap.rotateServo);
    }

    /**
     * Creates a new CameraServos subsystem that assumes the default digital
     * servos module.
     *
     * @param pitchChannel - channel for the pitch servo
     * @param rotateChannel - channel for the rotate servo
     *
     */
    public CameraServos(int pitchChannel, int rotateChannel) {
        pitchServo = new Servo(pitchChannel);
        rotateServo = new Servo(rotateChannel);
    }

    /**
     * Creates a new CameraServos subsystem that specifies the digital servo
     * module.
     *
     * @param pitchSlot - slot for the pitch servo
     * @param pitchChannel - channel for the pitch servo
     * @param rotateSlot - slot for the rotate servo
     * @param rotateChannel - channel for the rotate servo
     *
     */
    public CameraServos(int pitchSlot, int pitchChannel, int rotateSlot, int rotateChannel) {
        pitchServo = new Servo(pitchSlot, pitchChannel);
        rotateServo = new Servo(rotateSlot, rotateChannel);
        /*setupLiveWindow();
         LiveWindow.setEnabled(true);
         LiveWindow.run();*/

    }

    /**
     * Sets the angle for the pitch servo
     *
     * @param angle - angle to pitch
     *
     */
    public void setPitchAngle(double angle) {
        angle = angle / 90.0;
        if (angle >= .95) {
            angle = .95;
        } else if (angle <= 0.05) {
            angle = 0.05;
        }
        pitchServo.set(angle);
        //System.out.println(angle);
    }

    /**
     * Sets the angle for the rotate servo
     *
     * @param angle - angle to rotate
     *
     */
    public void setRotateAngle(double angle) {

        angle = angle / 90.0;
        if (angle >= .95) {
            angle = .95;
        } else if (angle <= 0.05) {
            angle = 0.05;
        }
        rotateServo.set(angle);
        //System.out.println(angle);
    }

    /**
     * Gives the angle for the pitch servo
     *
     * @return getAngle() - angle of the pitch servo
     *
     */
    public double getPitchAngle() {
        return pitchServo.get()*90;
    }

    /**
     * Gives the angle for the rotate servo
     *
     * @return getAngle() - angle of the rotate servo
     *
     */
    public double getRotateAngle() {
        return rotateServo.get()*90;
    }

    public void updateSD() {
        SmartDashboard.putNumber("Camera rotation", this.getRotateAngle());
        SmartDashboard.putNumber("Camera pitch", this.getPitchAngle());
    }

    public void setupLiveWindow() {
        LiveWindow.addActuator("CameraServos", "Pitch Servo", pitchServo);
        LiveWindow.addActuator("CameraServos", "Rotate Servo", rotateServo);
    }

    /**
     * Default command for the CameraServos subsystem
     */
    protected void initDefaultCommand() {
        //setDefaultCommand(new Servo45());
        setDefaultCommand(new TargetTrackerCommand());
    }
}
