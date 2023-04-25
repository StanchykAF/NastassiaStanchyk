package com.epam.javacourse.hometask8;

import java.util.Arrays;
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

        System.out.println(sumTwoNumbers.apply(3, 6));
        System.out.println("Are " + word1 + " and " + word2 + " anagrams? " +
                normalizeWord.apply(word1).equals(normalizeWord.apply(word2)));
    }
}
