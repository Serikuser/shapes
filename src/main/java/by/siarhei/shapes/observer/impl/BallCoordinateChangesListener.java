package by.siarhei.shapes.observer.impl;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.observer.ChangesParametersListener;
import by.siarhei.shapes.warehouse.ParametersWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallCoordinateChangesListener implements ChangesParametersListener {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void update(Ball figure) {
        logger.info(String.format("Coordinate was changed at %s", figure.toString()));
        ParametersWarehouse.getInstance().reCalculateParametersAfterCoordinateChanges(figure);
    }
}
