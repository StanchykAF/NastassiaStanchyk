package com.epam.javacourse.hometask7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

/*
Read strings from file to list and write them  back to file in an opposite order
 */

public class OppositeOrder {
    private static final Path PATH = Path.of("./src/main/resources/OppositeOrder.txt");

    public static void main(String[] args) {
        List<String> linesFromFile = readFromFile();
        writeToFile(linesFromFile);
    }

    private static List<String> readFromFile() {
        try {
            return Files.readAllLines(PATH);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
    }

    private static void writeToFile(List<String> lines) {
        Collections.reverse(lines);
        try(BufferedWriter writer = Files.newBufferedWriter(PATH, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }
}
