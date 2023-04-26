package com.epam.javacourse.hometask8;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalInterfacesTask {
    public static void main(String[] args) {
        String word1 = "mama";
        String word2 = "amma";
        BinaryOperator<Integer> sumTwoNumbers = Integer::sum;
        Function<String, String> normalizeWord = w ->
            Arrays.stream(w.toLowerCase().split(""))
                    .sorted()
                    .collect(Collectors.joining());
        BiFunction<String, String, Boolean> isAnagram = (w1, w2) ->
                normalizeWord.apply(w1).equals(normalizeWord.apply(w2));

        System.out.println(sumTwoNumbers.apply(3, 6));
        System.out.println("Are " + word1 + " and " + word2 + " anagrams? " +
                isAnagram.apply(word1, word2));

        MyInteface<Integer> isDividedBy31 = n -> n % 31 == 0;

        System.out.println(isDividedBy31.apply(45));
        System.out.println(isDividedBy31.apply(62));
    }
}
