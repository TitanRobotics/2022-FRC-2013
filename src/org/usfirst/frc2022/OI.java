package org.usfirst.frc2022;

import org.usfirst.frc2022.Joysticks.Xbox360;
import org.usfirst.frc2022.commands.TargetTrackerCommand;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    // Process operator interface input here.
        private Xbox360 xbawks;
	private JoystickButton xButton;
	public OI(){
		xbawks = new Xbox360(1);
		xButton = xbawks.GetXButton();
		xButton.whileHeld(new TargetTrackerCommand());
	}

    public Xbox360 getXbawks() {
        return xbawks;
    }
        
}
