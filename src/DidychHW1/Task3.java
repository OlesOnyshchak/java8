package HomeWork1;//Anastasiya Didych

import java.util.Locale;
import java.util.Scanner;

public class Task3
{
    public static void main(String[] args)
    {
        double t1, t2, t3;
        double c1, c2, c3;
        double p1, p2, p3, sum;
        Scanner value = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Please, enter per-minute payment for thee calls: ");
        c1 = value.nextDouble();
        c2 = value.nextDouble();
        c3 = value.nextDouble();
        System.out.println("Please, enter the call duration from each country: ");
        t1 = value.nextDouble();
        t2 = value.nextDouble();
        t3 = value.nextDouble();
        p1 = c1 * t1;
        p2 = c2 * t2;
        p3 = c3 * t3;
        sum = p1 + p2 + p3;
        System.out.println("Payment for the first call: " + p1);
        System.out.println("Payment for the second call: " + p2);
        System.out.println("Payment for the third call: " + p3);
        System.out.println("Payment for all calls: " + sum);
    }
}
