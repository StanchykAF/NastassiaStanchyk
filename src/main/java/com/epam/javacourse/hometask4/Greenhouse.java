package com.epam.javacourse.hometask4;

import java.util.Arrays;

public class Greenhouse implements Informational, Watered, Changeable {

    private float temperature;
    private Plant[] plants;

    public Greenhouse(Plant[] plants) {
        this.plants = plants;
    }

    public Plant[] getPlantsWithType(String type) {
        Plant[] buf = new Plant[plants.length];
        int i = 0;
        for (Plant plant : plants) {
            if (plant.getType().equalsIgnoreCase(type)) {
                buf[i] = plant;
                i++;
            }
        }
        return buf;
    }

    public Plant[] getPlantsWithNativeRegion(String region) {
        Plant[] buf = new Plant[plants.length];
        int i = 0;
        for (Plant plant : plants) {
            if (plant.getNativeRegion().equalsIgnoreCase(region)) {
                buf[i] = plant;
                i++;
            }
        }
        return buf;
    }

    public void buyNewPlant(Plant plant) {
        Plant[] buf = Arrays.copyOf(plants, plants.length + 1);
        buf[plants.length] = plant;
        this.plants = buf;
    }

    public void removePlant(Plant plant) {
        Plant[] buf = new Plant[plants.length - 1];
        int i = 0;
        for (Plant p : plants) {
            if (!p.equals(plant)) {
                buf[i] = p;
                i++;
            }
        }
        this.plants = buf;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Plant[] getPlantsInTheGreenhouse() {
        return plants;
    }

    public void waterPlant(Plant plant) {
        plant.setDaysFromLastWatering(0);
        System.out.println("The plant " + plant.getName() + " was watered");
    }
}
