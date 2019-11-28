package by.siarhei.shapes.repository.impl;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.repository.BallSpecification;
import by.siarhei.shapes.service.BallCalculationService;

public class BallSpecificationByByDistanceFromTheOrigin implements BallSpecification {
    private double from;
    private double to;

    public BallSpecificationByByDistanceFromTheOrigin(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Ball ball) {
        double distance = BallCalculationService.distanceFromTheOrigin(
                ball.getCenterPoint().getZ(),
                ball.getCenterPoint().getZ());
        return distance >= from && distance <= to;
    }
}
