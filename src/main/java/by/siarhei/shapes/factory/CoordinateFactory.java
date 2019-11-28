package by.siarhei.shapes.factory;

import by.siarhei.shapes.entity.Coordinate;

public interface CoordinateFactory {
    Coordinate createPoint(String line);
}
