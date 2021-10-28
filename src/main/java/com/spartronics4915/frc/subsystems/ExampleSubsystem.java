package com.spartronics4915.frc.subsystems;

import com.spartronics4915.frc.Constants;
import com.spartronics4915.lib.subsystems.SpartronicsSubsystem;

import edu.wpi.first.wpilibj.Talon;

/**
 * Detailed description of ExampleSubsystem.
 */
public class ExampleSubsystem extends SpartronicsSubsystem
{
    private static ExampleSubsystem sInstance = null;
    // The subsystem's hardware is defined here...
    private static Talon mTestMotor;

    /** Creates a new ExampleSubsystem. */
    public ExampleSubsystem()
    {
        boolean success = true;
        try
        {
            mTestMotor = new Talon(Constants.kTestMotorId);
        }
        catch (Exception exception)
        {
            logException("Could not construct hardware: ", exception);
            success = false;
        }
        logInitialized(success);
    }

    public static ExampleSubsystem getsInstance()
    {
        if (sInstance == null) {
            sInstance = new ExampleSubsystem();
        }
        return sInstance;
    }

    // Subsystem methods - actions the robot can take - should be placed here.

    public void startTestMotor(double speed) {
        mTestMotor.set(speed);
    }

    public void stopTestMotor() {
        mTestMotor.set(0.0);
    }

    /** This method will be called once per scheduler run. */
    @Override
    public void periodic() {}

    /** This method will be called once per scheduler run during simulation. */
    @Override
    public void simulationPeriodic() {}
}
