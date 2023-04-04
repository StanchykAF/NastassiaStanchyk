package com.epam.javacourse.hometask4;

public class MainClass {
    public static void main(String[] args) {
        Plant vasya = Houseplant.create()
                .withType("sukkulent")
                .withNativeRegion("Africa")
                .build();
        Plant petya = Houseplant.create()
                .withType("sukkulent")
                .withNativeRegion("Africa")
                .build();
        Plant adams = Shrub.create()
                .withType("rose")
                .withNativeRegion("North America")
                .build();
        Plant[] plants = {vasya, petya, adams};
        Greenhouse greenhouse = new Greenhouse(plants);

        Plant[] results = greenhouse.getPlantsWithType("sukkulent");
        for (Plant p: results) {
            System.out.println(p);
        }

        greenhouse.buyNewPlant(
                new FloweringPlant().new Builder()
                        .withType("flower")
                        .withNativeRegion("Europe")
                        .build()
        );

        System.out.println();
        results = greenhouse.get();
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
        results = greenhouse.get();
        for (Plant p: results) {
            System.out.println(p);
        }
    }
}
