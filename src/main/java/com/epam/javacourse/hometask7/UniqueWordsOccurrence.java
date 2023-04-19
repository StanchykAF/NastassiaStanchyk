package com.epam.javacourse.hometask7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
For all the words in a text file calculate occurrence and save the result to HashMap.
 */
public class UniqueWordsOccurrence {
    public static void main(String[] args) {
        File file = new File("./src/main/resources/Words.txt");
        Map<String, Integer> wordCounts = new HashMap<>();
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z0-9-]", "");
                if (wordCounts.containsKey(word)) {
                    wordCounts.put(word, wordCounts.get(word) + 1);
                } else {
                    wordCounts.put(word, 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        System.out.println("Word occurrences in file:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
