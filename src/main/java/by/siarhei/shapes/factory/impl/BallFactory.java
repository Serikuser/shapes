package by.siarhei.shapes.factory.impl;

import by.siarhei.shapes.entity.api.Figure;
import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.factory.CoordinateFactory;
import by.siarhei.shapes.factory.FigureFactory;
import by.siarhei.shapes.parser.InputDataParser;
import by.siarhei.shapes.repository.impl.BallRepository;
import by.siarhei.shapes.warehouse.ParametersWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallFactory implements FigureFactory {
    private static final Logger logger = LogManager.getLogger();
    private InputDataParser parser;
    private CoordinateFactory coordinateFactory;

    public BallFactory(){
        coordinateFactory = new PointFactory();
        parser = new InputDataParser();
    }

    @Override
    public Figure createFigure(String line) {
        Point point = (Point) coordinateFactory.createPoint(line);
        long figureId = parser.parseId(line);
        double radius = parser.parseRadius(line);
        Ball ball = new Ball(figureId, radius, point);
        logger.info(String.format("Created ball: %s", ball.toString()));
        ParametersWarehouse.getInstance().putParameters(ball);
        BallRepository.getInstance().addFigure(ball);
        return ball;
    }
}
