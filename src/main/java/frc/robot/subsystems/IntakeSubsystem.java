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

public class IntakeSubsystem extends SubsystemBase {

  private WPI_VictorSPX intakeVictorSPX = new WPI_VictorSPX(Constants.kintakeport);
  
  /**
  /**
   * Creates a new IntakeSubsystem.
   */

  public IntakeSubsystem() {

  /**
   * Creates a new WinchSubsystem.
   */
    addChild("motor", intakeVictorSPX);
  }

  public void forward(){
    intakeVictorSPX.set(ControlMode.PercentOutput, -0.8);
  }
  public void reverse(){
    intakeVictorSPX.set(ControlMode.PercentOutput, 0.5);
  }
  public void stop(){
    intakeVictorSPX.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {

  }


}
