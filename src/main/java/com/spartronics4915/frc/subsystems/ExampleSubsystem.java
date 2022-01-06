package com.spartronics4915.frc.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.spartronics4915.frc.Constants;
import com.spartronics4915.lib.subsystems.SpartronicsSubsystem;
import com.spartronics4915.lib.util.Logger;


/**
 * Detailed description of ExampleSubsystem.
 */
public class ExampleSubsystem extends SpartronicsSubsystem
{
    private static ExampleSubsystem sInstance = null;
    // The subsystem's hardware is defined here...
    private static CANSparkMax mTestMotor;

    /** Creates a new ExampleSubsystem. */
    public ExampleSubsystem()
    {
        boolean success = true;
        try
        {
            mTestMotor = new CANSparkMax(Constants.kTestMotorId, MotorType.kBrushless);

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
        Logger.debug((mTestMotor.get() > 0) ? "yes" : "no");

        mTestMotor.set(speed);

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
