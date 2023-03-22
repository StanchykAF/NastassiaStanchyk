package com.epam.javacourse.hometask2;

import java.util.Scanner;

/*
Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        for(int i = 0; i < number.length()/2; i++) {
            if(number.charAt(i) != number.charAt(number.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
