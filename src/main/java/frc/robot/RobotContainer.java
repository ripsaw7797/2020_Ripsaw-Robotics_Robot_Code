/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.RampSubsystem;
import frc.robot.subsystems.SpinnerSubsystem;
import frc.robot.subsystems.SpinningRainbowSubsystem;
import frc.robot.subsystems.WinchSubsystem;
import frc.robot.commands.AutoCommand1;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final RampSubsystem m_rampSubsystem = new RampSubsystem();
  private final WinchSubsystem m_winchSubsystem = new WinchSubsystem();
  private final SpinnerSubsystem m_spinnerSubsystem = new SpinnerSubsystem();
  private final SpinningRainbowSubsystem m_spinningrainbowSubsystem = new SpinningRainbowSubsystem();


  // setup autonomous
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  private final Command m_simpleAuto = new AutoCommand1();

  // sticks
  private final Joystick driverstick = new Joystick(Constants.kdriverstickPort);
  private final Joystick operatorstick = new Joystick(Constants.koperatorstickPort);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_driveSubsystem.setDefaultCommand(
      new RunCommand(() -> m_driveSubsystem.manualDrive(-driverstick.getY(), driverstick.getX()), m_driveSubsystem));
      System.out.println("setDewfaultCommnd");

    // Add commands to the autonomous command chooser
    m_chooser.addOption("Test Auto", m_simpleAuto);
    m_chooser.addOption("Test Auto", m_simpleAuto);
    System.out.println("addOption");

    // Put the chooser on the dashboard
    // Shuffleboard.getTab("Autonomous").add(m_chooser);System.out.println("setDewfaultCommnd");
    SmartDashboard.putData("Pick Me", m_chooser);
    System.out.println("setDewfaultCommnd");

  // Shuffleboard.getTab("Autonomous").add(m_chooser);System.out.println("setDewfaultCommnd");
    System.out.println("");
  }

  

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
 private void configureButtonBindings() {
    new JoystickButton(operatorstick, Constants.kintakeForward).whenPressed(
      new InstantCommand(m_intakeSubsystem::forward, m_intakeSubsystem)
    ).whenReleased(
      new InstantCommand(m_intakeSubsystem::stop, m_intakeSubsystem) 
    );

    new JoystickButton(operatorstick, Constants.kintakeReverse).whenPressed(
      new InstantCommand(m_intakeSubsystem::reverse, m_intakeSubsystem)
    ).whenReleased(
      new InstantCommand(m_intakeSubsystem::stop, m_intakeSubsystem) 
    );

    new JoystickButton(operatorstick, Constants.kramp).whenPressed(
      new InstantCommand(m_rampSubsystem::forward, m_rampSubsystem)
    ).whenReleased(
     new InstantCommand(m_rampSubsystem::stop, m_rampSubsystem)
    ); 

    new JoystickButton(operatorstick, Constants.krampReverse).whenPressed(
      new InstantCommand(m_rampSubsystem::reverse, m_rampSubsystem)
    ).whenReleased(
      new InstantCommand(m_rampSubsystem::stop, m_rampSubsystem)
    );

    new JoystickButton(operatorstick, Constants.krampeject).whenPressed(
      new InstantCommand(m_rampSubsystem::eject, m_rampSubsystem)
    ).whenReleased(
      new InstantCommand(m_rampSubsystem::stop, m_rampSubsystem)
    );

    new JoystickButton(operatorstick, Constants.kelevatorRaise).whenPressed(
      new InstantCommand(m_elevatorSubsystem::raise, m_elevatorSubsystem)
    ).whenReleased(
      new InstantCommand(m_elevatorSubsystem::stop, m_elevatorSubsystem)
    );

    new JoystickButton(operatorstick, Constants.kelevatorLower).whenPressed(
      new InstantCommand(m_elevatorSubsystem::lower, m_elevatorSubsystem)
    ).whenReleased(
      new InstantCommand(m_elevatorSubsystem::stop, m_elevatorSubsystem)
    );

    new JoystickButton(operatorstick, Constants.kwinchRaise).whenPressed(
      new InstantCommand(m_winchSubsystem::winchRaise, m_winchSubsystem)
    ).whenReleased(
      new InstantCommand(m_winchSubsystem::stop, m_winchSubsystem) 
    );

    new JoystickButton(operatorstick, Constants.kspinnerUp).whenPressed(
      new InstantCommand(m_spinnerSubsystem::spinnerUp, m_spinnerSubsystem)
    ).whenReleased(
      new InstantCommand(m_spinnerSubsystem::stop, m_spinnerSubsystem)
    );

    new JoystickButton(operatorstick, Constants.kspinnerDown).whenPressed(
      new InstantCommand(m_spinnerSubsystem::spinnerDown, m_spinnerSubsystem)
      ).whenReleased(
      new InstantCommand(m_spinnerSubsystem::stop, m_spinnerSubsystem)
    );

    new JoystickButton(operatorstick, Constants.kspinningrainbowOn).whenPressed(
      new InstantCommand(m_spinningrainbowSubsystem::spinningrainbowOn, m_spinningrainbowSubsystem)
    ).whenReleased(
      new InstantCommand(m_spinningrainbowSubsystem::stop, m_spinningrainbowSubsystem)
    );

    new JoystickButton(operatorstick, Constants.kspinningrainbowOff).whenPressed(
      new InstantCommand(m_spinningrainbowSubsystem::spinningrainbowOff, m_spinningrainbowSubsystem)
    ).whenReleased(
      new InstantCommand(m_spinningrainbowSubsystem::stop, m_spinningrainbowSubsystem)
    );
 }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }
}
