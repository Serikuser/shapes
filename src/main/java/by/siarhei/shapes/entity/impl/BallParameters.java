package by.siarhei.shapes.entity.impl;

import by.siarhei.shapes.entity.FigureParameters;

public class BallParameters implements FigureParameters {

    private double area;
    private double volume;
    private boolean intersectionOfCoordinateAxes;

    public BallParameters() {

    }

    public BallParameters(double area, double volume, boolean isIntersectionOfCoordinateAxes) {
        this.area = area;
        this.volume = volume;
        this.intersectionOfCoordinateAxes = isIntersectionOfCoordinateAxes;
    }


    @Override
    public String toString() {
        return String.format("parameters: area %s, volume: %s, intersectionOfCoordinateAxes: %s",
                this.area, this.volume, this.intersectionOfCoordinateAxes);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public boolean getIntersectionOfCoordinateAxes() {
        return intersectionOfCoordinateAxes;
    }

    public void setIntersectionOfCoordinateAxes(boolean intersectionOfCoordinateAxes) {
        this.intersectionOfCoordinateAxes = intersectionOfCoordinateAxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BallParameters ballParameters = (BallParameters) o;
        return this.getIntersectionOfCoordinateAxes() == ballParameters.getIntersectionOfCoordinateAxes()
                && this.getArea() == ballParameters.getArea()
                && this.getVolume() == ballParameters.getVolume();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(area);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
