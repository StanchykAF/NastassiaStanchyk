package com.epam.javacourse.hometask2;

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.
 */

import java.util.Scanner;

public class MySqrt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        int num = 0;
        while (true) {
            if (((num * num) <= x) && (x < ((num + 1) * (num + 1)))) {
                return num;
            } else {
                num++;
            }
        }
    }
}
