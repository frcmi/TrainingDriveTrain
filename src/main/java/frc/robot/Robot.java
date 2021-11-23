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
  
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  public static RobotContainer container = new RobotContainer();
  Timer m_timer = new Timer();


  @Override
  public void robotInit() {
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
    
    CommandScheduler.getInstance().enable();
    CameraServer.getInstance().startAutomaticCapture();
    container.drive.setInverted();
  
  }

  @Override
  public void teleopPeriodic() {
    container.drive.drive(m_leftStick.getY(), m_rightStick.getY());
  }
  @Override
  public void autonomousInit() {
    
    CommandScheduler.getInstance().schedule(container.areadetect);
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();

    }


}
