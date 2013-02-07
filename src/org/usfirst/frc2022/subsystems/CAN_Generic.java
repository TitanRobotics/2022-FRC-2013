package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2022.Utils;
import org.usfirst.frc2022.commands.MecanumCommand;
import org.usfirst.frc2022.RobotMap;

/**
 *
 * Generic CAN subsystem used for the drivebase.
 *
 * @author Titan Robotics (2022)
 * @author Emma Sloan
 *
 */
public class CAN_Generic extends Subsystem implements Drive_Generic {

    CANJaguar[] jags; 		//Array of a variable size that holds the jaguars
    CANJaguar[] jagsLeft;	//jaguars on the left side of the robot
    CANJaguar[] jagsRight; 	//jaguars on the right side of the robot
    int[] ports;

    /**
     * Constructor for the subsystem. Check for an even number of jaguars. If
     * there are an even number of jaguars, use them. Otherwise, tell the driver
     * to add more jaguars.
     *
     * @param jags Array of jaguars used for controlling the drivebase
     * @return
     */
    public CAN_Generic(CANJaguar[] newJags) { //Check if there are an even number of jaguars

        if (checkEven(newJags.length)) {
            this.jags = newJags;
            separateJags(this.jags);
            //assignLiveWindow();
        } else {
            System.out.println("Odd number of Jaguars");
        }
    }

    /**
     * Constructor for the subsystem. Check for an even number of ports. If
     * there are an even number of ports, create new jaguars at those ports.
     * Otherwise, tell the driver to assign an even number of ports to the
     * robot.
     *
     * @param ports Array of ints storing the ports used by the Jaguars
     * @return
     */
    public CAN_Generic() { //Check if there are an even number of jaguars
        CANJaguar[] newJags = new CANJaguar[ports.length];
        if (checkEven(ports.length)) {

            for (int i = 0; i < ports.length; i++) {
                try {
                    newJags[i] = new CANJaguar(ports[i]);
                } catch (CANTimeoutException ex) {
                    System.out.print("Could not connect to Jaguar");
                }
            }

            this.jags = newJags;
            separateJags(this.jags);
            //assignLiveWindow();
        } else {
            System.out.println("Odd number of Jaguars");
        }
    }

    /**
     * This function initiates the default command.
     *
     * @param
     * @returns
     */
    protected void initDefaultCommand() {
        setDefaultCommand(new MecanumCommand());
    }

    /**
     * Set the speed of the motors on the left side of the robot.
     *
     * @param speed The speed at which the motors move
     * @returns
     */
    public void setLeft(double speed) {
        for (int i = 0; jagsLeft.length > i; i++) {
            try {
                jagsLeft[i].setX(Utils.clamp(speed, 1, -1),RobotMap.syncGroup);
            } catch (CANTimeoutException ex) {
                System.out.println("Could not set Jaguar");
            }
        }
        try {
            CANJaguar.updateSyncGroup(RobotMap.syncGroup);
        } catch (CANTimeoutException ex) {
                System.out.println("Could not set Jaguar");
        }
    }

    /**
     * Set the speed of the motors on the right side of the robot.
     *
     * @param speed The speed at which the motors move
     * @returns
     */
    public void setRight(double speed) {
        for (int i = 0; jagsRight.length > i; i++) {
            try {
                jagsRight[i].setX(Utils.clamp(-speed, 1, -1),RobotMap.syncGroup);
            } catch (CANTimeoutException ex) {
                System.out.println("Could not set Jaguar");
            }
        }
        try {  
            CANJaguar.updateSyncGroup(RobotMap.syncGroup);
        } catch (CANTimeoutException ex) {
                System.out.println("Could not set Jaguar");
        }
    }

    /**
     * Set the speed of all the motors. Only allows for forward and backward
     * movement.
     *
     * @param speed The speed of the motors
     * @returns
     */
    public void drive(double speed) {
        setRight(speed);
        setLeft(-speed);
    }

    /**
     * Set the speed of the motors. Each side can be set to a different speed.
     * Useful for a tank drive.
     *
     * @param speedLeft The speed of the left motors
     * @param speedRight The speed of the right motors
     * @returns
     */
    public void drive(double speedLeft, double speedRight) {
        setRight(speedRight);
        setLeft(speedLeft);
    }

    /**
     * Designed for use in mecanum drives. Set the speed for each motor. Must
     * have exactly 4 motors.
     *
     * @param speedLeftFront Speed of the front left wheel
     * @param speedRightFront Speed of the front right wheel
     * @param speedLeftBack Speed of the back left wheel
     * @param speedRightBack Speed of the back right wheel
     * @return
     */
    public void driveMecanum(double speedLeftFront, double speedRightFront, double speedLeftBack, double speedRightBack) {
        try {
            jagsLeft[0].setX(speedLeftFront, RobotMap.syncGroup);
            jagsLeft[1].setX(speedLeftBack, RobotMap.syncGroup);
            jagsRight[0].setX(speedRightFront, RobotMap.syncGroup);
            jagsRight[1].setX(speedRightBack, RobotMap.syncGroup);
        } catch (CANTimeoutException ex) {
                System.out.println("Could not set Jaguars");
        }
        try {
            CANJaguar.updateSyncGroup(RobotMap.syncGroup);
        } catch (CANTimeoutException ex) {
                System.out.println("Could not set Jaguar");
        }
    }

    /**
     * Force the motors to stop.
     *
     * @param
     * @return
     */
    public void stop() {
        setRight(0);
        setLeft(0);
    }

    /**
     * Function that checks if a number is even. Specifically used for checking
     * the size of arrays.
     *
     * @param size
     * @return whether or not the number passed through is even
     */
    public boolean checkEven(int size) {
        if ((size % 2) == 1) {
            return false;
        } else {
            return true;
        }
    } //end private boolean checkEven(int size)

    /**
     * Separate the jaguars to left and right sides with odd numbered jaguars
     * being assigned to the left and even jaguars assigned on the right.
     *
     * @param jags
     * @return
     */
    public void separateJags(CANJaguar[] jags) {
        jagsLeft = new CANJaguar[jags.length / 2];
        jagsRight = new CANJaguar[jags.length / 2];
        for (int i = 0, j = 0, k = 0; i < jags.length; i++) {
            if (checkEven(ports[i])) {
                jagsRight[j] = jags[i];
                j++;
            } else if (!checkEven(ports[i])) {
                jagsLeft[k] = jags[i];
                k++;
            }
        }
    }

    /**
     * Allows the front of the robot to become the back by switching the
     * jaguars. Useful for tank drives.
     *
     * @param
     * @return
     */
    public void flipJags() {

        int length = jagsLeft.length / 2;
        CANJaguar[] tempJags;

        for (int i = 0; i < length; i++) {
            CANJaguar temp = jagsLeft[i];
            jagsLeft[i] = jagsLeft[length - 1 - i];
            jagsLeft[length - 1 - i] = temp;
        }

        for (int i = 0; i < length; i++) {
            CANJaguar temp = jagsRight[i];
            jagsRight[i] = jagsRight[length - 1 - i];
            jagsRight[length - 1 - i] = temp;
        }

        tempJags = jagsRight;
        jagsRight = jagsLeft;
        jagsLeft = tempJags;

        //  Does not work
        //assignLiveWindow();
    }
}