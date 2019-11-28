package by.siarhei.shapes.factory.impl;

import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.factory.CoordinateFactory;
import by.siarhei.shapes.parser.InputDataParser;

public class PointFactory implements CoordinateFactory {
    private InputDataParser parser;
    private static PointFactory instance;

    private PointFactory() {
        parser = new InputDataParser();
    }

    public static PointFactory getInstance() {
        if (instance == null) {
            instance = new PointFactory();
        }
        return instance;
    }

    public Point createPoint(String line) {
        return new Point(parser.parseX(line), parser.parseY(line), parser.parseZ(line));
    }
}
