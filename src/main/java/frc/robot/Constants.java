/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  //PWM

  //DIO

  //CAN
  public static final int krightMasterPort = 1;
  public static final int krightSlavePort = 2;
  public static final int kleftMasterPort = 3;
  public static final int kleftSlavePort = 4;
  public static final int kliftport = 5;
  public static final int kwinchport = 7;
  public static final int kintakeport = 6;
  public static final int krampport = 8;
  public static final int kspinnerport = 9;
  public static final int kspinningrainbowport = 10;

  //USB
  public static final int kdriverstickPort = 0;
  public static final int koperatorstickPort = 1;
  public static final int cameraPort = 1;
  public static final int rampcameraPort = 0;


  //Buttons
  public static final int kwinchRaise = 4;
  public static final int kintakeForward = 11;
  public static final int kintakeReverse = 12;
  public static final int kramp = 2;
  public static final int krampReverse = 6;
  public static final int kelevatorRaise = 5;
  public static final int kelevatorLower= 3;
  public static final int krampeject= 1;
  public static final int kspinnerUp= 7;
  public static final int kspinnerDown= 8;
  public static final int kspinningrainbowOn= 9;
  public static final int kspinningrainbowOff= 10;
  
  //Other Drivetrain Constants
  public static final int kwheelDiameter = 6;
}
