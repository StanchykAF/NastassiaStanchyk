package com.epam.javacourse.hometask2;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int[] fibonacciN = new int[n];
        fibonacciN[0] = 0;
        fibonacciN[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacciN[i] = fibonacciN[i - 1] + fibonacciN[i - 2];
        }
        for (int num : fibonacciN) {
            System.out.print(num + " ");
        }
    }
}
