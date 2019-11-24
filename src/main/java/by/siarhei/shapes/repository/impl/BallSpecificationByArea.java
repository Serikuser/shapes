package by.siarhei.shapes.repository.impl;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.repository.api.BallSpecification;
import by.siarhei.shapes.service.BallCalculationService;

public class BallSpecificationByArea implements BallSpecification {
    private double from;
    private double to;

    public BallSpecificationByArea(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Ball ball) {
        double area = BallCalculationService.area(
                ball.getRadius());
        return area >= from && area <= to;
    }
}
