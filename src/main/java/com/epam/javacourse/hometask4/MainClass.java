package com.epam.javacourse.hometask4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        String menu = "1 - Add a new plant\n" +
                "2 - Remove a plant\n" +
                "3 - Find a plant\n" +
                "4 - Quit\n";

        Scanner scanner = new Scanner(System.in);
        Greenhouse greenhouse = new Greenhouse();
        MainClass mainClass = new MainClass();
        Path path = Path.of("./src/main/resources/Greenhouse.txt");
        System.out.println(menu + "Please, enter your option: ");
        while (scanner.hasNext()) {
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        mainClass.addANewPlant(scanner, greenhouse);
                        try {
                            Files.write(path, greenhouse.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
                        } catch (IOException e) {
                            throw new RuntimeException();
                        }
                        break;
                    case 2:
                        mainClass.removeAPlant(scanner, greenhouse);
                        try {
                            Files.write(path, greenhouse.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
                        } catch (IOException e) {
                            throw new RuntimeException();
                        }
                        break;
                    case 3:
                        mainClass.findAPlant(scanner, greenhouse);
                        break;
                    case 4:
                        return;
                    default:
                        throw new IllegalOptionException();
                }
            } catch (IllegalOptionException e) {
                e.printStackTrace();
                System.err.println("That option does not exist.");
            }
            System.out.println(menu + "Please, enter your option: ");
        }
    }

    private void addANewPlant(Scanner sc, Greenhouse gr) {
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

    private void removeAPlant(Scanner sc, Greenhouse gr) {
        Plant[] res;
        try {
            res = gr.get();
        } catch (EmptyArrayException e) {
            e.printStackTrace();
            System.err.println("No plants to remove");
            return;
        }
        System.out.println("You have following plants in the greenhouse: ");
        for (int i = 0; i < res.length; i++) {
            System.out.println(i + ": " + res[i]);
        }
        System.out.println("Choose number of plant you want to remove: ");
            gr.removePlant(res[sc.nextInt()]);
    }

    private void findAPlant(Scanner sc, Greenhouse gr) {
        Plant[] res;
        String menu = "1 - by type\n" +
                "2 - by native region\n";
        System.out.println("Choose parameter for searching: \n" + menu);
        try {
            switch (sc.nextInt()) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter type: ");
                    try {
                        res = gr.getPlantsWithType(sc.nextLine());
                    } catch (EmptyArrayException e) {
                        System.out.println("No plants in the greenhouse. Add first");
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
                        System.out.println("No plants in the greenhouse. Add first");
                        return;
                    }
                    for (Plant p : res) {
                        System.out.println(p);
                    }
                    break;
                default:
                    throw new IllegalOptionException();
            }
        } catch (IllegalOptionException e) {
            e.printStackTrace();
            System.err.println("That option does not exist.");
        }
    }
}