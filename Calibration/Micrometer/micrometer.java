/*import java.util.Scanner;

class Micrometer {
    Double sum = 0.0, avg = 0.0;
    Double rss, acc, nss, ass, ucc, t1, t2, b, sd, ua, l, m, m1;
    Double ub1, ub2, ub3, ub4, ub5, ub6, ub7, ub8, ub9, ub10, uc1, ue;
    int n;
    Double[] a;
    public void svt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Resolution of Micrometer:");
        rss = scanner.nextDouble();

        System.out.println("Accuracy of the Micrometer:");
        acc = scanner.nextDouble();

        System.out.println("Nominal size of slip gauge:");
        nss = scanner.nextDouble();

        System.out.println("Actual length of Micrometer:");
        ass = scanner.nextDouble();

        System.out.println("Uncertainty of calibration:");
        ucc = scanner.nextDouble();

        System.out.println("Temperature at start of experiment:");
        t1 = scanner.nextDouble();

        System.out.println("Temperature at end of experiment:");
        t2 = scanner.nextDouble();

        System.out.println("Number of measured values:");
        n = scanner.nextInt();
        a = new Double[n];  // Initialize array with size n

        System.out.println("Enter the Master value:");
        b = scanner.nextDouble();

        System.out.println("Enter the wavelength value:");
        l= scanner.nextDouble();

        System.out.println("Enter the no of dark fringes(Parallelsim):");
        m= scanner.nextDouble();

        System.out.println("Enter the no of dark fringes(Flatness):");
        m1= scanner.nextDouble();

    }

    public void gvt() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ":");
            a[i] = scanner.nextDouble() + b;
            sum += a[i];
        }
    }

    public void typeA() {
        sum /= n;
        for (int i = 0; i < n; i++) {
            a[i] -= sum;  // xi - xbar
        }
        for (int i = 0; i < n; i++) {
            a[i] = a[i] * a[i];  // Square of xi - xbar
            avg += a[i];
        }
        sd = Math.sqrt(avg / (n - 1));  // Standard Deviation
        ua = (sd / Math.sqrt(n)) * 1000;  // Type A uncertainty in micrometers
        System.out.println("SD   : "+sd);
        System.out.println("Ua   : "+ua);
    }

    public void ub1() {
        ub1 = (b*1000) / 2;
        System.out.println("Ub1  : " + ub1);
    }

    public void ub2() {
        ub2 = ucc / 2;
        System.out.println("Ub2  : " + ub2);
    }

    public void ub3() {
        ub3 = (((Math.abs(t2 - t1)) * (nss / 1000) * (11.5)) / (Math.sqrt(3)));
        System.out.println("Ub3  : " + ub3);
    }

    public void ub4() {
        ub4 = (Math.abs((20 - (t1 + t2) / 2)) * (nss / 1000) * (11.5)) / (Math.sqrt(3));
        System.out.println("Ub4  : " + ub4);
    }

    public void ub5() {
        ub5 = (0.2 * ub4);//ub5--->20%of ub4
        System.out.println("Ub5  : " + ub5);
    }

    public void ub6() {
        ub6 = (((Math.abs(t1 - t2)) * (nss / 1000) * (11.5)) / (Math.sqrt(3)));//the co-efficient of thermal expansion of steel is 11.5.
        System.out.println("Ub6  : " + ub6);
    }

    public void ub7() {
        ub7 = acc / Math.sqrt(3);
        System.out.println("Ub7  : " + ub7);
    }

    public void ub8() {
        ub8 = (2*m*(l/2))/(Math.sqrt(3));
        System.out.println("Ub8  : " + ub7);
    }

    public void ub9() {
        ub9 = (2*(m1)*(l/2))/(Math.sqrt(3));
        System.out.println("Ub8  : " + ub7);
    }

    public void ub10() {
        ub10 = ((0.5 * (rss / 1000)) / (Math.sqrt(3)));//Hear /1000 is convert (mm-->meter)
        System.out.println("Ub10 : " + ub10);
    }

    public void uc1() {
        Double add = Math.pow(ub1, 2) + Math.pow(ub2, 2) + Math.pow(ub3, 2) + Math.pow(ub4, 2) +
                Math.pow(ub5, 2) + Math.pow(ub6, 2) + Math.pow(ub7, 2) + Math.pow(ub10, 2);
        uc1 = Math.sqrt(add);
        System.out.println("Uc   : " + uc1);
    }

    public void veff() {
        int vef = (int) ((Math.pow(uc1, 4)) / ((Math.pow(ua, 4)) / 9));
        System.out.println("Ve   : " + vef);
    }

    public void typeB() {
        ue = uc1 * 1.96;//By ising table to get 1.96 value
        System.out.println("Ue   : " + ue);
    }
}

class Main1 {
    public static void main(String[] args) {
        Micrometer calibration = new Micrometer();
        calibration.svt();
        calibration.gvt();
        //Type A Uncertainty
        calibration.typeA();
        //Uncertainty due to difference in size
        calibration.ub1();
        //Uncertainty due to calibration
        calibration.ub2();
        //Uncertainty due to resolution of thermometer
        calibration.ub3();
        //Uncertainty due to difference in standard temp and average temp.
        calibration.ub4();
        //Uncertainty due to yemp difference in vernier and slip gauge(co-efficient of thermail expansion)
        calibration.ub5();
        //Uncertainty due to temp difference in vernier and slip gauge
        calibration.ub6();
        //Uncertainty due to accruacy of vernier caliper
        calibration.ub7();
        //Uncertainty due to parallrlism error
        calibration.ub8();
        //Uncertainty due to flatness error
        calibration.ub9();
        //uncertainty due to resolution of the vernier caliper
        calibration.ub10();
        //Combained uncertainty
        calibration.uc1();
        //Effective number of freedom
        calibration.veff();
        //Type B uncertainty
        calibration.typeB();
    }
}
This code calculates various types of uncertainties related to the measurement using a Micrometer.
All uncertainties are expressed in micrometers. It first reads the relevant inputs, such as the resolution of
the Micrometer, accuracy, and other measurement parameters. It calculates Type A uncertainty based on the
standard deviation of measured values and converts this into micrometers. For Type B uncertainties, it evaluates
contributions from size differences, calibration, resolution, temperature effects, and the accuracy of the Micrometer,
all in micrometers. The combined uncertainty is determined by summing the squares of all individual
uncertainties and taking the square root. Finally, it computes the effective degrees of freedom and the
expanded uncertainty at a 95% confidence level*/
