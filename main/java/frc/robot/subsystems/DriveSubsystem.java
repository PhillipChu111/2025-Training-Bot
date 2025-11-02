// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;  

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  // TODO: Initialize a DifferentialDrive variable
  DifferentialDrive differentialDrive;
  // TODO: Initialize four CANSparkMax motors

  CANSparkMax leftFront = new CANSparkMax(kLeftFrontID, CANSparkMax.MotorType.kBrushless);
  CANSparkMax leftRear = new CANSparkMax(kLeftRearID, CANSparkMax.MotorType.kBrushless);
  CANSparkMax rightFront = new CANSparkMax(kRightFrontID, CANSparkMax.MotorType.kBrushless);
  CANSparkMax rightRear = new CANSparkMax(kRightRearID, CANSparkMax.MotorType.kBrushless);


  public ExampleSubsystem() {
    // TODO: Set motor current limits
    leftFront.setSmartCurrentLimit(kCurrentLimit);
    leftRear.setSmartCurrentLimit(kCurrentLimit);
    rightFront.setSmartCurrentLimit(kCurrentLimit);
    rightRear.setSmartCurrentLimit(kCurrentLimit);

    // TODO: Set the rear left and right motors to be followers
    leftRear.follow(leftFront);
    rightRear.follor(rightFront);
    // TODO: Set one side of the motors to be inverted 
    leftFront.setInverted(true);
    rightFront.setInverted(false);
    // TODO: Assign the DifferentialDrive variable to a new DifferentialDrive object passing in the two front motors
    differentialDrive = new DifferentialDrive(leftFront, rightFront);
    // TODO: Pass in a max speed 
    setMaxOutput(maxSpeed);
  }

  // TODO: Create an arcadeDrive method, taking in speed and rotation 
public void arcadeDrive(double speed, double rotation) {
     
  double leftOutput = leftPIDController.calculate(driveLeftEncoder.getRate(), targetLeftVelocity);
  double rightOutput = rightPIDController.calculate(driveRightEncoder.getRate(), targetRightVelocity);
  
  // insure motor range allowable in.
  leftOutput = MathUtil.clamp(leftOutput, -1.0, 1.0);
  rightOutput = MathUtil.clamp(rightOutput, -1.0, 1.0);

  m_drivetrain.arcadeDrive(speed + leftOutput, -rotation + rightOutput); 
}
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called to EXPLODE once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
