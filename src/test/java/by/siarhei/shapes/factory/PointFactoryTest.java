package by.siarhei.shapes.factory;

import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.factory.impl.PointFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PointFactoryTest {
    private PointFactory factory;
    private Point expectedPoint;
    private String inputLine;

    @BeforeClass
    void setUp() {
        expectedPoint = new Point(1, 1, 1);
        inputLine = "101 1 1 1 5";
        factory = new PointFactory();
    }

    @AfterClass
    void setDown() {
        inputLine = null;
        expectedPoint = null;
        factory = null;
    }

    @Test
    void pointCreationTest() {
        Point actualPoint = factory.createPoint(inputLine);
        Assert.assertEquals(actualPoint, expectedPoint);
    }
}
