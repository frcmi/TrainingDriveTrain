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
  
 
  WPI_TalonFX m_rearLeft = new WPI_TalonFX(2);
  WPI_TalonFX m_frontLeft = new WPI_TalonFX(3);
 WPI_TalonFX m_frontRight = new WPI_TalonFX(1);
 WPI_TalonFX m_rearRight = new WPI_TalonFX(0);
  SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
  SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_rearRight);
  private DifferentialDrive m_myRobot = new DifferentialDrive(left,right);

  SpeedController rL = m_rearLeft;
  SpeedController fL = m_frontLeft;
  SpeedController rR = m_rearRight;
  SpeedController fR = m_frontRight;

  //FeedbackDevice rLEncoder = new FeedbackDevice(0);

  //m_rearLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 5)

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setInverted() {
    right.setInverted(true);
  }

  public void setEncoders() {
    m_rearLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    m_frontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    m_rearRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    m_frontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
  }

  public double getEncoderVelocityLeft() {
    System.out.println((m_rearLeft.getSelectedSensorVelocity() + m_frontLeft.getSelectedSensorVelocity())/2);
    return ((m_rearLeft.getSelectedSensorVelocity() + m_frontLeft.getSelectedSensorVelocity())/2);
  }

  public double getEncoderVelocityRight() {
    System.out.println((m_rearRight.getSelectedSensorVelocity() + m_frontRight.getSelectedSensorVelocity())/2);
    return ((m_rearRight.getSelectedSensorVelocity() + m_frontRight.getSelectedSensorVelocity())/2);
  }

  public double getEncoderPositionLeft() {
    System.out.println((m_rearLeft.getSelectedSensorPosition() + m_frontLeft.getSelectedSensorPosition())/2);
    return ((m_rearLeft.getSelectedSensorPosition() + m_frontLeft.getSelectedSensorPosition())/2);
  }

  public double getEncoderPositionRight() {
    System.out.println((m_rearRight.getSelectedSensorPosition() + m_frontRight.getSelectedSensorPosition())/2);
    return ((m_rearRight.getSelectedSensorPosition() + m_frontRight.getSelectedSensorPosition())/2);
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

  public void driveRL(double d) {
    rL.set(d);
  }

  public void driveFL(double d) {
    fL.set(d);
  }

  public void driveRR(double d) {
    rR.set(d);
  }

  public void driveFR(double d) {
    fR.set(d);
  }
}
