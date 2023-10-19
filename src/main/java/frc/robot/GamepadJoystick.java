package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class GamepadJoystick extends XboxController {    
    // COM ID
    public static final int CONTROLLER_PORT = 0;
    private static final double DEADBAND = 0.05;

    public GamepadJoystick(final int port) {
        super(port);
    }

    public double getRobotDriveSpeed() {
        return MathUtil.applyDeadband(-this.getLeftY(), DEADBAND);
    }

    public double getRobotRotateSpeed() {
        return MathUtil.applyDeadband(-this.getRightX(), DEADBAND) * Constants.Drive.TURN_SPEED;
    }
}