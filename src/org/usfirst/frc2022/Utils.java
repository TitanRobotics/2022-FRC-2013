package org.usfirst.frc2022;

import org.usfirst.frc2022.subsystems.PWM_Generic;
//pwh
public class Utils {

        /**
	 * Clamp a number to prevent setting speeds over the maximum or minimum
	 * 
	 * @param num
	 * @param max
	 * @param min
	 * @return
	 */
	public static double clamp(double num, double max, double min){
		if(num < min){return min;}else if(num > max){return max;}else{return num;}
	}//end private double clamp(double num, double max, double min)
    
	public static double sign(double value){
		if(value > 0)
			return 1;
		if(value < 0)
			return -1;
		return 0;
	}

        //pwh
    public static void MecanumDrive(PWM_Generic pwmGeneric, double direction, double magnitude, double rotation) {
        if (magnitude < 0.2) {
            magnitude = 0;
        }
        if ((Math.abs(rotation) * 3) < 0.2) {
            rotation = 0;
        }
        double cosD = Math.cos((direction + 45.0) * Math.PI / 180.0);
        double sinD = Math.cos((direction - 45.0) * Math.PI / 180.0);
        double speedLeftFront = Utils.clamp((sinD * magnitude + rotation) * 2, 1, -1);
        double speedLeftBack = Utils.clamp((cosD * magnitude + rotation) * 2, 1, -1);
        double speedRightFront = Utils.clamp((cosD * magnitude - rotation) * 2, 1, -1);
        double speedRightBack = Utils.clamp((sinD * magnitude - rotation) * 2, 1, -1);
        pwmGeneric.driveMecanum(-speedLeftFront, -speedRightFront, speedLeftBack, speedRightBack);
    }

}
