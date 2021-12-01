// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.cameraserver.CameraServer;


/**
 * This is a demo program showing the use of the RobotDrive class, specifically it contains the code
 * necessary to operate a robot with tank drive.
 */
//4 motor practice drivetrain with repeater piece (??? don't know what that is)
public class Robot extends TimedRobot {
  

  public static RobotContainer container = new RobotContainer();
  Timer m_timer = new Timer();


  @Override
  public void robotInit() {
    
    CommandScheduler.getInstance().enable();
    CameraServer.getInstance().startAutomaticCapture();
    container.drive.setInverted();
  
  }

  @Override
  public void teleopPeriodic() {
    container.drive.drive(Robot.container.leftStick.getY() * 0.05, Robot.container.rightStick.getY() * 0.05);
  }
  @Override
  public void autonomousInit() {
    
    CommandScheduler.getInstance().schedule(container.dance);
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();

    }


}
