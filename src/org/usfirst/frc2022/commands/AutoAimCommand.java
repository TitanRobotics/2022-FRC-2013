package org.usfirst.frc2022.commands;

import edu.wpi.first.wpilibj.command.Command;

public class AutoAimCommand extends CommandBase {

    /*
     * The portion of the image that the box can be in
     */
    public final double middle = .01;
    public final double flat = 0.0;
    private double rotation;
    private double pitch;
    private double goal;

    public AutoAimCommand() {
        requires(camServos);
        requires(shooterInjector);
        requires(shooterPitch);
        requires(shooterRotation);
    }

    protected void initialize() {
        shooterInjector.enable();
        shooterPitch.enable();
        shooterRotation.enable();
        shooterRotation.setSetpoint(0);
        shooterPitch.setSetpoint(0);
        shooterInjector.setSetpoint(0);
        
    }

    protected void execute() {
        process(cam.analyze());
        if((goal == 0.0) || (goal == 1.0) || (goal == 2.0)){
            shooterInjector.setShooter(1);
            shooterPitch.setPitch(shooterPitch.getPosition() + pitch);
            shooterRotation.setRotation(shooterRotation.getPosition() + rotation);
        } else{
            shooterInjector.setShooter(0);
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooterInjector.disable();
        shooterPitch.disable();
        shooterRotation.disable();
    }

    protected void interrupted() {
        shooterInjector.disable();
        shooterPitch.disable();
        shooterRotation.disable();
    }


    private void process(double[] analyze) {
        rotation = analyze[1];
        pitch = analyze[2];
        goal = analyze[0];
    }
}
