package by.siarhei.shapes.parser;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InputDataParserTest {
    private String line;
    private InputDataParser testParser;

    @BeforeClass
    void setUp() {
        testParser = new InputDataParser();
        line = "101 1.0 3.0 1.0 5.0";
    }

    @AfterClass
    void setDown() {
        line = null;
    }

    @Test
    void parseRadiusTestPositive() {
        double expected = 5.0;
        double actual = testParser.parseRadius(line);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void parseRadiusTestNegative() {
        double expected = 1.0;
        double actual = testParser.parseRadius(line);
        Assert.assertNotEquals(actual, expected);

    }

    @Test
    void parseFigureIdTestPositive() {
        long expected = 101;
        long actual = testParser.parseId(line);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void parseFigureIdTestNegative() {
        long expected = 102;
        long actual = testParser.parseId(line);
        Assert.assertNotEquals(actual, expected);

    }

    @Test
    void parseXTestPositive() {
        double expected = 1.0;
        double actual = testParser.parseX(line);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void parseXTestNegative() {
        double expected = 2.0;
        double actual = testParser.parseX(line);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    void parseYTestPositive() {
        double expected = 3.0;
        double actual = testParser.parseY(line);
        Assert.assertEquals(actual, expected);

    }

    @Test
    void parseYTestNegative() {
        double expected = 2.0;
        double actual = testParser.parseY(line);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    void parseZTestPositive() {
        double expected = 1.0;
        double actual = testParser.parseZ(line);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void parseZTestNegative() {
        double expected = 2.0;
        double actual = testParser.parseZ(line);
        Assert.assertNotEquals(actual, expected);
    }

}
