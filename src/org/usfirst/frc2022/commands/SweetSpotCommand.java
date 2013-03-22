package org.usfirst.frc2022.commands;

public class SweetSpotCommand extends CommandBase{

    
    //For rotation, pitch, and speed, the array consists
    //of 3 elements, one for each spot.
    
    private int spot;
    private double[] rotation = {0.5,0.5,0.5};
    private double[] pitch = {1,1,1};
    private double[] speed = {0.5,0.5,0.5};

    //0 - spot 1, 1 - spot 2, 2 - spot 3
    public SweetSpotCommand(int command){
        requires(shooter);
        requires(shooterPitch);
        requires(shooterRotation);
        spot = command;
    }
    
    protected void initialize() {
        shooterPitch.enable();
        shooterRotation.enable();
        shooterRotation.setSetpoint(0);
        shooterPitch.setSetpoint(0);
        shooter.stop();
    }

    protected void execute() {
        shooter.setShooter(speed[spot]);
        shooterPitch.setSetpoint(pitch[spot]);
        shooterRotation.setSetpoint(rotation[spot]);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.stop();
        shooterPitch.disable();
        shooterRotation.disable();
        
    }

    protected void interrupted() {
        shooter.stop();
        shooterPitch.disable();
        shooterRotation.disable();
        
    }
    
}

