package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveMotorModule {
    private final VictorSPX motor;
    private double driveSpeed;
    private double autoDriveSpeed;

    public DriveMotorModule(int motorPort, boolean inverted) {
        this.motor = new VictorSPX(motorPort);

        this.motor.setInverted(inverted);

        // Brake & Coast
        this.motor.setNeutralMode(NeutralMode.Brake);
    }

    public void setDesiredState(double driveSpeed) {
        this.driveSpeed = driveSpeed * Constants.Drive.DRIVE_SPEED;
        
        this.motor.set(ControlMode.PercentOutput, this.driveSpeed);

        SmartDashboard.putNumber("CIM-Speed: ", this.driveSpeed); 
    }

    public void setAutoDesiredState(double autoDriveSpeed){
        this.autoDriveSpeed = autoDriveSpeed * Constants.Drive.DRIVE_SPEED_AUTO;

        this.motor.set(ControlMode.PercentOutput, this.autoDriveSpeed);

        SmartDashboard.putNumber("Auto-Speed: ", this.autoDriveSpeed);
    }

    public void stop() {
        this.motor.set(ControlMode.PercentOutput, 0);
    }
}