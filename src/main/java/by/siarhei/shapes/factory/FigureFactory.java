package by.siarhei.shapes.factory;

import by.siarhei.shapes.entity.Figure;

public interface FigureFactory {
    Figure createFigure(String line);
}
