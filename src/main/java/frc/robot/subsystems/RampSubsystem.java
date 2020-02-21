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

public class RampSubsystem extends SubsystemBase {
  /**
   * Creates a new RampSubsystem.
   */
  
  private WPI_VictorSPX rampVictorSPX = new WPI_VictorSPX(Constants.krampport);
  public RampSubsystem() {
  }
    public void reverse(){
      rampVictorSPX.set(ControlMode.PercentOutput, -0.4);
    }
    public void eject(){
      rampVictorSPX.set(ControlMode.PercentOutput, 1);
    }
    public void forward(){
      rampVictorSPX.set(ControlMode.PercentOutput, 0.3);
    }
    public void stop(){
      rampVictorSPX.set(ControlMode.PercentOutput, 0);
    }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
