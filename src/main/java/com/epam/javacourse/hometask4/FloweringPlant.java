package com.epam.javacourse.hometask4;

public class FloweringPlant extends Plant {

    private boolean flowering;

    public FloweringPlant (String name, String type, String nativeRegion, int daysFromLastWatering, boolean flowering){
        super(name, type, nativeRegion, daysFromLastWatering);
        this.flowering = flowering;
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
