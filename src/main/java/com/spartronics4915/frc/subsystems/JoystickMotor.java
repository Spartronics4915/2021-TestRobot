package com.spartronics4915.frc.subsystems;

import com.spartronics4915.frc.Constants;
import com.spartronics4915.lib.subsystems.SpartronicsSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANError;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class JoystickMotor extends SpartronicsSubsystem
{
    private static JoystickMotor sInstance = null;
    private static CANSparkMax mMotor;
    private static Joystick mJoystick;

    public JoystickMotor()
    {
        boolean success = true;
        try
        {
            mMotor = new CANSparkMax(Constants.kTestMotorId, MotorType.kBrushless);
            mJoystick = new Joystick(Constants.OI.kJoystickId);
        }
        catch (Exception exception)
        {
            logException("Could not construct hardware: ", exception);
            success = false;
        }
        logInitialized(success);
    }

    public static JoystickMotor getInstance()
    {
        if (sInstance == null) {
            sInstance = new JoystickMotor();
        }
        return sInstance;
    }

    public void set(double speed)
    {
        SmartDashboard.putString("Motor","Setting Speed");
        mMotor.set(speed);
        SmartDashboard.putNumber("Speed",mMotor.get());
    }

    public double getSpeed()
    {
        SmartDashboard.putString("Motor","Getting Speed");
        return mMotor.get();
    }

    public Joystick getJoystick()
    {
        return mJoystick;
    }
}
