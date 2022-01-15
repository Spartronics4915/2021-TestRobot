package com.spartronics4915.frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

import com.spartronics4915.frc.Constants.*;
import com.spartronics4915.frc.subsystems.JoystickMotor;

public class JoystickMotorCommand extends CommandBase
{
    private final JoystickMotor mJoystickMotor;
    private final Joystick mJoystick;
    private boolean mInverted;
    private boolean mSlow;

    public JoystickMotorCommand(JoystickMotor motor)
    {
        mJoystickMotor = motor;
        mJoystick = motor.getJoystick();
        mInverted = false;
        mSlow = false;
        addRequirements(mJoystickMotor);
    }

    @Override
    public void execute()
    {
        double y = -1 * mJoystick.getY();

        if (mSlow)
        {
            y *= JoystickMotorConstants.kMotorSlowSpeed;
        }

        if (mInverted)
        {
            y *= -1;
        }

        // copied from 2020-InfiniteRecharge, no idea how it works (magic)
        y = Math.copySign(Math.pow(Math.abs(y), JoystickMotorConstants.kJoystickResponseCurve), y); // apply response curve
        mJoystickMotor.set(applyDeadzone(y, JoystickMotorConstants.kJoystickDeadzone));
    }

    // also copied from ir2020
    private double applyDeadzone(double val, double deadzone)
    {
        if (Math.abs(val) < deadzone)
        {
            return 0.0;
        }
        return val;
    }
}
