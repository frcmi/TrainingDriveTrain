// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

public class ShiftingGearbox extends SubsystemBase {
  public Solenoid solenoid = new Solenoid(0);

<<<<<<< HEAD
=======
public class ShiftingGearbox extends SubsystemBase {
>>>>>>> f1941e9bdf0324e3235eee4a17f9e32d94f445d4
  /** Creates a new ShiftingGerbox. */
  public ShiftingGearbox() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shift() {
    solenoid.set(!solenoid.get());
  }

  public boolean getValue() {
    return solenoid.get();
  }
  
}
