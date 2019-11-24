package by.siarhei.shapes.reposytory;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.repository.impl.BallRepository;
import by.siarhei.shapes.repository.impl.BallSpecificationByByDistanceFromTheOrigin;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BallSpecificationByByDistanceFromTheOriginTest {
    private BallSpecificationByByDistanceFromTheOrigin byDistance;
    private List<Ball> expectedList;
    private Ball ball1 = new Ball(101, 3, new Point(5, 4, 6));
    private Ball ball2 = new Ball(102, 7, new Point(5, 4, 6));
    private Ball ball3 = new Ball(103, 1, new Point(13, 33, 56));

    @BeforeClass
    void setUp() {
        expectedList = new ArrayList<>();
        byDistance = new BallSpecificationByByDistanceFromTheOrigin(0, 10);
        BallRepository.getInstance().addFigure(ball1);
        BallRepository.getInstance().addFigure(ball2);
        BallRepository.getInstance().addFigure(ball3);
    }

    @AfterClass
    void setDown() {
        expectedList = null;
        byDistance = null;
        BallRepository.getInstance().removeFigure(ball1);
        BallRepository.getInstance().removeFigure(ball2);
        BallRepository.getInstance().removeFigure(ball3);
    }

    @Test
    void queryByRangeTest() {
        List<Ball> actualList = BallRepository.getInstance().query(byDistance);
        expectedList.add(ball1);
        expectedList.add(ball2);
        Assert.assertEquals(actualList, expectedList);
    }
}
