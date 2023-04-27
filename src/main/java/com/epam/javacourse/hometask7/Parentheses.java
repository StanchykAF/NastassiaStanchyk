package com.epam.javacourse.hometask7;

import java.util.Stack;
import java.util.stream.Collector;

/*
In a string with "(" and ")" only check if parentheses are placed correctly.
 */

public class Parentheses {
    public static void main(String[] args) {
        String parenthesesString = "(fdgkl((thkl)(gfdfg))(o;lgfhd))";
        if (checkParentheses(parenthesesString.replaceAll("[^(|)]", ""))) {
            System.out.println("The parentheses are placed correctly.");
        } else {
            System.out.println("The parentheses are not placed correctly.");
        }
    }

    private static boolean checkParentheses(String parenthesesString) {
        int open = parenthesesString.chars().filter(c -> c == '(')
                        .mapToObj(c -> (char) c)
                        .toList().size();
        int close = parenthesesString.chars().filter(c -> c == ')')
                        .mapToObj(c -> (char) c)
                        .toList().size();
        return open == close;
    }
}