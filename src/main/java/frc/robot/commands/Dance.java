// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.subsystems.*;
import frc.robot.Robot;
public class Dance extends CommandBase {
  /** Creates a new Dance. */
  int[] moves = {2000,2000, 2000, 2000};
  int i = 0;
  long time = System.currentTimeMillis();
  boolean done;
  PIDController motorPIDLeft = new PIDController(1, 1, 0);
  PIDController motorPIDRight = new PIDController(1, 1, 0);
  public Dance() {
    //addRequirements(Robot.container.drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("starting dance");
    i = 0;
    done = false;
    time = System.currentTimeMillis();
    motorPIDLeft.setSetpoint(1.00);
    motorPIDRight.setSetpoint(-1.00);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("dancing");
    try {
  if(i < moves.length) {
    if(System.currentTimeMillis()-time < moves[i]) {
      Robot.container.drive.drive(motorPIDLeft.calculate(Robot.container.drive.getLeftMotors()), motorPIDRight.calculate(Robot.container.drive.getRightMotors()));
    }
    else {
      time = System.currentTimeMillis();
      i++;
      motorPIDLeft.setSetpoint(-1.00);
      motorPIDRight.setSetpoint(1.00);
    }
  }
  else {
    done = true;
  }
}
catch(Exception e) {
}
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(done) {
      System.out.println("done");
      return true;
    }
    else {
      return false;
    }
  }
}