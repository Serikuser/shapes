package by.siarhei.shapes.repository.impl;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.repository.BallSpecification;
import by.siarhei.shapes.service.BallCalculationService;

public class BallSpecificationByVolume implements BallSpecification {
    private double from;
    private double to;

    public BallSpecificationByVolume(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Ball ball) {
        double volume = BallCalculationService.volume(
                ball.getRadius());
        return volume >= from && volume <= to;
    }
}
