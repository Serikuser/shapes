package by.siarhei.shapes.factory.impl;

import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.factory.CoordinateFactory;
import by.siarhei.shapes.parser.InputDataParser;

public class PointFactory implements CoordinateFactory {
    private InputDataParser parser;

    public PointFactory() {
        parser = new InputDataParser();
    }

    public Point createPoint(String line) {
        return new Point(parser.parseX(line), parser.parseY(line), parser.parseZ(line));
    }
}
