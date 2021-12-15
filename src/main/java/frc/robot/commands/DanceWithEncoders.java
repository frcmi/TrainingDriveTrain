// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.EncodersRegular;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DanceWithEncoders extends CommandBase {
  /** Creates a new DanceWithEncoders. */
  private boolean done = false;
  
  EncodersRegular encoders = Robot.container.encodersRegular;

  public DanceWithEncoders() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    do {
      Robot.container.drive.drive(0.5, 0.0);
  } while (encoders.getLeftEncoders() / encoders.kDistancePerRevolution < 50.0 && encoders.getLeftEncoders() / encoders.kDistancePerRevolution < 50.0);
  Robot.container.drive.drive(0.0, 0.0);
  done = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if (interrupted) {
      Robot.container.drive.drive(0.0, 0.0);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
