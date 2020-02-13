package com.xebia.casestudy;

import java.util.Objects;

public class Location {
    private int x;
    private int y;
    public String orientation ;

    public Location(int pX, int pY){
        this.x = pX;
        this.y = pY;
    }

    public Location(int pX, int pY, String orientation){
        this.x = pX;
        this.y = pY;
        this.orientation = orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x &&
                y == location.y &&
                Objects.equals(orientation, location.orientation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, orientation);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", orientation='" + orientation + '\'' +
                '}';
    }
}
