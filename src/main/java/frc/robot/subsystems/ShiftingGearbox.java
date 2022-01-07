// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;


public class ShiftingGearbox extends SubsystemBase {
  /** Creates a new ShiftingGerbox. */
  public ShiftingGearbox() {}
  public Solenoid solenoid = new Solenoid(0);
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //high gear (faster but less torque) is extended piston. .set() == true is extended
  public void shift() {
    solenoid.set(!solenoid.get());
  }

  public boolean getValue() {
    if (solenoid.get() == true) {
      System.out.println("Speedy");
    } else {
      System.out.println("Tanky");
    }
    return solenoid.get();
  }
  
}
