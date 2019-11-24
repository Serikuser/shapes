package by.siarhei.shapes.service;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.Point;

public class BallCheckService {

    public static boolean intersectionOfCoordinateAxesCheck(Ball ball) {

        return (ball.getCenterPoint().getX() - ball.getRadius() <= 0
                || ball.getCenterPoint().getY() - ball.getRadius() <= 0
                || ball.getCenterPoint().getZ() - ball.getRadius() <= 0);
    }

    public static boolean intersectionOfCoordinateAxesCheck(double radius, Point point) {

        return (point.getX() - radius <= 0
                || point.getY() - radius <= 0
                || point.getZ() - radius <= 0);
    }
}
