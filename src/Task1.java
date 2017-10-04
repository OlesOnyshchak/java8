package HomeWork1;//Anastasiya Didych

import java.util.Scanner;

//Calculation of the perimeter and area of a circle bed

public class Task1
{
    public static void main(String[] args)
    {
        int R;
        double P, A;
        Scanner Radius = new Scanner(System.in);
        System.out.println("Please, enter the radius of your bed: ");
        R = Radius.nextInt();
        P = 2 * Math.PI * R;
        A = Math.PI * R * R;
        System.out.println("The perimeter of your bed is " + P + "\nAnd the area is " + A);
    }
}
