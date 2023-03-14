package com.epam.javacourse.hometask2;

import java.util.Scanner;

/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        String substring = string.substring(string.lastIndexOf(' ') + 1);
        System.out.println(substring.length());
    }
}
