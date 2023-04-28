package com.epam.javacourse.hometask10.task;

import com.epam.javacourse.hometask10.base.Queries;
import com.epam.javacourse.hometask10.base.dao.GardenerDao;
import com.epam.javacourse.hometask10.base.dao.GreenhouseDao;
import com.epam.javacourse.hometask10.base.dao.PlantsDao;
import com.epam.javacourse.hometask10.base.models.Gardener;
import com.epam.javacourse.hometask10.base.models.Greenhouse;
import com.epam.javacourse.hometask10.base.models.Plant;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DbProgram {

    private static Scanner scanner;
    private static final String OPTION_DOES_NOT_EXIST_MESSAGE = "That option does not exist.";
    private static final String TABLE_MENU = """
                Choose table:
                1 - gardeners
                2 - greenhouses
                3 - plants""";
    private static final String GET_MENU = """
                1 - get all records
                2 - get records between
                3 - get records in
                4 - get records like""";

    public static void main(String[] args) {
        String mainMenu = """
                
                1 - ADD new record to the table
                2 - UPDATE record in the table
                3 - DELETE record from the table
                4 - SELECT record(s) from the table
                5 - Get all records from all the tables
                6 - Get number of records in all the tables
                7 - Get plants count in the greenhouses
                8 - Quit
                
                Please, enter your option:""";

        scanner = new Scanner(System.in);
        System.out.println(mainMenu);
        while (scanner.hasNext()) {
            try {
                switch (scanner.nextInt()) {
                    case 1 -> addNewRecord();
                    case 2 -> updateRecord();
                    case 3 -> deleteRecord();
                    case 4 -> getRecords();
                    case 5 -> new Queries().joinAllTheTables();
                    case 6 -> System.out.println(new Queries().getNumberOfRecords());
                    case 7 -> new Queries().getPlantsCountInTheGreenhouse().forEach(System.out::println);
                    case 8 -> {
                        scanner.close();
                        return;
                    }
                    default -> throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.err.println(OPTION_DOES_NOT_EXIST_MESSAGE);
                scanner.nextLine();
            }
            System.out.println(mainMenu);
        }
    }

    private static void addNewRecord() {
        int id;
        String name;
        String type;
        int foreignId;
        System.out.println(TABLE_MENU);
        try {
            switch (scanner.nextInt()) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.println("Enter id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name: ");
                    name = scanner.nextLine();
                    new GardenerDao().add(new Gardener(id, name));
                }
                case 2 -> {
                    scanner.nextLine();
                    System.out.println("Enter id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter gardener id: ");
                    foreignId = scanner.nextInt();
                    new GreenhouseDao().add(new Greenhouse(id, name, foreignId));
                }
                case 3 -> {
                    scanner.nextLine();
                    System.out.println("Enter id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter type: ");
                    type = scanner.nextLine();
                    System.out.println("Enter greenhouse id: ");
                    foreignId = scanner.nextInt();
                    new PlantsDao().add(new Plant(id, name, type, foreignId));
                }
                default -> throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println(OPTION_DOES_NOT_EXIST_MESSAGE);
            scanner.nextLine();
        }
    }

    private static void updateRecord() {
        String column;
        String stringValue;
        int intValue;
        System.out.println(TABLE_MENU);
        try {
            switch (scanner.nextInt()) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.println("Enter column name: ");
                    column = scanner.nextLine();
                    System.out.println("Enter new value: ");
                    if (column.contains("id")) {
                        intValue = scanner.nextInt();
                        scanner.nextLine();
                        new GardenerDao().update(column, intValue);
                    } else {
                        stringValue = scanner.nextLine();
                        new GardenerDao().update(column, stringValue);
                    }
                }
                case 2 -> {
                    scanner.nextLine();
                    System.out.println("Enter column name: ");
                    column = scanner.nextLine();
                    System.out.println("Enter new value: ");
                    if (column.contains("id")) {
                        intValue = scanner.nextInt();
                        scanner.nextLine();
                        new GreenhouseDao().update(column, intValue);
                    } else {
                        stringValue = scanner.nextLine();
                        new GreenhouseDao().update(column, stringValue);
                    }
                }
                case 3 -> {
                    scanner.nextLine();
                    System.out.println("Enter column name: ");
                    column = scanner.nextLine();
                    System.out.println("Enter new value: ");
                    if (column.contains("id")) {
                        intValue = scanner.nextInt();
                        scanner.nextLine();
                        new PlantsDao().update(column, intValue);
                    } else {
                        stringValue = scanner.nextLine();
                        new PlantsDao().update(column, stringValue);
                    }
                }
                default -> throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println(OPTION_DOES_NOT_EXIST_MESSAGE);
            scanner.nextLine();
        }
    }

    private static void deleteRecord() {
        String column;
        String stringValue;
        int intValue;
        String submenu = """
                Do you want delete all records in the table?
                1 - yes
                2 - no""";
        System.out.println(TABLE_MENU);
        try {
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println(submenu);
                    switch (scanner.nextInt()) {
                        case 1 -> new GardenerDao().truncate();
                        case 2 -> {
                            scanner.nextLine();
                            System.out.println("Enter column name: ");
                            column = scanner.nextLine();
                            System.out.println("Enter new value: ");
                            if (column.contains("id")) {
                                intValue = scanner.nextInt();
                                scanner.nextLine();
                                new GardenerDao().delete(column, intValue);
                            } else {
                                stringValue = scanner.nextLine();
                                new GardenerDao().delete(column, stringValue);
                            }
                        }
                        default -> throw new InputMismatchException();
                    }
                }
                case 2 -> {
                    System.out.println(submenu);
                    switch (scanner.nextInt()) {
                        case 1 -> new GreenhouseDao().truncate();
                        case 2 -> {
                            scanner.nextLine();
                            System.out.println("Enter column name: ");
                            column = scanner.nextLine();
                            System.out.println("Enter new value: ");
                            if (column.contains("id")) {
                                intValue = scanner.nextInt();
                                scanner.nextLine();
                                new GreenhouseDao().delete(column, intValue);
                            } else {
                                stringValue = scanner.nextLine();
                                new GreenhouseDao().delete(column, stringValue);
                            }
                        }
                        default -> throw new InputMismatchException();
                    }
                }
                case 3 -> {
                    System.out.println(submenu);
                    switch (scanner.nextInt()) {
                        case 1 -> new PlantsDao().truncate();
                        case 2 -> {
                            scanner.nextLine();
                            System.out.println("Enter column name: ");
                            column = scanner.nextLine();
                            System.out.println("Enter new value: ");
                            if (column.contains("id")) {
                                intValue = scanner.nextInt();
                                scanner.nextLine();
                                new PlantsDao().delete(column, intValue);
                            } else {
                                stringValue = scanner.nextLine();
                                new PlantsDao().delete(column, stringValue);
                            }
                        }
                        default -> throw new InputMismatchException();
                    }
                }
                default -> throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println(OPTION_DOES_NOT_EXIST_MESSAGE);
            scanner.nextLine();
        }
    }

    private static void getRecords() {
        System.out.println(TABLE_MENU);
        try {
            switch (scanner.nextInt()) {
                case 1 -> getGardener().forEach(System.out::println);
                case 2 -> getGreenhouse().forEach(System.out::println);
                case 3 -> getPlants().forEach(System.out::println);
                default -> throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println(OPTION_DOES_NOT_EXIST_MESSAGE);
            scanner.nextLine();
        }
    }

    private static List<Gardener> getGardener() {
        String columnName;
        List<Gardener> result = null;
        System.out.println(GET_MENU);
        try {
            switch (scanner.nextInt()) {
                case 1 -> result = new GardenerDao().getAll();
                case 2 -> {
                    int start;
                    int end;
                    scanner.nextLine();
                    System.out.println("Enter integer column name: ");
                    columnName = scanner.nextLine();
                    System.out.println("Enter start value: ");
                    start = scanner.nextInt();
                    System.out.println("Enter end value: ");
                    end = scanner.nextInt();
                    result = new GardenerDao().getBetween(columnName, start, end);
                }
                case 3 -> {
                    List<String> list = new ArrayList<>();
                    scanner.nextLine();
                    System.out.println("Enter column name: ");
                    columnName = scanner.nextLine();
                    System.out.println("Enter list ('exit' to end entering): ");
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        if (line.equals("exit")) {
                            break;
                        } else {
                            list.add(line);
                        }
                    }
                    result = new GardenerDao().getIn(columnName, list);
                }
                case 4 -> {
                    String pattern;
                    scanner.nextLine();
                    System.out.println("Enter column name: ");
                    columnName = scanner.nextLine();
                    System.out.println("Enter pattern: ");
                    pattern = scanner.nextLine();
                    result = new GardenerDao().getLike(columnName, pattern);
                }
                default -> throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println(OPTION_DOES_NOT_EXIST_MESSAGE);
            scanner.nextLine();
        }
        return result;
    }

    private static List<Greenhouse> getGreenhouse() {
        String columnName;
        List<Greenhouse> result = null;
        System.out.println(GET_MENU);
        try {
            switch (scanner.nextInt()) {
                case 1 -> result = new GreenhouseDao().getAll();
                case 2 -> {
                    int start;
                    int end;
                    scanner.nextLine();
                    System.out.println("Enter integer column name: ");
                    columnName = scanner.nextLine();
                    System.out.println("Enter start value: ");
                    start = scanner.nextInt();
                    System.out.println("Enter end value: ");
                    end = scanner.nextInt();
                    result = new GreenhouseDao().getBetween(columnName, start, end);
                }
                case 3 -> {
                    List<String> list = new ArrayList<>();
                    scanner.nextLine();
                    System.out.println("Enter column name: ");
                    columnName = scanner.nextLine();
                    System.out.println("Enter list ('exit' to end entering): ");
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        if (line.equals("exit")) {
                            break;
                        } else {
                            list.add(line);
                        }
                    }
                    result = new GreenhouseDao().getIn(columnName, list);
                }
                case 4 -> {
                    String pattern;
                    scanner.nextLine();
                    System.out.println("Enter column name: ");
                    columnName = scanner.nextLine();
                    System.out.println("Enter pattern: ");
                    pattern = scanner.nextLine();
                    result = new GreenhouseDao().getLike(columnName, pattern);
                }
                default -> throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println(OPTION_DOES_NOT_EXIST_MESSAGE);
            scanner.nextLine();
        }
        return result;
    }

    private static List<Plant> getPlants() {
        String columnName;
        List<Plant> result = null;
        System.out.println(GET_MENU);
        try {
            switch (scanner.nextInt()) {
                case 1 -> result = new PlantsDao().getAll();
                case 2 -> {
                    int start;
                    int end;
                    scanner.nextLine();
                    System.out.println("Enter integer column name: ");
                    columnName = scanner.nextLine();
                    System.out.println("Enter start value: ");
                    start = scanner.nextInt();
                    System.out.println("Enter end value: ");
                    end = scanner.nextInt();
                    result = new PlantsDao().getBetween(columnName, start, end);
                }
                case 3 -> {
                    List<String> list = new ArrayList<>();
                    scanner.nextLine();
                    System.out.println("Enter column name: ");
                    columnName = scanner.nextLine();
                    System.out.println("Enter list ('exit' to end entering): ");
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        if (line.equals("exit")) {
                            break;
                        } else {
                            list.add(line);
                        }
                    }
                    result = new PlantsDao().getIn(columnName, list);
                }
                case 4 -> {
                    String pattern;
                    scanner.nextLine();
                    System.out.println("Enter column name: ");
                    columnName = scanner.nextLine();
                    System.out.println("Enter pattern: ");
                    pattern = scanner.nextLine();
                    result = new PlantsDao().getLike(columnName, pattern);
                }
                default -> throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println(OPTION_DOES_NOT_EXIST_MESSAGE);
            scanner.nextLine();
        }
        return result;
    }
}
