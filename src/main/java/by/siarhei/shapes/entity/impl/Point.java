package by.siarhei.shapes.entity.impl;

import by.siarhei.shapes.entity.api.Coordinate;

public class Point implements Coordinate {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point() {
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("x: %s, y: %s, z: %s", this.x, this.y, this.z);
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if ((ob == null) || getClass() != ob.getClass()) {
            return false;
        }
        Point point = (Point) ob;
        return this.getX() == (point.getX())
                && this.getY() == (point.getY())
                && this.getZ() == (point.getZ());

    }

    @Override
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        result = 31 * result + Double.hashCode(z);
        return result;
    }
}
