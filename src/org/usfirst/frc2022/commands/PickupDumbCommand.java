/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2022.commands;
import org.usfirst.frc2022.Joysticks.Attack3;
import org.usfirst.frc2022.OI;
import org.usfirst.frc2022.subsystems.Pickup;
import org.usfirst.frc2022.subsystems.ShooterInjector;
        


/**This code controls the commands for subsystem Pickup.java and 
 * runs the relays when button is held down
 *
 * @author Malachi Loviska
 */
public class PickupDumbCommand extends CommandBase {
    
    Attack3 gandalfTheGrey;
   
    
    public PickupDumbCommand() {

        requires(spike);
       
    }
       /**
         * Runs the function when the command first starts and assigns the attack 3 form OI
         */

    protected void initialize() {
        gandalfTheGrey = oi.getAttack3();
        
    }

    /**
     * Runs the relays the command is running and 
     * detects if the Button is being held down 
     */
    protected void execute() {
        if (gandalfTheGrey.GetButton6Value()) {
              spike.roll();
        } 
        else if (gandalfTheGrey.GetButton7Value()){
            spike.drop();
        }
        else {spike.stop();}

    }
    
    protected boolean isFinished() {
        return false;
    }

   /**
     * This function is called when the command ends. It stops the robot.
     *
     * @param
     * @return
     */
    protected void end() {
        spike.stop();
    }

    /**
     * This function is called when the command is interrupted. It stops the
     * robot.
     *
     * @param
     * @return
     */
    protected void interrupted() {
        spike.stop();
    }
}
