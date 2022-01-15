package com.spartronics4915.frc;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static).
 * Do not put anything functional in this class.
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants
{
    public static final int kTestMotorId = 1;
    public static final double kTestMotorSpeed = 0.3;

    public static final class OI
    {
        public static final int kJoystickId = 0;
        public static final int kDriveStraightDriveStickButton = 8;

        // this block also copied from ir2020 (magic)
        public static final int kButtonBoardId = 1;
        public static class DeviceSpec
        {
            public String name;
            public int portId;
            public int numButtons;
            public Joystick joystick;
            public DeviceSpec(String nm, int id, int nbut)
            {
                this.name = nm;
                this.portId = id;
                this.numButtons = nbut;
                this.joystick = null;
            }
        }
        public static DeviceSpec[] deviceList;
        static
        {
            deviceList = new DeviceSpec[2];
            deviceList[0] = new DeviceSpec("Logitech Attack 3", kJoystickId, 12);
            deviceList[1] = new DeviceSpec("ButtonBoard", kButtonBoardId, 18);
        }
    }

    // from atlas 2020
    // public static final class DriveStraightConstants
    // {
    //     public static final double kP = 0; // Was 0.4
    //     public static final double kI = 0.2;
    //     public static final double kD = 0;
    //     public static final double kAllowedError = 0; // In degrees
    // }

    public static final class JoystickMotorConstants
    {
        public static final double kMotorSpeedMultiplier = 0.5;
        public static final double kMotorSlowSpeed = 0.3;
        public static final double kJoystickDeadzone = 0.1;
        public static final double kJoystickResponseCurve = 5.0/3.0;
    }
}
