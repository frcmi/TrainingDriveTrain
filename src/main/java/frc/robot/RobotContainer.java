// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;

public class RobotContainer {
  public Joystick leftStick = new Joystick(0);
  public Joystick rightStick = new Joystick(1);
  public DriveTrain drive = new DriveTrain();
  public Shooter shooter = new Shooter();
  public Pneumatics pneumatics = new Pneumatics();
  public Navx navx = new Navx();
  
  /** Creates a new RobotContainer. */
  Dance dance = new Dance();
  Areadetect areadetect = new Areadetect();
  ReadNavxValues readNavxValues = new ReadNavxValues();

  //Constants
  public static final double kDistancePerRevolution = 18.84;  // guestimate from your code
  public static final double kPulsesPerRevolution = 1024;     // for an AS5145B Magnetic Encoder
  public static final double kDistancePerPulse = kDistancePerRevolution / kPulsesPerRevolution;

  public RobotContainer() {
    // Use addRequirements() here to declare subsystem dependencies.
    
   
  }


}
