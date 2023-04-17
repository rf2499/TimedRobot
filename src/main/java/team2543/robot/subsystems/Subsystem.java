package team2543.robot.subsystems;

abstract public class Subsystem {

    // Read joysticks.
    // Should be called in robotPeriodic() because robotPeriodic() is called in both teleop and autonomous. 
    abstract public void readPeriodicInputs();

    // Output motors and pneumatics.
    // Should be called in both autonomousPeriodic() and teleopPeriodic().
    abstract public void writePeriodicOutputs();

    public void onDisabled() {

    }

    public void onEnabled() {
        
    }
}
