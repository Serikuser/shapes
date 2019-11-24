package by.siarhei.shapes.observer;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.BallParameters;
import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.event.EventType;
import by.siarhei.shapes.observer.impl.BallRadiusChangesListener;
import by.siarhei.shapes.warehouse.ParametersWarehouse;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BallRadiusChangesListenerTest {
    private static final double VOLUME = 523.5987755982989;
    private ParametersWarehouse warehouse;
    private BallRadiusChangesListener ballRadiusChangesListener;


    @BeforeClass
    void setUp() {
        warehouse = ParametersWarehouse.getInstance();
        ballRadiusChangesListener = new BallRadiusChangesListener();
    }

    @AfterClass
    void setDown() {
        ballRadiusChangesListener = null;
        ParametersWarehouse.getInstance().removeParameters(101L);
    }

    @Test
    void ballRadiusChangedTest() {
        Ball ball = new Ball(101, 1, new Point(1, 1, 1));
        warehouse.putParameters(ball.getFigureId(), new BallParameters(1, 1, true));
        ball.subscribeListener(EventType.CHANGE_RADIUS, ballRadiusChangesListener);
        ball.setRadius(5);
        double expected = VOLUME;
        double actual = ParametersWarehouse.getInstance()
                .getParameters(ball).getVolume();
        Assert.assertEquals(actual, expected);
    }
}
