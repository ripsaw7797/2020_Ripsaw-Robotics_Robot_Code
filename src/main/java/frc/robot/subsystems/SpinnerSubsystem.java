/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpinnerSubsystem extends SubsystemBase {

  private WPI_VictorSPX spinnerMVictorSPX = new WPI_VictorSPX(Constants.kspinnerport);
  /**
   * Creates a new SpinnerSubsystem.
   */
  public SpinnerSubsystem() {
    addChild( "motor", spinnerMVictorSPX);
  }

  public void spinnerUp(){
    spinnerMVictorSPX.set(ControlMode.PercentOutput, 0.2);
  }
  public void spinnerDown() {
    spinnerMVictorSPX.set(ControlMode.PercentOutput, -0.2);
  }
  public void stop(){
    spinnerMVictorSPX.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
