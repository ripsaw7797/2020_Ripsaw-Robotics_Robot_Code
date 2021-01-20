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
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.RampSubsystem;

public class DeployFuel extends CommandBase {

  private final DriveSubsystem m_driveSubsystem;
  private final RampSubsystem m_rampSubsystem;

  private double startTime; 
  
  private String DSPrint;


  public DeployFuel(DriveSubsystem _drive, RampSubsystem _ramp) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveSubsystem = _drive;
    m_rampSubsystem = _ramp;
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

    if (time - startTime < 4.5) {
       m_driveSubsystem.manualDrive2(-0.5, 0);
    } else {
       m_driveSubsystem.manualDrive2(0,0);
    }

    if (time - startTime > 7) {
      m_rampSubsystem.rampVictorSPX(2);    
    } else {
      m_rampSubsystem.rampVictorSPX(0);
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
