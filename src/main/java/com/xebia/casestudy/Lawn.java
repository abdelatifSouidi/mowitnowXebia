package com.xebia.casestudy;

import java.util.Objects;

public class Lawn {
    private Location maxLocation;

    public Lawn(Location maxLocation){
        this.maxLocation = maxLocation;
    }

    public Location getMaxLocation() {
        return maxLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lawn lawn = (Lawn) o;
        return Objects.equals(maxLocation, lawn.maxLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxLocation);
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "maxLocation=" + maxLocation +
                '}';
    }
}
