// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMTalonFX;
import com.ctre.phoenix.motorcontrol.*; 

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  
 
  //WPI_TalonFX m_frontLeft = new WPI_TalonFX(0);
  PWMTalonFX m_rearLeft = new PWMTalonFX(1);
  PWMTalonFX m_frontLeft = new PWMTalonFX(0);
 // SpeedController[] m_left = {m_frontLeft, m_rearLeft};
 PWMTalonFX m_frontRight = new PWMTalonFX(2);
 PWMTalonFX m_rearRight = new PWMTalonFX(3);
  //SpeedController[] m_right = {m_frontRight, m_rearRight};
  SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
  SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_rearRight);
  private DifferentialDrive m_myRobot = new DifferentialDrive(left,right);
  
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
}
