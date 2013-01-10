package org.usfirst.frc2022.sensors;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDSource;

import com.sun.squawk.util.MathUtils;
import java.lang.Math;

/**
* Functions for interfacing with the Cherry AN8 Magnetic Position sensors.
* All functions are accessible using the CherryAN8 class
* 
* @param channel - The PWM channel on the default module where the sensor is connected (minimum)
*/
public class CherryAN8 implements PIDSource{
	
	private AnalogChannel sensor;			//Sensor object used to interact with the hardware of the CRIO
	private double offset;
	private double minVoltage;
	private double maxVoltage;
	private double voltsPerRadian;
	
	/**
	 * Constructor for a Cherry AN8 Magnetic Position Sensor
	 * 
	 * This constructor assumes the minimum voltage possible is .5 volts, and the max voltage possible is 4.5 volts
	 * If that is not the case then call setMinVoltage() and setMaxVoltage() to change those values
	 * 
	 * This constructor also believes that the offset for the sensor is 0, if that is not the case then call the other constructor.
	 * 
	 * @param channel - The PWM channel on the default module where the sensor is connected
	 */
	public CherryAN8(int channel){
		this.sensor = new AnalogChannel(channel);
		this.setOffset(0, true);
		
		this.minVoltage = 0.5;
		this.maxVoltage = 4.5;
		this.computeVoltsPerRadian();
		
	}
	
	/**
	 * Constructor for a Cherry AN8 Magnetic Position Sensor
	 * 
	 * This constructor assumes the minimum voltage possible is .5 volts, and the max voltage possible is 4.5 volts
	 * If that is not the case then call setMinVoltage() and setMaxVoltage() to change those values
	 * 
	 * @param channel - The PWM channel on the default module where the sensor is connected
	 * @param offset - The angle the sensor is off from 0, can be anywhere between PI and -PI if  in Radians 180 and -180 if in degrees
	 * @param offsetIsRadians - Boolean value saying if the offset parameter is in radians
	 */
	public CherryAN8(int channel, double offset, boolean offsetIsRadians){
		this.sensor = new AnalogChannel(channel);
		this.setOffset(offset, offsetIsRadians);
		
		this.minVoltage = 0.5;
		this.maxVoltage = 4.5;
		this.computeVoltsPerRadian();
	}
	
	/**
	 * Constructor for a Cherry AN8 Magnetic Position Sensor
	 * 
	 * This constructor assumes the minimum voltage possible is .5 volts, and the max voltage possible is 4.5 volts
	 * If that is not the case then call setMinVoltage() and setMaxVoltage() to change those values
	 * 
	 * This constructor also believes that the offset for the sensor is 0, if that is not the case then call the other constructor
	 * 
	 * @param slot - The slot in the CRIO where the analog module is placed
	 * @param channel - The PWM channel on the module where the sensor is connected
	 */
	public CherryAN8(int slot, int channel){
		this.sensor = new AnalogChannel(slot, channel);
		this.setOffset(0, true);
		
		this.minVoltage = 0.5;
		this.maxVoltage = 4.5;
		this.computeVoltsPerRadian();
	}
	
	/**
	 * Constructor for a Cherry AN8 Magnetic Position Sensor
	 * 
	 * This constructor assumes the minimum voltage possible is .5 volts, and the max voltage possible is 4.5 volts
	 * If that is not the case then call setMinVoltage() and setMaxVoltage() to change those values
	 * 
	 * @param slot - The slot in the CRIO where the analog module is placed
	 * @param channel - The PWM channel on the module where the sensor is connected
	 * @param offset - The angle the sensor is off from 0, can be anywhere between PI and -PI if  in Radians 180 and -180 if in degrees
	 * @param offsetIsRadians - Boolean value saying if the offset parameter is in radians
	 */
	public CherryAN8(int slot, int channel, double offset, boolean offsetIsRadians){
		this.sensor = new AnalogChannel(slot, channel);
		this.setOffset(offset, offsetIsRadians);
		
		this.minVoltage = 0.5;
		this.maxVoltage = 4.5;
		this.computeVoltsPerRadian();
	}
	
	/**
	 * Function setting the offset angle of the sensor
	 * 
	 * @param offset - a value representing the offset of the sensor, can be readians or degrees (set boolean accordingly)
	 * @param isRadians - a boolean value saying whether the inputed value is radians or degrees
	 */
	public void setOffset(double offset, boolean isRadians){
		if(isRadians){
			this.offset = offset;
		}
		else{
			this.offset = (offset * (Math.PI/180));
		}
	}
	
	/**
	 * Function to return the current offset of the sensor
	 * 
	 * @return The current sensor offset in radians
	 */
	public double getOffset(){
		return this.offset;
	}
	
	/**
	 * Function to set the maximum voltage of the sensor
	 * This function will call the computeVoltsPerRadian function to adjust for the new voltage.
	 * 
	 * @param maxVoltage - The maximum voltage possible on the sensor, any voltage read higher than this is ignored
	 */
	public void setMaxVoltage(double maxVoltage){
		this.maxVoltage = maxVoltage;
		this.computeVoltsPerRadian();
	}
	
	/**
	 * Function to return the current maximum voltage setting for this sensor
	 * 
	 * @return The current maximum voltage setting for this sensor
	 */
	public double getMaxVoltage(){
		return this.maxVoltage;
	}
	
	/**
	 * Function to set the minimum voltage of the sensor
	 * This function will call the computeVoltsPerRadian function to adjust for the new voltage.
	 * 
	 * @param minVoltage - The minimum voltage possible on the sensor, any voltage read lower than this is ignored
	 */
	public void setMinVoltage(double minVoltage){
		this.minVoltage = minVoltage;
		this.computeVoltsPerRadian();
	}
	
	/**
	 * Function to return the current minimum voltage setting for this sensor.
	 * 
	 * @return The current minimum voltage setting for this sensor
	 */
	public double getMinVoltage(){
		return this.minVoltage;
	}
	
	/**
	 * Function to compute the voltage per radian for the sensor.
	 * This function should be called anytime a change is made to the minVoltage value or the maxVoltage value
	 * 
	 */
	public void computeVoltsPerRadian(){
		double voltageDifference;
		voltageDifference = this.maxVoltage - this.minVoltage;
		
		this.voltsPerRadian = (Math.PI * 2)/voltageDifference;
	}

	/**
	 * Function to return the current angle of the sensor
	 * 
	 * @return The current angle of the sensor in radians
	 */
	public double getSensorAngle(){
		double voltage = this.getSensorVoltage();
		double angle;
		
		if(voltage < this.minVoltage){
			voltage = this.minVoltage;
		}
		else if(voltage > this.maxVoltage){
			voltage = this.maxVoltage;
		}
		
		angle = (voltage - this.minVoltage) * this.voltsPerRadian;
		angle = angle - this.offset;
		
		if(angle == (Math.PI * 2)){
			angle = 0;
		}
		else if(angle <0){
			angle = angle + (Math.PI * 2);
		}
		else if(angle > (Math.PI * 2)){
			angle = angle - (Math.PI * 2);
		}
		
		return angle;
	}
	
	/**
	 * Function to return the current angle of the sensor
	 * 
	 * @param isRadians - Whether the output should be in radians, Radians if true, Degrees if false
	 * @return The current angle of the sensor in whichever measurement is specified
	 */
	public double getSensorAngle(boolean isRadians){
		if(isRadians){
			return this.getSensorAngle();
		}
		else{
			return MathUtils.round(this.getSensorAngle() * (Math.PI/180));
		}
	}
	
	/**
	 * Function to return the current voltage of the sensor
	 * No adjustments are made to the voltage in this function, this is the raw voltage.
	 * 
	 * @return The raw voltage of the sensor
	 */
	public double getSensorVoltage(){
		return this.sensor.getVoltage();
	}
	
	/**
	 * Function to implement PIDSource, giving the result sensor angle to the 
	 * PIDController.
	 * 
	 * @return getSensorAngle()
	 */
	public double pidGet(){
		return this.getSensorAngle();
	}
}
