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
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoCommand1 extends CommandBase {
  /**
   * Creates a new AutoCommand1.
   */
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();

  private double startTime; 
  private String DSPrint;
  
  public AutoCommand1() {
    // Use addRequirements() here to declare subsystem dependencies.
    
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
      new RunCommand(() -> m_driveSubsystem.manualDrive(0.6, 0.6));
    } else {
      new RunCommand(() -> m_driveSubsystem.manualDrive(0,0));
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
