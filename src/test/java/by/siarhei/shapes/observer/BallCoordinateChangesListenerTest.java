package by.siarhei.shapes.observer;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.BallParameters;
import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.event.EventType;
import by.siarhei.shapes.observer.impl.BallCoordinateChangesListener;
import by.siarhei.shapes.warehouse.ParametersWarehouse;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BallCoordinateChangesListenerTest {
    private BallCoordinateChangesListener ballCoordinateChangesListener;
    private ParametersWarehouse warehouse;

    @BeforeClass
    void setUp() {
        warehouse = ParametersWarehouse.getInstance();
        ballCoordinateChangesListener = new BallCoordinateChangesListener();
    }

    @AfterClass
    void setDown() {
        ballCoordinateChangesListener = null;
        ParametersWarehouse.getInstance().removeParameters(101L);
    }

    @Test
    void ballCoordinateChangedTest() {
        Ball ball = new Ball(101, 5, new Point(1, 1, 1));
        warehouse.putParameters(ball.getFigureId(), new BallParameters(1, 1, true));
        ball.subscribeListener(EventType.CHANGE_COORDINATE, ballCoordinateChangesListener);
        ball.setCenter(new Point(100, 100, 100));
        boolean actual = warehouse.getParameters(ball).getIntersectionOfCoordinateAxes();
        Assert.assertFalse(actual);
    }
}
