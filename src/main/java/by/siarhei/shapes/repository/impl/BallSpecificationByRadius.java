package by.siarhei.shapes.repository.impl;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.repository.api.BallSpecification;

public class BallSpecificationByRadius implements BallSpecification {
    private double targetRadius;

    public BallSpecificationByRadius(double targetRadius) {
        this.targetRadius = targetRadius;
    }

    @Override
    public boolean specified(Ball ball) {
        return ball.getRadius() == targetRadius;
    }
}
