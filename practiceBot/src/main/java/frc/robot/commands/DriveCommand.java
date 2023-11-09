package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;



public class DriveCommand extends CommandBase{
    private Drivetrain drivetrain;
    private XboxController driver;

    public DriveCommand(Drivetrain drivetrain){
        this.drivetrain = drivetrain;
        driver = new XboxController(0);

        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        double speed;
        if (driver.getLeftTriggerAxis() > driver.getRightTriggerAxis()){
            speed = -driver.getLeftTriggerAxis();
        } else{
            speed = driver.getRightTriggerAxis();
        }

        drivetrain.setCurvatureDrive(speed, driver.getLeftX(), true);
    }
}
