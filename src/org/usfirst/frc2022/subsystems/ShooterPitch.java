package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc2022.RobotMap;
import org.usfirst.frc2022.Utils;
import org.usfirst.frc2022.commands.RotationPitchCommand;
import org.usfirst.frc2022.sensors.CherryAN8;

/**
 * Code is extending cherryAN8 program to control a jaguar to position the
 * shooter to the proper angle of pitch towards target using the CherryAN8
 * sensor
 *
 * @author Malachi Loviska
 */
public class ShooterPitch extends PIDSubsystem {

    /**
     * initializes the Jaguar and CherryAN8
     */
    Jaguar pitch_motor;
    CherryAN8 pitch_sensor;
    /**
     * Set proportion for PID to 0.1
     */
    private static final double Kp = 0.1;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    /**
     * Initialize subsystem
     */
    public ShooterPitch() {
        super("ShooterPitch", Kp, Ki, Kd);


        /**
         * Constructs Jaguar and Cherry for pitch and assigns ports from
         * RobotMap
         */
        pitch_motor = new Jaguar(RobotMap.pitch_motor);
        pitch_sensor = new CherryAN8(RobotMap.cherry_pitch);


    }

    /**
     * Set the default command for subsystem
     */
    public void initDefaultCommand() {
        setDefaultCommand(new RotationPitchCommand());
    }

    ///////////////////// PID Functions /////////////////////////
    /**
     * Return input value for the PID loop from Cherry
     */
    protected double returnPIDInput() {

        /**
         * Sets and return value from Cherry as degrees
         *
         * @ return degree value from cherry
         */
        return pitch_sensor.getSensorAngle(false);
    }

    /**
     * Use output from cherry to move Jaguar to position
     *
     * @ return needed movement of Jaguar between 1 and -1
     */
    protected void usePIDOutput(double output) {


        /**
         * If else statement to set inputs for Jaguar between 1 and -1 if if
         * under or over that range
         */
        if (output > 1) {
            output = 1;
        } else if (output < -1) {
            output = -1;

        }
        /**
         * sets output for the Jaguar movement
         */
        pitch_motor.set(output);

    }

    /**
     * Set state of PID Loop
     *
     * @param pid Whether to enable PID loop or not
     */
    public void usePID(boolean pid) {
        if (pid) {
            this.enable();
        } else {
            this.disable();
        }
    }

    ///////////////////// Manual Functions /////////////////////////
    
    /**
     *
     * Used for Manual control of the Pitch. Also turns of PID loop if running.
     *
     * @param percent Value -0.75 to 0.75 for speed of the shooter.
     */
    public void setPitch(double percent) {
        this.usePID(false);
        pitch_motor.set(Utils.clamp(percent, 1, -1));
    }
}
