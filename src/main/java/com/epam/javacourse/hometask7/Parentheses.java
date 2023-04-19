package com.epam.javacourse.hometask7;

import java.util.Stack;

/*
In a string with "(" and ")" only check if parentheses are placed correctly.
 */

public class Parentheses {
    public static void main(String[] args) {
        String parenthesesString = "(fdgkl((thkl)(gfdfg))(o;lgfhd))";
        if (checkParentheses(parenthesesString.replaceAll("[^(\\(|\\))]", ""))) {
            System.out.println("The parentheses are placed correctly.");
        } else {
            System.out.println("The parentheses are not placed correctly.");
        }
    }

    private static boolean checkParentheses(String parenthesesString) {
        Stack<Character> parenthesesStack = new Stack<>();
        for (int i = 0; i < parenthesesString.length(); i++) {
            char ch = parenthesesString.charAt(i);
            if (ch == '(') {
                parenthesesStack.push(ch);
            } else if (ch == ')') {
                if (parenthesesStack.isEmpty() || parenthesesStack.pop() != '(') {
                    return false;
                }
            }
        }
        return parenthesesStack.isEmpty();
    }
}