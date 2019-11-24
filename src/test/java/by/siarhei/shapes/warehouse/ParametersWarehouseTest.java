package by.siarhei.shapes.warehouse;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.BallParameters;
import by.siarhei.shapes.entity.impl.Point;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParametersWarehouseTest {
    private Ball ball;

    @BeforeClass
    void setUp() {
        ball = new Ball(101, 5, new Point(1, 1, 1));
        ParametersWarehouse.getInstance().putParameters(ball.getFigureId(), new BallParameters(1, 1, true));
    }

    @AfterClass
    void setDown() {
        ball = null;
        ParametersWarehouse.getInstance().removeParameters(101L);
    }

    @Test
    void reCalculateAfterCoordinateChangesTest() {
        ball.setCenter(new Point(100, 100, 100));
        ParametersWarehouse.getInstance().reCalculateParametersAfterCoordinateChanges(ball);
        boolean actual = ParametersWarehouse.getInstance()
                .getParameters(ball).getIntersectionOfCoordinateAxes();
        Assert.assertFalse(actual);
    }

    @Test
    void reCalculateAfterRadiusChangesTest() {
        ball.setRadius(10);
        double expected = 523.5987755982989;
        ParametersWarehouse.getInstance().reCalculateParametersAfterRadiusChanges(ball);
        double actual = ParametersWarehouse.getInstance()
                .getParameters(ball).getVolume();
        Assert.assertEquals(actual, expected);
    }
}
