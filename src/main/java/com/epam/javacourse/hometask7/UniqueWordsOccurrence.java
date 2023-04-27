package com.epam.javacourse.hometask7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
For all the words in a text file calculate occurrence and save the result to HashMap.
 */
public class UniqueWordsOccurrence {
    public static void main(String[] args) {
        File file = new File("./src/main/resources/Words.txt");
        Map<String, Long> wordCounts = new HashMap<>();
        try(Scanner scanner = new Scanner(file)) {
            wordCounts = scanner.findAll("[a-zA-Z0-9-]+")
                    .map(matchResult -> matchResult.group().toLowerCase())
                    .collect(Collectors.groupingBy(
                            word -> word,
                            Collectors.counting()
                    ));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        wordCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
