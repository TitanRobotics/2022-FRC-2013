package org.usfirst.frc2022;

public class Utils {

    /**
     * Clamp a number to prevent setting speeds over the maximum or minimum
     *
     * @param num
     * @param max
     * @param min
     * @return
     */
    public static double clamp(double num, double max, double min) {
        if (num < min) {
            return min;
        } else if (num > max) {
            return max;
        } else {
            return num;
        }
    }//end private double clamp(double num, double max, double min)

    /**
     *
     * @author prosa
     * @param value
     * @param max The max value to be outputed. Calculated after the sensitivity multiplyer.
     * @param deadzone All values with magnitude less then this are 0.
     * @param sensitiviy Multiply the value by this.
     * @return newly mapped value
     */
    public static double controllerMath(double value, double max, double deadzone, double sensitiviy) {
        if (value * sign(value) < deadzone) {
            return 0;
        }
        return clamp(value * sensitiviy, max, -max);
    }

    public static double sign(double value) {
        if (value > 0) {
            return 1;
        }
        if (value < 0) {
            return -1;
        }
        return 0;
    }

    public static double abs(double value) {
        if (value < 0) {
            return -value;
        }
        return value;
    }
}
