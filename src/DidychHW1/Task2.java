package HomeWork1;//Anastasiya Didych

import java.util.Scanner;

//Name and address

public class Task2
{
    public static void main(String[] args)
    {
        String name;
        String address;
        Scanner text = new Scanner(System.in);
        System.out.println("What is your name?");
        name = text.nextLine();
        System.out.println("Where are you live, " + name);
        address = text.nextLine();
        System.out.println("Your name is " + name + " and you live at " + address);

    }


}
