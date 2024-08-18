import java.util.Scanner;

class Dialgauge {
    private double[] a, b;
    private int n;
    private Scanner scanner;

    public Dialgauge() {
        scanner = new Scanner(System.in);
    }

    public void gvt() {
        System.out.println("No of measured values:");
        n = scanner.nextInt();
        a = new double[n];
        b = new double[n];
    }

    public void forward() {
        System.out.println("Enter forward measurements:");
        for (int i = 0; i < n; i++) {
            System.out.println("Forward-" + (i + 1) + ":");
            a[i] = scanner.nextDouble();
        }
    }

    public void reverse() {
        System.out.println("Enter reverse measurements:");
        for (int i = 0; i < n; i++) {
            System.out.println("Reverse-" + (i + 1) + ":");
            b[i] = scanner.nextDouble();
        }
    }

    public void error() {
        double[] errorForward = new double[n];
        double[] errorReverse = new double[n];

        // Calculate forward and reverse errors
        for (int i = 0; i < n; i++) {
            errorForward[i] = a[i] - (i + 1);
            errorReverse[i] = b[i] - (i + 1);
        }

        // Print forward errors
        System.out.println("Error in Forward Measurements:");
        for (double ele : errorForward) {
            System.out.println(ele);
        }

        // Print reverse errors
        System.out.println("Error in Reverse Measurements:");
        for (double ele : errorReverse) {
            System.out.println(ele);
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}

public class Main2 {
    public static void main(String[] args) {
        Dialgauge calibration = new Dialgauge();
        calibration.gvt();
        calibration.forward();
        calibration.reverse();
        calibration.error();
        //calibration.closeScanner();
    }
}
