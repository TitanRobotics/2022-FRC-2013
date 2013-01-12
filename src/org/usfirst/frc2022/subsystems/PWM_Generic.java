package org.usfirst.frc2022.subsystems;


import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2022.Utils;
import org.usfirst.frc2022.commands.MecanumCommand;

/** 
 * 
 * Generic
 * 
 */
public class PWM_Generic extends Subsystem implements Drive_Generic{
	
	Jaguar[] jags; 		//Array of a variable size that holds the jaguars
	Jaguar[] jagsLeft;	//jaguars on the left side of the robot
	Jaguar[] jagsRight; 	//jaguars on the right side of the robot
	
	/**
	 * Constructor for the subsystem. Assigns jaguars if there are an
	 * even amount and there are the same number of ports.
	 * 
	 * @param jags Array of jaguars used for controlling the drivebase
	 * @return
	 */
	public PWM_Generic(Jaguar[] newJags){ //Check if there are an even number of jaguars
	
            if(checkEven(newJags.length)){
		this.jags = newJags;
                seperateJags(this.jags);
                //assignLiveWindow();
            } else {System.out.println("Odd number of Jaguars");}	
	}
        
        /**
	 * Constructor for the subsystem. Assigns jaguars if there are an
	 * even amount of ports.
	 * 
	 * @param ports Array of ints storing the ports used by the Jaguars
	 * @return
	 */
	public PWM_Generic(int[] ports){ //Check if there are an even number of jaguars
            Jaguar[] newJags = new Jaguar[ports.length];
            if(checkEven(ports.length)){
		
                for(int i=0; i<ports.length;i++){
                    newJags[i] = new Jaguar(ports[i]);
                }
                
                this.jags = newJags;
                seperateJags(this.jags);
                //assignLiveWindow();
            } else {System.out.println("Odd number of Jaguars");}	
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
	 * Set the speed of the motors on the left side of
	 * the robot.
	 * 
	 * @param speed The speed at which the motors move
	 * @returns
	 */
	public void setLeft(double speed){
		for(int i=0; jagsLeft.length > i; i++){
			jagsLeft[i].set(Utils.clamp(speed,1,-1));
		}
	}
	
	/**
	 * Set the speed of the motors on the right side of
	 * the robot.
	 * 
	 * @param speed The speed at which the motors move
	 * @returns
	 */
	public void setRight(double speed){
		for(int i=0; jagsRight.length > i; i++){
			jagsRight[i].set(Utils.clamp(-speed,1,-1));
		}
	}
	
	/**
	 * Move the robot. Only go forward and back.
	 * 
	 * @param speed The speed of the motors
	 * @returns
	 */
	public void drive(double speed){
		setRight(speed);
		setLeft(speed);
	}
	
	/**
	 * Move the robot. Each side can have a different
	 * speed to allow for turning.
	 * 
	 * @param speedLeft The speed of the left motors
	 * @param speedRight The speed of the right motors
	 * @returns
	 */
	public void drive(double speedLeft, double speedRight){
		setRight(speedRight);
		setLeft(speedLeft);
	}
        
        public void driveMecanum(double speedLeftFront, double speedRightFront,double speedLeftBack, double speedRightBack){
		jagsLeft[0].set(speedLeftFront);
                jagsLeft[1].set(speedLeftBack);
                jagsRight[0].set(speedRightFront);
                jagsRight[1].set(speedRightBack);
	}
	
	/**
	 * Halt the motors
	 * 
	 * @param
	 * @return
	 */
	public void stop(){
		setRight(0);
		setLeft(0);
	}
	
	/**
	 * Function that checks if a number is even. Specifically
	 * used for checking the size of arrays.
	 * 
	 * @param size
	 * @return whether or not the number passed through is even
	 */
	public boolean checkEven(int size){
		if((size % 2)==1){return false;} else {return true;}
	} //end private boolean checkEven(int size)
	
	
	
	/**
	 * Separate the jaguars to left and right sides (odds left, evens right)
	 * 
	 * @param jags
	 * @return
	 */
	public void seperateJags(Jaguar[] jags){
		jagsLeft = new Jaguar[jags.length/2];
		jagsRight = new Jaguar[jags.length/2];
		for(int i=0,j=0,k=0; i< jags.length; i++){
			if(checkEven(jags[i].getChannel())){
				jagsRight[j]=jags[i];
				j++;
			} else if (!checkEven(jags[i].getChannel())){
				jagsLeft[k]=jags[i];
				k++;
			}
		}
	}
	
	/**
	 * Flips the jaguars on each side; then switches the sides
	 * 
	 * @param
	 * @return
	 */
	public void flipJags(){
		int length = jagsLeft.length/2;
		Jaguar[] tempJags = new Jaguar[length];
		
		tempJags=jagsLeft;
		for(int i=0; i < length; i++){ 
			jagsLeft[i]=tempJags[length-1-i]; //Flip jaguars on left
		}
		for(int i=0; i < length; i++){
			tempJags[i]=jagsRight[length-1-i]; //Flip jaguars on right
		}
		
		jagsRight = jagsLeft;
		jagsLeft = tempJags;
                //assignLiveWindow();
	}
	
        /*public void assignLiveWindow(){
            for(int i=0; i<jagsLeft.length; i++){
                RobotMap.liveWindow.addActuator("Generic PWM", "Left Jaguar #" + i + 1, jagsLeft[i]);
                RobotMap.liveWindow.addActuator("Generic PWM", "Right Jaguar #" + i + 1, jagsRight[i]);
            }
        }*/
        
}
