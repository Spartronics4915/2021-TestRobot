package com.spartronics4915.frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

import com.spartronics4915.frc.Constants;
import com.spartronics4915.frc.subsystems.JoystickMotor;

public class JoystickMotorCommands
{
    private final JoystickMotor mMotor;
    private final Joystick mJoystick;
    private boolean mInverted;
    private boolean mSlow;

    public JoystickMotorCommands(JoystickMotor motor)
    {
        mMotor = motor;
        mJoystick = motor.getJoystick();
        mInverted = false;
        mSlow = false;
    }

    public class TeleOpCommand extends CommandBase
    {
        public TeleOpCommand()
        {
            addRequirements(mMotor);
        }

        @Override
        public void execute()
        {
            double y = -1 * mJoystick.getY();

            if (mSlow)
            {
                y *= Constants.JoystickMotorConstants.kMotorSlowSpeed;
            }

            if (mInverted)
            {
                y *= -1;
            }

            // copied from 2020-InfiniteRecharge, no idea how it works (magic)
            y = Math.copySign(Math.pow(Math.abs(y), 5.0/3.0), y); // apply response curve
            mMotor.set(applyDeadzone(y, Constants.JoystickMotorConstants.kJoystickDeadzone));
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
}
