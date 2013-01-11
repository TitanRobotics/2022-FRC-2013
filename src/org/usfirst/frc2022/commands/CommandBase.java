package org.usfirst.frc2022.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2022.OI;
import org.usfirst.frc2022.subsystems.CameraServos;
import org.usfirst.frc2022.subsystems.ExampleSubsystem;
import org.usfirst.frc2022.subsystems.Robocam;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 * 
 * @author Author
 */
public abstract class CommandBase extends Command {

	public static OI oi;
	// Create a single static instance of all of your subsystems
	//public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static Robocam cam = new Robocam("10.20.22.11");
	public static CameraServos camServos = new CameraServos();

	public static void init() {
		// This MUST be here. If the OI creates Commands (which it very likely
		// will), constructing it during the construction of CommandBase (from
		// which commands extend), subsystems are not guaranteed to be
		// yet. Thus, their requires() statements may grab null pointers. Bad
		// news. Don't move it.
		oi = new OI();

		// Show what command your subsystem is running on the SmartDashboard
		//SmartDashboard.putData(exampleSubsystem);
		SmartDashboard.putData(cam);
		SmartDashboard.putData(camServos);
	}

	public CommandBase(String name) {
		super(name);
	}

	public CommandBase() {
		super();
	}
}
