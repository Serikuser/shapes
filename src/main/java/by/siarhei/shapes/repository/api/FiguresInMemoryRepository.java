package by.siarhei.shapes.repository.api;

import by.siarhei.shapes.entity.impl.Ball;

import java.util.List;
import java.util.Set;

public interface FiguresInMemoryRepository {
    Set<Ball> getAllUnmodifiableSet();

    void addFigure(Ball figure);

    void addAll(List<Ball> figureList);

    List<Ball> query(BallSpecification specification);

    boolean removeFigure(Ball figure);

}
