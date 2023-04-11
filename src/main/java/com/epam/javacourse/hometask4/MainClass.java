package com.epam.javacourse.hometask4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

    private static Path path = Path.of("./src/main/resources/Greenhouse.txt");
    private static String optionDoesNotExistMessage = "That option does not exist.";
    private static String noPlantsMessage = "No plants in the greenhouse. Add first.";
    public static void main(String[] args) {

        String mainMenu = """
                
                1 - Add a new plant
                2 - Remove a plant
                3 - Find a plant
                4 - Quit
                
                Please, enter your option:""";

        Scanner scanner = new Scanner(System.in);
        Greenhouse greenhouse = new Greenhouse();
        System.out.println(mainMenu);
        while (scanner.hasNext()) {
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        addANewPlant(scanner, greenhouse);
                        writeToFile(greenhouse);
                        break;
                    case 2:
                        removeAPlant(scanner, greenhouse);
                        writeToFile(greenhouse);
                        break;
                    case 3:
                        findAPlant(scanner, greenhouse);
                        break;
                    case 4:
                        scanner.close();
                        return;
                    default:
                        throw new IllegalOptionException();
                }
            } catch (IllegalOptionException | InputMismatchException e) {
                System.err.println(optionDoesNotExistMessage);
                scanner.nextLine();
            }
            System.out.println(mainMenu);
        }
    }

    private static void addANewPlant(Scanner sc, Greenhouse gr) {
        sc.nextLine();
        System.out.println("Enter plant name: ");
        String name = sc.nextLine();
        System.out.println("Enter plant type: ");
        String type = sc.nextLine();
        System.out.println("Enter plant native region: ");
        String nativeRegion = sc.nextLine();
        gr.buyNewPlant(Houseplant.create()
                .withName(name)
                .withType(type)
                .withNativeRegion(nativeRegion)
                .build());
    }

    private static void removeAPlant(Scanner sc, Greenhouse gr) {
        Plant[] res;
        try {
            res = gr.get();
        } catch (EmptyArrayException e) {
            System.err.println(noPlantsMessage);
            return;
        }
        System.out.println("You have following plants in the greenhouse: ");
        for (int i = 0; i < res.length; i++) {
            System.out.println(i + ": " + res[i]);
        }
        System.out.println("Choose number of plant you want to remove: ");
        try {
            gr.removePlant(res[sc.nextInt()]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(optionDoesNotExistMessage);
        }
    }

    private static void findAPlant(Scanner sc, Greenhouse gr) {
        Plant[] res;
        String menu = """
                Choose parameter for searching:
                1 - by type
                2 - by native region""";
        System.out.println(menu);
        try {
            switch (sc.nextInt()) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter type: ");
                    try {
                        res = gr.getPlantsWithType(sc.nextLine());
                    } catch (EmptyArrayException e) {
                        System.err.println(noPlantsMessage);
                        return;
                    }
                    for (Plant p : res) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter region: ");
                    try {
                        res = gr.getPlantsWithNativeRegion(sc.nextLine());
                    } catch (EmptyArrayException e) {
                        System.err.println(noPlantsMessage);
                        return;
                    }
                    for (Plant p : res) {
                        System.out.println(p);
                    }
                    break;
                default:
                    throw new IllegalOptionException();
            }
        } catch (IllegalOptionException | InputMismatchException e) {
            System.err.println(optionDoesNotExistMessage);
            sc.nextLine();
        }
    }

    private static void writeToFile(Greenhouse gr) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write(gr.toString());
        } catch (IOException e) {
            System.err.println("Can't write to the file");
        }
    }
}