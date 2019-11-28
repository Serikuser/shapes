package by.siarhei.shapes.repository.impl;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.repository.BallSpecification;

public class BallSpecificationByCenterPoint implements BallSpecification {
    private Point targetPoint;

    public BallSpecificationByCenterPoint(Point targetPoint) {
        this.targetPoint = targetPoint;
    }

    @Override
    public boolean specified(Ball ball) {
        return ball.getCenterPoint().equals(targetPoint);
    }
}
