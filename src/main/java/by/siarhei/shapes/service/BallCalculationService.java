package by.siarhei.shapes.service;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.BallParameters;
import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.parser.InputDataParser;

public class BallCalculationService {

    public BallParameters calculateParameters(Point point, String line) {
        InputDataParser parser = new InputDataParser();
        double radius = parser.parseRadius(line);
        return new BallParameters(
                area(radius),
                volume(radius),
                BallCheckService.intersectionOfCoordinateAxesCheck(radius, point));
    }

    public BallParameters calculateParameters(Ball ball) {
        return new BallParameters(
                area(ball.getRadius()),
                volume(ball.getRadius()),
                BallCheckService.intersectionOfCoordinateAxesCheck(ball));
    }

    public static double area(double radius) {
        return Math.PI * 4 * Math.pow(radius, 2);
    }

    public static double volume(double radius) {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }

    public static double distanceFromTheOrigin(double y, double z) {
        return Math.hypot(y, z);
    }

}
