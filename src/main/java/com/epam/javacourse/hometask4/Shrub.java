package com.epam.javacourse.hometask4;

public class Shrub extends Plant {

    private Shrub() {
        super();
    }

    public static class Builder {
        private String name;
        private String type;
        private String nativeRegion;
        private int daysFromLastWatering;

        private Builder() {}

        private Builder(Shrub plant) {
            this.name = plant.getName();
            this.type = plant.getType();
            this.nativeRegion = plant.getNativeRegion();
            this.daysFromLastWatering = plant.getLastWaterDate();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withNativeRegion(String region) {
            this.nativeRegion = region;
            return this;
        }

        public Builder withDaysFromLastWatering(int daysFromLastWatering) {
            this.daysFromLastWatering = daysFromLastWatering;
            return this;
        }

        public Shrub build() {
            Shrub plant = new Shrub();
            plant.setName(name);
            plant.setType(type);
            plant.setNativeRegion(nativeRegion);
            plant.setDaysFromLastWatering(daysFromLastWatering);
            return plant;
        }
    }

    public Builder edit() {
        return new Builder(this);
    }

    public static Builder create() {
        return new Builder();
    }

    public void trimTheShrub() {
        System.out.println("The shrub was trimmed");
    }
}
