package by.siarhei.shapes.service;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.BallParameters;
import by.siarhei.shapes.entity.impl.Point;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BallCheckServiceTest {
    private BallCheckService ballCheckService;
    private Point testPoint;
    private Ball testBallWithoutIntersection;
    private Ball testBallWithIntersection;
    private BallParameters testParameters;

    @BeforeClass
    public void setUp() {
        ballCheckService = new BallCheckService();
        testPoint = new Point(11.0, 11.0, 11.0);
        testParameters = new BallParameters();
        testBallWithoutIntersection = new Ball(111, 1.0, testPoint);
        testBallWithIntersection = new Ball(111, 12.0, testPoint);
    }

    @AfterClass
    public void setDown() {
        ballCheckService = null;
        testPoint = null;
        testBallWithIntersection = null;
        testBallWithoutIntersection = null;
    }

    @Test
    public void intersectionOfCoordinateAxesCheckPositive() {
        boolean actual = ballCheckService.intersectionOfCoordinateAxesCheck(testBallWithoutIntersection);
        Assert.assertFalse(actual);
    }

    @Test
    public void intersectionOfCoordinateAxesCheckNegative() {
        boolean actual = ballCheckService.intersectionOfCoordinateAxesCheck(testBallWithIntersection);
        Assert.assertTrue(actual);
    }
}
