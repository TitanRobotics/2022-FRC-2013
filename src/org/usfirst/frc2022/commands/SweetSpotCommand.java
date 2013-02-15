package org.usfirst.frc2022.commands;

import org.usfirst.frc2022.Joysticks.Attack3;

public class SweetSpotCommand extends CommandBase{

    private int spot;
    private double[] rotation = {1,1,1};
    private double[] pitch = {1,1,1};
    private double[] speed = {1,1,1};

    //0 - spot 1, 1 - spot 2, 2 - spot 3
    public SweetSpotCommand(int command){
        requires(shooter);
        requires(shooterPitch);
        requires(shooterRotation);
        spot = command;
    }
    
    protected void initialize() {
        shooter.enable();
        shooterPitch.enable();
        shooterRotation.enable();
        shooterRotation.setSetpoint(0);
        shooterPitch.setSetpoint(0);
        shooter.setSetpoint(0);
    }

    protected void execute() {
        shooter.setSetpoint(speed[spot]);
        shooterPitch.setSetpoint(pitch[spot]);
        shooterRotation.setSetpoint(rotation[spot]);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.disable();
        shooterPitch.disable();
        shooterRotation.disable();
        
    }

    protected void interrupted() {
        shooter.disable();
        shooterPitch.disable();
        shooterRotation.disable();
        
    }
    
}

