package org.usfirst.frc2022;

import org.usfirst.frc2022.Joysticks.Xbox360;
import org.usfirst.frc2022.commands.TargetTrackerCommand;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc2022.commands.Servo45;

public class OI {
    // Process operator interface input here.
        private Xbox360 xbawks;
	private JoystickButton xButton,yButton;
	public OI(){
		xbawks = new Xbox360(1);
		xButton = xbawks.GetXButton();
                yButton=xbawks.GetYButton();
                //yButton.whileHeld(new Servo45());
		//xButton.whileHeld(new TargetTrackerCommand());
                xButton.whileHeld(new Servo45());
                //new TargetTrackerCommand();
	}

    public Xbox360 getXbawks() {
        return xbawks;
    }
        
}
