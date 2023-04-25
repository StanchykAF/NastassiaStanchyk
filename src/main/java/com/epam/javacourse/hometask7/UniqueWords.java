package com.epam.javacourse.hometask7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/*
Find all the unique words in a text file. Use HashSet.
 */
public class UniqueWords {

    public static void main(String[] args) {
        File file = new File("./src/main/resources/Words.txt");
        Set<String> uniqueWords = new HashSet<>();
        try(Scanner scanner = new Scanner(file)) {
            uniqueWords = scanner.findAll("[a-zA-Z0-9-]+")
                    .map(matchResult -> matchResult.group().toLowerCase())
                    .collect(Collectors.toSet());
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        System.out.println("Unique words in file:");
        uniqueWords.forEach(System.out::println);
    }
}
