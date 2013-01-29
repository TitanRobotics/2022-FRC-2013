package org.usfirst.frc2022.sensors;

import edu.wpi.first.wpilibj.*;
//PWH

/**
 * This is for making the Maxbotix Ultrasound stuff work! It's good.
 */
public class MaxbotixUltrasonic extends SensorBase {

    AnalogChannel channel;

    /**
     * Maxbotix Ultrasonic. Create it. Good. Now use it.
     */
    public MaxbotixUltrasonic(int channel) {
        this.channel = new AnalogChannel(channel);
    }

    // Just get the voltage.
    /**
     * Get the raw voltage from the sensor. If you're using this, you're doing
     * it wrong.
     */
    double GetVoltage() {
        return channel.getVoltage();
    }

    /**
     * Get the distance!!! Use this!
     */
    double GetDistance() {
        return GetVoltage() * 106.23 + 0.3793;
    }
}