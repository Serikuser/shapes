package by.siarhei.shapes.repository.impl;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.repository.api.BallSpecification;

public class BallSpecificationById implements BallSpecification {
    private long targetFigureId;

    public BallSpecificationById(long targetFigureId) {
        this.targetFigureId = targetFigureId;
    }

    @Override
    public boolean specified(Ball ball) {
        return ball.getFigureId() == targetFigureId;
    }
}
