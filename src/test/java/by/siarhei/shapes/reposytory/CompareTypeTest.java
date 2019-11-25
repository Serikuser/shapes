package by.siarhei.shapes.reposytory;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.repository.CompareType;
import by.siarhei.shapes.repository.impl.BallRepository;
import by.siarhei.shapes.repository.impl.BallSpecificationByVolume;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CompareTypeTest {

    private static final BallSpecificationByVolume ALL_BY_VOLUME = new BallSpecificationByVolume(1, 1000);

    private Ball ball1 = new Ball(101, 2, new Point(5, 4, 6));
    private Ball ball2 = new Ball(102, 2, new Point(4, 5, 2));
    private Ball ball3 = new Ball(103, 1, new Point(6, 3, 5));

    private BallRepository repository;

    @BeforeClass
    void setUp() {
        repository = BallRepository.getInstance();
        Ball[] balls = new Ball[]{ball1, ball2, ball3};
        List<Ball> unSortedList = (Arrays.asList(balls));
        repository.addAll(unSortedList);
    }

    @AfterClass
    void setDown() {
        BallRepository.getInstance().removeFigure(ball1);
        BallRepository.getInstance().removeFigure(ball2);
        BallRepository.getInstance().removeFigure(ball3);
    }

    @Test
    void sortByXTest() {
        List<Ball> sortedByXList = (Arrays.asList(ball2, ball1, ball3));
        List<Ball> actualList = repository.query(ALL_BY_VOLUME, CompareType.BY_X);
        Assert.assertEquals(actualList, sortedByXList);
    }

    @Test
    void sortByYTest() {
        List<Ball> sortedByYList = (Arrays.asList(ball3, ball1, ball2));
        List<Ball> actualList = repository.query(ALL_BY_VOLUME, CompareType.BY_Y);
        Assert.assertEquals(actualList, sortedByYList);
    }

    @Test
    void sortByZTest() {
        List<Ball> sortedByZList = (Arrays.asList(ball2, ball3, ball1));
        List<Ball> actualList = repository.query(ALL_BY_VOLUME, CompareType.BY_Z);
        Assert.assertEquals(actualList, sortedByZList);
    }

    @Test
    void sortByIdTest() {
        List<Ball> sortedByIdList = (Arrays.asList(ball1, ball2, ball3));
        List<Ball> actualList = repository.query(ALL_BY_VOLUME, CompareType.BY_ID);
        Assert.assertEquals(actualList, sortedByIdList);
    }
}
