// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

public class Navx extends SubsystemBase {
  public AHRS ahrs;
  /** Creates a new Navx. */
  public Navx() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void printYPR() {
    System.out.println("Yaw: " + ahrs.getYaw() + "Pitch: " + ahrs.getPitch() + "Roll: " + ahrs.getRoll());

  }

  public void printGyro() {
    System.out.println("Angle: " + ahrs.getAngle());
    System.out.println("Rate: " + ahrs.getRate());
  }

  public void printAccel() {
    //(x value, y value)
    System.out.println("Accel: (" + ahrs.getWorldLinearAccelX() + "," + ahrs.getWorldLinearAccelY() + ")");
    System.out.println("Movning? " +  ahrs.isMoving());
    System.out.println("Rotating? " +  ahrs.isRotating());
  }

  public void printVeloDisp() {
    System.out.println("Velocity: (" + ahrs.getVelocityX() + "," + ahrs.getVelocityY() + ")");
    System.out.println("Velocity: (" + ahrs.getDisplacementX() + "," + ahrs.getDisplacementY() + ")");

  }

  public boolean isMoving() {
    if (ahrs.getWorldLinearAccelX() > 0.1 && ahrs.getWorldLinearAccelY() > 0.1) {
      return true;
    } else {
      return false;
    }
  }
}
