/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;



public class WinchSubsystem extends SubsystemBase {

  private WPI_VictorSPX winchMVictorSPX = new WPI_VictorSPX(Constants.kwinchport);
  
  /**
   * Creates a new WinchSubsystem.
   */
  public WinchSubsystem() {

    addChild("motor", winchMVictorSPX);

  }

  public void winchRaise(){
    winchMVictorSPX.set(ControlMode.PercentOutput, 0.2);
  }
  public void stop(){
    winchMVictorSPX.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
