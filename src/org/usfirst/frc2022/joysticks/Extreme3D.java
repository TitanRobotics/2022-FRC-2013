package org.usfirst.frc2022.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Interfaces with an Extreme3D joystick. This class was designed to
 * allow better definition of the joysticks in the source code of a 
 * program since the class will be named with the joystick type and
 * the function calls will return what is expect.
 * 
 * The Joystick class is an interface with the Drivers Station
 * to get the input from the joystick.
 * 
 * @param port	The joystick's port
 */
public class Extreme3D extends Joystick{
	
	/**
	 * Construct an instance of a Logitech Extreme3D joystick.
	 * 
	 * @param port The port on the driver station that the joystick is plugged into.
	 * @return
	 */
	public Extreme3D(int port)	{
		super(port);
	}
	
	/**
	 * Get the value of the Twist for the joystick.
	 * The right side of the axis is positive.
	 * 
	 * @param
	 * @return The current twist value between -1 and 1
	 */
	public float GetTwist()	{
		return (float) this.getZ();	//The twist axis maps to the Z axis on this joystick
	}

	/**
	 * Get the X value of the joystick.
	 * The right side of the axis is positive.
	 * 
	 * @param
	 * @return The current X value of the joystick between -1 and 1
	 */
	public float GetX()	{
		return (float) (this.getX());
	}
	
	/**
	 * Get the Y value of the joystick.
	 * The forward part of the axis is negative.
	 * 
	 * @param
	 * @return The current Y value of the joystick between -1 and 1
	 */
	public float GetY()	{
		return (float) (this.getY());
	}
	
	/**
	 * Get the Throttle value of the joystick.
	 * The top part of the axis is negative.
	 * 
	 * @param
	 * @return The current Throttle value of the joystick between -1 and 1
	 */
	public float GetThrottle()
	{
		return (float) (this.getTwist());	//The twist axis maps to the throttle on this joystick
	}
	
	/**
	 * Get a JoystickButton for the Command Subsystem OI Class
	 * 
	 * @param button	Button as an integer
	 * @return JoystickButton object
	 */
	public JoystickButton GetButton(int button)
	{
		return(new JoystickButton(this, button));
	}
}
