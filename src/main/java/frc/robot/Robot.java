// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  Joystick joy = new Joystick(0);
  VictorSP left = new VictorSP(1);
  VictorSP right = new VictorSP(5);
  
  
   @Override
  public void robotInit() {
    Timer timer = new Timer();
    AutoRoute.init();
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    AutoRoute.start();
  }

  @Override
  public void autonomousPeriodic() {
    AutoRoute.loop();
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    left.set(joy.getRawAxis(1)*0.5); 
    right.set(joy.getRawAxis(5)*0.5);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
