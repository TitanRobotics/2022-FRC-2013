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

    public static double sign(double value) {
        if (value > 0) {
            return 1;
        }
        if (value < 0) {
            return -1;
        }
        return 0;
    }
}
