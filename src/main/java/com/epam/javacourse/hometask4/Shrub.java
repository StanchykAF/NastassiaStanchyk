package com.epam.javacourse.hometask4;

public class Shrub extends Plant {

    public Shrub (String name, String type, String nativeRegion, int daysFromLastWatering){
        super(name, type, nativeRegion, daysFromLastWatering);
    }

    public void trimTheShrub() {
        System.out.println("The shrub was trimmed");
    }
}
