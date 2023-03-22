package com.epam.javacourse.hometask2;

/*
Fizz-buzz: show 'fizz' if a number divisible by 3, show 'buzz' if a number
divisible by 5, show 'fizz-buzz' if a number divisible by both 3 and 5
 */

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("fizz-buzz");
        } else if (n % 3 == 0) {
            System.out.println("fizz");
        } else if (n % 5 == 0) {
            System.out.println("buzz");
        }
    }
}
