package com.epam.javacourse.hometask4;

public class FloweringPlant extends Plant {

    private boolean flowering;

    public FloweringPlant() {
        super();
    }

    public class Builder {
        private String name;
        private String type;
        private String nativeRegion;
        private int daysFromLastWatering;
        private boolean flowering;

        public Builder() {}

        public Builder(FloweringPlant plant) {
            this.name = plant.getName();
            this.type = plant.getType();
            this.nativeRegion = plant.getNativeRegion();
            this.daysFromLastWatering = plant.getLastWaterDate();
            this.flowering = plant.flowering;
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

        public Builder isFlowering(boolean flowering) {
            this.flowering = flowering;
            return this;
        }

        public FloweringPlant build() {
            FloweringPlant plant = new FloweringPlant();
            plant.setName(name);
            plant.setType(type);
            plant.setNativeRegion(nativeRegion);
            plant.setDaysFromLastWatering(daysFromLastWatering);
            plant.setFlowering(flowering);
            return plant;
        }
    }

    public boolean isFlowering() {
        return flowering;
    }

    public void setFlowering(boolean flowering) {
        this.flowering = flowering;
    }

    @Override
    public String toString() {
        return super.toString() +
                "{flowering=" + flowering +
                '}';
    }
}
