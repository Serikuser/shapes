package by.siarhei.shapes.service;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.BallParameters;
import by.siarhei.shapes.entity.impl.Point;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BallsCalculationServiceTest {
    private static final double RIGHT_AREA = 5026.548245743669;
    private static final double WRONG_AREA = 26.5;
    private static final double RIGHT_VOLUME = 33510.32163829113;
    private static final double WRONG_VOLUME = 30.32163829113;
    private BallCalculationService ballCalculationService;
    private Ball testBall;
    private Point testPoint;

    @BeforeClass
    public void setUp() {
        ballCalculationService = new BallCalculationService();
        testPoint = new Point(1.0, 1.0, 1.0);
        testBall = new Ball(111, 20.0, testPoint);
    }

    @AfterClass
    public void setDown() {
        ballCalculationService = null;
        testPoint = null;
        testBall = null;
    }

    @Test
    public void testGetAreaPositive() {
        double expected = RIGHT_AREA;
        double actual = BallCalculationService.area(testBall.getRadius());
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testGetAreaNegative() {
        double expected = WRONG_AREA;
        double actual = BallCalculationService.area(testBall.getRadius());
        Assert.assertNotEquals(actual, expected, 0.0001);
    }

    @Test
    public void testGetValuePositive() {
        double expected = RIGHT_VOLUME;
        double actual = BallCalculationService.volume(testBall.getRadius());
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testGetValuePositiveNegative() {
        double expected = WRONG_VOLUME;
        double actual = BallCalculationService.volume(testBall.getRadius());
        Assert.assertNotEquals(actual, expected, 0.0001);
    }

    @Test
    public void testCalculateParameters() {
        BallParameters expectedParameters = new BallParameters(RIGHT_AREA, RIGHT_VOLUME, true);
        BallParameters actualParameters = ballCalculationService.calculateParameters(testBall);
        Assert.assertEquals(actualParameters, expectedParameters);
    }

}
