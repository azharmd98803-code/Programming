package Javaproject;

import java.util.Scanner;

class Fact {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
          double n = sc.nextInt();

        double fact = 1;

        for (double i = 1; i <= n; i++) {
            fact = fact * i;
        }

        System.out.println("Factorial is " + fact);
    }
}