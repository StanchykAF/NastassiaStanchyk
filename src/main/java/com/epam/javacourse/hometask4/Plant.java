package com.epam.javacourse.hometask4;

public abstract class Plant {
    private String name;
    private String type;
    private String nativeRegion;
    private int daysFromLastWatering;

    public Plant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNativeRegion() {
        return nativeRegion;
    }

    public void setNativeRegion(String nativeRegion) {
        this.nativeRegion = nativeRegion;
    }

    public int getLastWaterDate() {
        return daysFromLastWatering;
    }

    public void setDaysFromLastWatering(int daysFromLastWatering) {
        this.daysFromLastWatering = daysFromLastWatering;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", native region='" + nativeRegion + '\'' +
                ", day(s) from last watering=" + daysFromLastWatering +
                '}';
    }
}
