package com.epam.javacourse.hometask4;

public class Houseplant extends Plant {

    private int maxHeightInCm;

    private Houseplant() {
        super();
    }

    public static class Builder {
        private String name;
        private String type;
        private String nativeRegion;
        private int daysFromLastWatering;
        private int maxHeightInCm;

        private Builder() {}

        private Builder(Houseplant plant) {
            this.name = plant.getName();
            this.type = plant.getType();
            this.nativeRegion = plant.getNativeRegion();
            this.daysFromLastWatering = plant.getLastWaterDate();
            this.maxHeightInCm = plant.maxHeightInCm;
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

        public Builder withMaxHeightInCm(int maxHeightInCm) {
            this.maxHeightInCm = maxHeightInCm;
            return this;
        }

        public Houseplant build() {
            Houseplant plant = new Houseplant();
            plant.setName(name);
            plant.setType(type);
            plant.setNativeRegion(nativeRegion);
            plant.setDaysFromLastWatering(daysFromLastWatering);
            plant.setMaxHeightInCm(maxHeightInCm);
            return plant;
        }
    }

    public Builder edit() {
        return new Builder(this);
    }

    public static Builder create() {
        return new Builder();
    }

    public int getMaxHeightInCm() {
        return maxHeightInCm;
    }

    private void setMaxHeightInCm(int maxHeightInCm) {
        this.maxHeightInCm = maxHeightInCm;
    }

    @Override
    public String toString() {
        return super.toString() +
                " {maxHeightInCm=" + maxHeightInCm +
                '}';
    }
}
