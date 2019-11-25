package by.siarhei.shapes.warehouse;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.BallParameters;
import by.siarhei.shapes.service.BallCalculationService;
import by.siarhei.shapes.service.BallCheckService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ParametersWarehouse {
    private static final Logger logger = LogManager.getLogger();
    private static ParametersWarehouse instance;
    private Map<Long, BallParameters> warehouseMap;
    private BallCalculationService calculator;

    private ParametersWarehouse() {
        warehouseMap = new HashMap<>();
        calculator = new BallCalculationService();
    }

    public static ParametersWarehouse getInstance() {
        if (instance == null) {
            instance = new ParametersWarehouse();
        }
        return instance;
    }

    public void putParameters(Long figureId, BallParameters parameters) {
        warehouseMap.put(figureId, parameters);
    }

    public void putParameters(Ball figure) {
        warehouseMap.put(figure.getFigureId(), calculator.calculateParameters(figure));
    }

    public void removeParameters(Long figureId) {
        warehouseMap.remove(figureId);
    }

    public BallParameters getParameters(Ball figure) {
        return warehouseMap.get(figure.getFigureId());
    }

    public void reCalculateParametersAfterRadiusChanges(Ball figure) {
        instance.getParameters(figure)
                .setArea(BallCalculationService.area(figure.getRadius()));
        instance.getParameters(figure)
                .setVolume(BallCalculationService.volume(figure.getRadius()));
        instance.getParameters(figure)
                .setIntersectionOfCoordinateAxes(BallCheckService.intersectionOfCoordinateAxesCheck(figure));
        messageAfterRecalculation(figure);
    }

    public void reCalculateParametersAfterCoordinateChanges(Ball figure) {
        instance.getParameters(figure)
                .setIntersectionOfCoordinateAxes(BallCheckService.intersectionOfCoordinateAxesCheck(figure));
        messageAfterRecalculation(figure);
    }

    private void messageAfterRecalculation(Ball figure) {
        logger.info(String.format("Recalculated parameters for the figure with the id: %s placed in the warehouse ", figure.getFigureId()));
    }
}
