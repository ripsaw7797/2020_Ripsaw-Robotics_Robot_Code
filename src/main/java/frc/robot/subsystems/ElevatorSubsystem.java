/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

  private WPI_VictorSPX elevatorVictorSPX = new WPI_VictorSPX(Constants.kelevatorRaise);
  /**
   * Creates a new ElevatorSubsystem.
   */
  
  public ElevatorSubsystem() {

  }
  public void raise(){
    elevatorVictorSPX.set(ControlMode.PercentOutput, 0.6);
  }
  public void lower(){
    elevatorVictorSPX.set(ControlMode.PercentOutput, -0.2);
  }
  public void stop(){
    elevatorVictorSPX.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
