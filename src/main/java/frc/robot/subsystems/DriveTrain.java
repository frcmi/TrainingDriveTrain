// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  
 
  //WPI_TalonFX m_frontLeft = new WPI_TalonFX(0);
  WPI_TalonFX m_rearLeft = new WPI_TalonFX(2);
  WPI_TalonFX m_frontLeft = new WPI_TalonFX(3);
 // SpeedController[] m_left = {m_frontLeft, m_rearLeft};
 WPI_TalonFX m_frontRight = new WPI_TalonFX(1);
 WPI_TalonFX m_rearRight = new WPI_TalonFX(0);
  //SpeedController[] m_right = {m_frontRight, m_rearRight};
  SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
  SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_rearRight);
  private DifferentialDrive m_myRobot = new DifferentialDrive(left,right);

  SpeedController rL = m_rearLeft;
  SpeedController fL = m_frontLeft;
  SpeedController rR = m_rearRight;
  SpeedController fR = m_frontRight;
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setInverted() {
    right.setInverted(true);
  }
  public void drive(double l, double r) {
    m_myRobot.tankDrive(l, r);
  }
  public double getLeftMotors() {
      return left.get();
  }
  public double getRightMotors() {
      return right.get();
  }

  public void driveRL() {
    rL.set(0.5);
  }

  public void driveFL() {
    fL.set(0.5);
  }

  public void driveRR() {
    rR.set(0.5);
  }

  public void driveFR() {
    fR.set(0.5);
  }
}
