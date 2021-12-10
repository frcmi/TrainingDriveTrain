package frc.robot.subsystems;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;

public class Encoders extends SubsystemBase {
    public static final double kDistancePerRevolution = 18.84;  
    public static final double kPulsesPerRevolution = 1024;     
    public static final double kDistancePerPulse = kDistancePerRevolution / kPulsesPerRevolution;
    private Encoder leftFrontEncoder = new Encoder(1, 2, false, EncodingType.k4X);
    private Encoder rightFrontEncoder = new Encoder(3, 4, true, EncodingType.k4X);
    private Encoder leftBackEncoder = new Encoder(5, 6, false, EncodingType.k4X);
    private Encoder rightBackEncoder = new Encoder(7, 8, true, EncodingType.k4X);
    //create encoders for each motor and write methods to get values from each encoder   
    public void robotInit() {
        leftFrontEncoder.setDistancePerPulse(kDistancePerPulse);
        rightFrontEncoder.setDistancePerPulse(kDistancePerPulse);
        leftBackEncoder.setDistancePerPulse(kDistancePerPulse);
        rightBackEncoder.setDistancePerPulse(kDistancePerPulse);
        resetEncoders();
    }
    private void resetEncoders() {
        leftFrontEncoder.reset();
        rightFrontEncoder.reset();
        leftBackEncoder.reset();
        rightBackEncoder.reset();
    }
    public double getLeftEncoders() {
        return ((leftFrontEncoder.get() + leftBackEncoder.get()) / 2);
    }
    public double getRightEncoders() {
        return ((rightFrontEncoder.get() + rightBackEncoder.get()) / 2);
    }
    public void teleopPeriodic() {
        System.out.println(getRightEncoders() + getLeftEncoders());
    }
}






