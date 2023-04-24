package com.epam.javacourse.hometask7;

import java.util.HashSet;
import java.util.Set;

/*
Create two sets with numbers. Create methods to join the sets and define intersection.
 */
public class SetsWithNumbers {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        Set<Integer> set3 = new HashSet<>();
        set3.add(4);
        set3.add(5);
        set3.add(6);
        set3.add(7);

        Set<Integer> set4 = new HashSet<>(joinSets(set1, set2));
        System.out.printf("Join: %s%n", set4);

        System.out.println("-------------");

        Set<Integer> set5 = new HashSet<>(intersectSets(set2, set3));
        System.out.printf("Intersection: %s%n", set5);
    }

    private static Set<Integer> joinSets (Set<Integer> s1, Set<Integer> s2) {
        s1.addAll(s2);
        return s1;
    }

    private static Set<Integer> intersectSets (Set<Integer> s1, Set<Integer> s2) {
        s1.retainAll(s2);
        return s1;
    }
}
