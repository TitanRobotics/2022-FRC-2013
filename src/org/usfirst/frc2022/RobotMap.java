package org.usfirst.frc2022;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
	
        //public static final LiveWindow liveWindow = new LiveWindow();
        private static int jagUpperLeft = 1;
        private static int jagUpperRight = 4;
        private static int jagLowerLeft = 3;
        private static int jagLowerRight = 2;
        public static int[] portsJaguar = {jagUpperLeft,jagUpperRight,jagLowerLeft,jagLowerRight};
	public static final int rotateServo = 5;
	public static final int pitchServo = 6;
        public static final int rotate_motor = 7;
        public static final int pitch_motor = 8;
        public static final int cherry_rotate = 9;
        public static final int cherry_pitch = 10;
        public static final int shooterJaguar = 11;
        public static int[] shooterEndcoder = {12,13};       
        public static int  shooterSolenoid = 14;
        public static int handlingSolenoid = 15;
        
        
        
        
}
