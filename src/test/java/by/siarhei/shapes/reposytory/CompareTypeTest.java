package by.siarhei.shapes.reposytory;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.entity.impl.Point;
import by.siarhei.shapes.repository.CompareType;
import by.siarhei.shapes.repository.impl.BallRepository;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CompareTypeTest {
    private BallRepository repository;
    private Ball ball1 = new Ball(101, 2, new Point(5, 4, 6));
    private Ball ball2 = new Ball(102, 2, new Point(4, 5, 2));
    private Ball ball3 = new Ball(103, 1, new Point(6, 3, 5));

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
        ;
        repository.sort(CompareType.BY_X);
        List<Ball> actualList = BallRepository.getInstance().getAllUnmodifiableList();
        Assert.assertEquals(actualList, sortedByXList);
    }

    @Test
    void sortByYTest() {
        List<Ball> sortedByYList = (Arrays.asList(ball3, ball1, ball2));
        ;
        BallRepository.getInstance().sort(CompareType.BY_Y);
        List<Ball> actualList = BallRepository.getInstance().getAllUnmodifiableList();
        Assert.assertEquals(actualList, sortedByYList);
    }

    @Test
    void sortByZTest() {
        List<Ball> sortedByZList = (Arrays.asList(ball2, ball3, ball1));
        ;
        BallRepository.getInstance().sort(CompareType.BY_Z);
        List<Ball> actualList = BallRepository.getInstance().getAllUnmodifiableList();
        Assert.assertEquals(actualList, sortedByZList);
    }

    @Test
    void sortByIdTest() {
        List<Ball> sortedByIdList = (Arrays.asList(ball1, ball2, ball3));
        BallRepository.getInstance().sort(CompareType.BY_ID);
        List<Ball> actualList = BallRepository.getInstance().getAllUnmodifiableList();
        Assert.assertEquals(actualList, sortedByIdList);
    }
}
