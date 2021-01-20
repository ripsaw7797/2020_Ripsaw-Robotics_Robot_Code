/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Robot;
//import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class MoveForward extends CommandBase {
  /**
   * Creates a new AutoCommand1.
   */
  // private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();

  private final DriveSubsystem m_driveSubsystem;

  private double startTime; 
  
  private String DSPrint;
  
  public MoveForward(DriveSubsystem _drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveSubsystem = _drive;
    addRequirements(_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    startTime = Timer.getFPGATimestamp();
    DSPrint = "initialize";
    DriverStation.reportError(DSPrint, false);
    System.out.println("Starting");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double time = Timer.getFPGATimestamp();
    System.out.println(time - startTime);

    if (time - startTime < 3) {
     m_driveSubsystem.manualDrive2(0.5,0);
    } 
    else {
     m_driveSubsystem.manualDrive2(0,0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
