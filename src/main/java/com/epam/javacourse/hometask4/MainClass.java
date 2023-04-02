package com.epam.javacourse.hometask4;

public class MainClass {
    public static void main(String[] args) {
        Plant vasya = new Houseplant("Vasya", "sukkulent", "Africa", 14, 10);
        Plant petya = new Houseplant("Petya", "sukkulent", "Africa", 14, 15);
        Plant adams = new Shrub("Adams", "rose", "North America", 5);
        Plant[] plants = {vasya, petya, adams};
        Greenhouse greenhouse = new Greenhouse(plants);

        Plant[] results = greenhouse.getPlantsWithType("sukkulent");
        for (Plant p: results) {
            System.out.println(p);
        }

        greenhouse.buyNewPlant(new FloweringPlant("Fialka", "flower", "Europe", 3, true));

        System.out.println();
        results = greenhouse.getPlantsInTheGreenhouse();
        for (Plant p: results) {
            System.out.println(p);
        }

        System.out.println();
        results = greenhouse.getPlantsWithNativeRegion("Europe");
        for (Plant p: results) {
            System.out.println(p);
        }

        greenhouse.removePlant(petya);
        greenhouse.waterPlant(vasya);

        System.out.println();
        results = greenhouse.getPlantsInTheGreenhouse();
        for (Plant p: results) {
            System.out.println(p);
        }

    }
}
