package com.epam.javacourse.hometask4;

public class Houseplant extends Plant {

    private final int maxHeightInCm;

    public Houseplant (String name, String type, String nativeRegion, int daysFromLastWatering, int maxHeightInCm){
        super(name, type, nativeRegion, daysFromLastWatering);
        this.maxHeightInCm = maxHeightInCm;
    }

    public int getMaxHeightInCm() {
        return maxHeightInCm;
    }

    @Override
    public String toString() {
        return super.toString() +
                "{maxHeightInCm=" + maxHeightInCm +
                '}';
    }
}
