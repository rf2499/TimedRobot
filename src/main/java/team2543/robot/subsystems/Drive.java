package team2543.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;

public class Drive extends Subsystem {

    PWMTalonFX leftMotorMaster = new PWMTalonFX(0);
    // PWMTalonFX leftMotorSlave1 = new PWMTalonFX(1);
    // PWMTalonFX leftMotorSlave2 = new PWMTalonFX(2);

    PWMTalonFX rightMotorMaster = new PWMTalonFX(3);
    // PWMTalonFX rightMotorSlave1 = new PWMTalonFX(4);
    // PWMTalonFX rightMotorSlave2 = new PWMTalonFX(5);

    private Joystick joystick = new Joystick(0);

    private double _steerDemand;        // -1 to 1
    private double _throttleDemand;     // -1 to 1
    private boolean _slowMode;

    public Drive() {

    }

    @Override
    public void readPeriodicInputs() {
        _steerDemand = joystick.getRawAxis(0);
        _throttleDemand = joystick.getRawAxis(4) * -1;  // invert because forward is -1 and backward is 1
        _slowMode = joystick.getRawButton(1);
        
    }

    @Override
    public void writePeriodicOutputs() {
        
        double modifier = 1;    // 0 to 1

        if (_slowMode) modifier /= 2;

        // set motors
        // leftMotorMaster.set((_throttleDemand + _steerDemand) * modifier);
        // rightMotorMaster.set((_throttleDemand - _steerDemand) * modifier);

        double setLeft = (_throttleDemand + _steerDemand) * modifier;
        double setRight = (_throttleDemand - _steerDemand) * modifier;
        leftMotorMaster.set(setLeft);
        rightMotorMaster.set(setRight);
        
        System.out.println("setLeft = " + setLeft + ", setRight = " + setRight);
        
    }
    
}
