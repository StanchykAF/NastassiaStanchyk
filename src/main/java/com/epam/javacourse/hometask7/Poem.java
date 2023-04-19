package com.epam.javacourse.hometask7;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Save poem in a list of strings, sort the strings by its length
 */
public class Poem {
    public static void main(String[] args) {
        List<String> poem = Arrays.asList(
                "I come with no wrapping or pretty pink bows.",
                "I am who I am, from my head to my toes.",
                "I tend to get loud when speaking my mind.",
                "Even a little crazy some of the time.",
                "I'm not a size 5 and don't care to be.",
                "You can be you and I can be me.",
                "I try to stay strong when pain knocks me down.",
                "And the times that I cry are when no one's around.",
                "To error is human or so that's what they say.",
                "Well, tell me who's perfect anyway."
        );

        Collections.sort(poem, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String s : poem) {
            System.out.println(s.length() + ": " + s);
        }
    }
}
