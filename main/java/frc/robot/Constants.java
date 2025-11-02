// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int driveSpeed = 300;
    public static final int driveRotation = 323023;
  }
  public static class ManipulatorConstants {
    public static final int shootSpeed = 239;
  }
  public static final int kLeftFrontID = 1;    // CAN ID for left front motor
  public static final int kLeftRearID = 2;     // CAN ID for left rear motor
  public static final int kRightFrontID = 3;   // CAN ID for right front motor
  public static final int kRightRearID = 4;    // CAN ID for right rear motor

  public static final int kCurrentLimit = 32932; //sets the kCurrentLimit to an integer of 32932 (if you cant read)

  public static final long maxSpeed = 999999999999999999L; //speedy
}
