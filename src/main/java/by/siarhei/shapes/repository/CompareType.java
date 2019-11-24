package by.siarhei.shapes.repository;

import by.siarhei.shapes.entity.impl.Ball;

import java.util.Comparator;

public enum CompareType {

    BY_ID((o1, o2) -> Math.toIntExact(o1.getFigureId() - o2.getFigureId())),
    BY_X((o1, o2) -> {
        double temp = o1.getCenterPoint().getX() - o2.getCenterPoint().getX();
        if (temp > 0) {
            return 1;
        } else if (temp < 0) {
            return -1;
        }
        return 0;
    }),
    BY_Y((o1, o2) -> {
        double temp = o1.getCenterPoint().getY() - o2.getCenterPoint().getY();
        if (temp > 0) {
            return 1;
        } else if (temp < 0) {
            return -1;
        }
        return 0;
    }),
    BY_Z((o1, o2) -> {
        double temp = o1.getCenterPoint().getZ() - o2.getCenterPoint().getZ();
        if (temp > 0) {
            return 1;
        } else if (temp < 0) {
            return -1;
        }
        return 0;
    });
    Comparator<Ball> comparator;

    CompareType(Comparator<Ball> comparator) {
        this.comparator = comparator;
    }

    public Comparator getComparatorByType() {
        return comparator;
    }
}

