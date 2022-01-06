package com.spartronics4915.frc.subsystems;

import com.spartronics4915.frc.Constants;
import com.spartronics4915.lib.subsystems.SpartronicsSubsystem;
import com.spartronics4915.lib.util.Logger;

import edu.wpi.first.wpilibj.PWMSparkMax;

/**
 * Detailed description of ExampleSubsystem.
 */
public class ExampleSubsystem extends SpartronicsSubsystem
{
    private static ExampleSubsystem sInstance = null;
    // The subsystem's hardware is defined here...
    private static PWMSparkMax mTestMotor;

    /** Creates a new ExampleSubsystem. */
    public ExampleSubsystem()
    {
        boolean success = true;
        try
        {
            mTestMotor = new PWMSparkMax(Constants.kTestMotorId);

        }
        catch (Exception exception)
        {
            logException("Could not construct hardware: ", exception);
            success = false;
        }
        logInitialized(success);
    }

    public static ExampleSubsystem getInstance()
    {
        if (sInstance == null) {
            sInstance = new ExampleSubsystem();
        }
        return sInstance;
    }

    // Subsystem methods - actions the robot can take - should be placed here.

    public void startTestMotor(double speed) {
        Logger.debug((mTestMotor.getSpeed() > 0) ? "yes" : "no");

        mTestMotor.setSpeed(speed);

        Logger.debug("CCCCCCCCCCCCCCC");
    }

    public void stopTestMotor() {

        // mTestMotor.set(0.0);
    }

    /** This method will be called once per scheduler run. */
    @Override
    public void periodic() {}

    /** This method will be called once per scheduler run during simulation. */
    @Override
    public void simulationPeriodic() {}


    public void outputTelemetry()
    {
        // TODO Auto-generated method stub
        logInfo("YEETUS");
    }
}
