package by.siarhei.shapes.repository.api;

import by.siarhei.shapes.entity.api.Figure;
import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.repository.CompareType;

import java.util.List;

public interface FiguresInMemoryRepository {
    List<Ball> getAllUnmodifiableList();

    void addFigure(Ball figure);

    void addAll(List<Ball> figureList);

    List<Ball> query(BallSpecification specification);

    boolean removeFigure(Figure figure);

    void sort(CompareType type);
}
