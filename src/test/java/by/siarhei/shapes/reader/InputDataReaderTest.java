package by.siarhei.shapes.reader;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InputDataReaderTest {

    private InputDataReader testInputDataReader;
    private String inputFile;
    private List<String> expected;

    @BeforeClass
    void setUp() {
        expected = new ArrayList<>();
        expected.add("id, x, y, z, radius");
        expected.add("101 1.0 3.0 1.0 5.0");
        expected.add("102 3.0 2.1 -3.0 6.2");
        expected.add("103 5.0 2.0 4.1 4.3");
        expected.add("104 1.2 2.5 3.5 3.0");
        expected.add("105s 1.2 2.5 3.5 3.0");
        expected.add("106 1.2 2.5 3.5 -3.0");
        testInputDataReader = new InputDataReader();
    }

    @AfterClass
    void setDown() {
        inputFile = null;
        testInputDataReader = null;
    }

    @Test
    void readInputFilePositive() {
        inputFile = "input/input.txt";
        List<String> actual = testInputDataReader.readData(inputFile);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void readInputFileNegative() {
        inputFile = "input/test";
        List<String> actual = testInputDataReader.readData(inputFile);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    void readDefaultInputFilePositive() {
        List<String> actual = testInputDataReader.readData();
        Assert.assertEquals(actual, expected);
    }

}
