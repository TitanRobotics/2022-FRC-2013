package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.Jaguar;

public interface Drive_Generic {

    /**
     * Set the speed of the motors on the left side of the robot.
     *
     * @param speed The speed at which the motors move
     * @returns
     */
    void setLeft(double speed);

    /**
     * Set the speed of the motors on the right side of the robot.
     *
     * @param speed The speed at which the motors move
     * @returns
     */
    void setRight(double speed);

    /**
     * Move the robot. Only go forward and back.
     *
     * @param speed The speed of the motors
     * @returns
     */
    void drive(double speed);

    /**
     * Move the robot. Each side can have a different speed to allow for
     * turning.
     *
     * @param speedLeft The speed of the left motors
     * @param speedRight The speed of the right motors
     * @returns
     */
    void drive(double speedLeft, double speedRight);

    /**
     * Halt the motors
     *
     * @param
     * @return
     */
    void stop();

    /**
     * Function that checks if a number is even. Specifically used for checking
     * the size of arrays.
     *
     * @param size
     * @return whether or not the number passed through is even
     */
    boolean checkEven(int size);

    /**
     * Separate the jaguars to left and right sides (odds left, evens right)
     *
     * @param jags
     * @return
     */
    void seperateJags(Jaguar[] jags);

    /**
     * Flips the jaguars on each side; then switches the sides
     *
     * @param
     * @return
     */
    void flipJags();
}
