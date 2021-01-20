/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoDoNothing extends CommandBase {

  public AutoDoNothing() {
      // Use requires() here to declare subsystem dependencies
      // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    // literally do nothing
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    // literally still do nothing
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    // wait for a time out
      return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    // theres nothing to end
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  public void interrupted() {
    // who cares
  }
}
