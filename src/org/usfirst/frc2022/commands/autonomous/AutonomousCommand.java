package org.usfirst.frc2022.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2022.commands.InjectionCommand;
import org.usfirst.frc2022.commands.ShooterCommand;
import org.usfirst.frc2022.commands.SweetSpotCommand;
import org.usfirst.frc2022.commands.BSTimeWasterCommand;
import org.usfirst.frc2022.commands.InjectionCommandAuto;
import org.usfirst.frc2022.commands.SpinupShooter;
import org.usfirst.frc2022.commands.shooterCommandAuto;

public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {


        //SweetSpot for middleshot
        /*addSequential(new SweetSpotCommand(2), 1);
        for (int i = 0; i < 3; i++) {
            addSequential(new BSTimeWasterCommand(),2);
            addSequential(new InjectionCommandAuto());
        }*/
        
        
        //Rapezor Commands
        addSequential(new SpinupShooter());
        for (int i = 0; i < 3; i++) {
            addSequential(new BSTimeWasterCommand(),1.5);
            addSequential(new InjectionCommandAuto());
        }

        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
