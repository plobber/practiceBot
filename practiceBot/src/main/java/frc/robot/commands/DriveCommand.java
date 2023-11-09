package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;



public class DriveCommand extends CommandBase{
    private Drivetrain drivetrain;
    private XboxController driver;

    public DriveCommand(Drivetrain drivetrain){
        this.drivetrain = drivetrain;
        driver = new XboxController(1);

        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        double speed;
        double turn = driver.getLeftX();
        turn = Math.pow(turn,2) * Math.signum(turn) * .5;
        if (driver.getLeftTriggerAxis() > driver.getRightTriggerAxis()){
            speed = driver.getLeftTriggerAxis() * .75;
            speed = -(Math.pow(speed,2));

        } else{
            speed = driver.getRightTriggerAxis() * .75;
            speed = (Math.pow(speed,2));
        }
        SmartDashboard.putNumber("drivetrain/drivespeed", speed);
        SmartDashboard.putNumber("drivetrain/turnSpeed", turn);
        drivetrain.setCurvatureDrive(speed, -turn, true);
    }
}
