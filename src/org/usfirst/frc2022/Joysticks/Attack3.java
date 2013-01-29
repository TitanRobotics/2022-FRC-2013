package org.usfirst.frc2022.Joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Class designed to interface with an Attack3 joystick. This class was designed
 * to allow better definition of the joysticks in the source code of a program
 * since now the class would be named with the joystick type.
 *
 * This class uses the Joystick class to interface with the Drivers Station to
 * get the input from the joystick.
 *
 * Note: Port of Attack3.ccp
 */
public class Attack3 extends Joystick {
   
    /**
     * Construct an instance of a Logitech Attack3 joystick (The kind in the
     * KoP).
     *Initialize Button6 and Button 7 for controlling  the pickup relays
     * @param port The port on the driver station that the joystick is plugged
     * into.
     * @return
     */
    
   
    
    
    
    
    public Attack3(int port) {

        super(port);

    } //End public Attack3(int port)

    /**
     * Return the value of the Twist axis for this joystick This value is always
     * 0 since there is no twist axis.
     *
     * @param
     * @return 0 since there is no twist axis
     */
    public float GetTwist() {

        return (0);	//Return 0 since there is no twist axis

    }//End float GetTwist()

    /**
     * Return the value of the Z axis for this joystick This value is always 0
     * since there is no Z axis.
     *
     * @param
     * @return 0 since there is no Z axis
     */
   public float GetZ() {

        return (0);	//Return 0 since there is no Z axis

    }//End float GetZ()

    /**
     * Get the X value of the joystick. The right side of the axis is positive.
     *
     * @param
     * @return The current X value of the joystick between -1 and 1
     */
    public float GetX() {

        return (float) (this.getX());

    }//End float GetX()

    /**
     * Get the Y value of the joystick. The forward part of the axis is
     * negative.
     *
     * @param
     * @return The current Y value of the joystick between -1 and 1
     */
    public float GetY() {

        return (float) (this.getY());

    }//End float GetY()

    /**
     * Get the Throttle value of the joystick. The top part of the axis is
     * negative.
     *
     * @param
     * @return The current Throttle value of the joystick between -1 and 1
     */
    public float GetThrottle() {

        return (float) (this.getThrottle());

    } //End float GetThrottle()

    /**
     * Get a JoystickButton for the Command Subsystem OI Class
     *
     * @param button The button as an integer
     * @return JoystickButton
     */
    
    
    /**
     * Get the current state of the  button7.
     *
     * @param
     * @return The current state of the button
     */
    
    
    JoystickButton GetButton(int button) {

        return (new JoystickButton(this, button));

    } //End float GetButton(int Button)
  
}
