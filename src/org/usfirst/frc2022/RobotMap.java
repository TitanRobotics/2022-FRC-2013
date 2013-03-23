package org.usfirst.frc2022;

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
    // public static final int rangefinderPort = 1;0
    // public static final int rangefinderModule = 1;
    //public static final LiveWindow liveWindow = new LiveWindow();
    /**
     * PWM Port Numbers for the Digital Sidecar Used for Jaguars, Victors,
     * Talons, and Servos
     */
    // Jaguars
    // IN USE
    //PWM
    private static final int jagUpperLeft = 1;
    private static final int jagLowerLeft = 2;
    private static final int jagUpperRight = 3;
    private static final int jagLowerRight = 4;
    public static final int[] portsJaguar = {jagUpperLeft, jagUpperRight, jagLowerLeft, jagLowerRight};
    
    
    //PWM
    public static final int rotate_motor = 5;
    public static final int pitch_motor = 6;
    public static final int shooterJaguarslow = 7; //Should be run at 100
    public static final int shooterJaguarfast = 8;
    public static final int shooterVictorPort = 9;
    
    
    //*
    public static final int handlingsolenoid = 10;
    //*/
    
    //Sync group for CAN Jaguars
    public static final byte syncGroup = 0;
    
    
    
    // Analog Sensors (Cherry, Ultrasound, etc.)
    public static final int cherry_rotate = 1;
    public static final int cherry_pitch = 2;
    
    //Cherry Rotation Calibration
    public static final int cherry_rotate_minVolt = 0;
    public static final int cherry_rotate_maxVolt = 1;
    public static final int cherry_rotate_minAng = 0;
    public static final int cherry_rotate_maxAng = 1;
    
    //Cherry Pitch Calibration
    public static final int cherry_pitch_minVolt = 0;
    public static final int cherry_pitch_maxVolt = 1;
    public static final int cherry_pitch_minAng = 0;
    public static final int cherry_pitch_maxAng = 1;
    
    // Digital I/O Ports (Encoders and Limit Switches)
    // IN USE
    public static final int compPressureSwitch = 1;
    public static final int compValve1 = 2;
    public static final int compValve2 = 3;
    
    // NOT IN USE
    
    //*
    public static final int[] myEncoder = {9, 10};
    public static final int[] DriveEncoder1 = {5,6};
    public static final int[] DriveEncoder2 = {7,8};
    //*/
   
    // Enumeration of Sweet Spots
    public static final int behindPyramid = 0;
    public static final int rightOfPyramid = 1;
    public static final int feederSpot = 2;
    
    
    // Digital Relay Ports (Spike Relays)
    
    // IN USE
    public static final int compRelay = 1;
    
    //*
    // NOT IN USE
    public static final int handlingSpike = 3;
    public static final int pickupPortNum = 2;
    public static final int[] pickupPorts = {5,6};
    //*/
}
