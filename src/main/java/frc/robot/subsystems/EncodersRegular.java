package frc.robot.subsystems;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotContainer;

public class EncodersRegular extends SubsystemBase {
    private Encoder leftBackEncoder = new Encoder(1, 2, false, EncodingType.k4X);
    private Encoder rightBackEncoder = new Encoder(3, 4, true, EncodingType.k4X);
    //create encoders for each motor and write methods to get values from each encoder   
    public void robotInit() {
        leftBackEncoder.setDistancePerPulse(RobotContainer.kDistancePerPulse);
        rightBackEncoder.setDistancePerPulse(RobotContainer.kDistancePerPulse);
        resetEncoders();
    }
    private void resetEncoders() {
        leftBackEncoder.reset();
        rightBackEncoder.reset();
    }
    public double getLeftEncoders() {
        return (leftBackEncoder.get());
    }
    public double getRightEncoders() {
        return (rightBackEncoder.get());
    }
    public void getEncoders() {
        System.out.println(getRightEncoders() + " " + getLeftEncoders());
    }
}






