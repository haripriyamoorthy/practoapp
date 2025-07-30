package com.manytomany.model;

public enum slotTime {
    SLOT_10_30_AM("10:30am"),
    SLOT_10_45_AM("10:45am"),
    SLOT_11_00_AM("11:00am"),
    SLOT_11_15_AM("11:15am");
    // add more slots as needed

    private final String displayValue;

    slotTime(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    // Optional: Override toString() if needed
    @Override
    public String toString() {
        return this.displayValue;
    }
}
