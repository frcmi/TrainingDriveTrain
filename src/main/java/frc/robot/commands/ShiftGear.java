// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ShiftGear extends CommandBase {
  /** Creates a new ShiftGear. */
  public ShiftGear() {
    // Use addRequirements() here to declare subsystem dependencies.
  }
  //EncodersRegular encoders = Robot.container.encodersRegular;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  //When shifting, position is unreliable
  @Override
  public void execute() { //very arbitrary values. I didn't know what to put or what units anything is in
    if ((Robot.container.drive.getEncoderVelocityLeft() + Robot.container.drive.getEncoderVelocityRight()) /2 > 5.0 && !Robot.container.shiftingGearbox.getValue()) {
      Robot.container.shiftingGearbox.shift();
    } 
    if ((Robot.container.drive.getEncoderVelocityLeft() + Robot.container.drive.getEncoderVelocityRight()) /2 < 5.0 && Robot.container.shiftingGearbox.getValue()) {
      Robot.container.shiftingGearbox.shift();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
