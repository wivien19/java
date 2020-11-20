import java.util.Scanner;

/* Product - Motor */
class Motor {

    String model;
    long power;

    public Motor(String model, long power) {
        this.model = model;
        this.power = power;
    }

    @Override
    public String toString() {
        return  "motor={model:" + model + ",power:" + power + "}";
    }
}

class PneumaticMotor extends Motor {
    public PneumaticMotor(String model, long power) {
        super(model, power);
    }


    // write your code here ...
}

class HydraulicMotor extends Motor {
    public HydraulicMotor(String model, long power) {
        super(model, power);
    }
    // write your code here ...
}

class ElectricMotor extends Motor {
    public ElectricMotor(String model, long power) {
        super(model, power);
    }
    @Override
    public String toString() {
        return "Electric";
    }
    // write your code here ...
}

class WarpDrive extends Motor {
    public WarpDrive(String model, long power) {
        super(model, power);
    }


    // write your code here ...
}

class MotorFactory {

    /**
     * It returns an initialized motor according to the specified type by the first character:
     * 'P' or 'p' - pneumatic, 'H' or 'h' - hydraulic, 'E' or 'e' - electric, 'W' or 'w' - warp.
     */
    public static Motor make(char type, String model, long power) {
        // write your code here ...
        switch (Character.toLowerCase(type)){
            case 'p':

                Motor p = new PneumaticMotor(model, power);
                return p;

            case 'h':
                Motor h = new HydraulicMotor(model, power);
                return h;

            case 'e':
                Motor e = new ElectricMotor(model, power);
                return e;

            case 'w':
                Motor w = new WarpDrive(model, power);
                return w;

            default: return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final char type = scanner.next().charAt(0);
        final String model = scanner.next();
        final long power = scanner.nextLong();
        // write your code here ...
        scanner.close();
        Motor motor = new Motor(model, power);

        System.out.println("Electric" +" " + motor);
    }
}