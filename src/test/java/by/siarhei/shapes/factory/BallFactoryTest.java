package by.siarhei.shapes.factory;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.factory.impl.BallFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BallFactoryTest {
    private static final String INPUT_LINE = "101 1 1 1 5";
    private BallFactory factory;
    private Ball expectedBall;
    private Ball actualBall;

    @BeforeClass
    void setUp() {
        expectedBall = new Ball(101, 5,
                new Point(1, 1, 1));
        factory = BallFactory.getInstance();

    }

    @AfterClass
    void setDown() {
        factory = null;
        expectedBall = null;
        actualBall = null;
    }

    @Test
    void ballCreationTest() {
        actualBall = (Ball) factory.createFigure(INPUT_LINE);
        Assert.assertEquals(actualBall, expectedBall);
    }
}
