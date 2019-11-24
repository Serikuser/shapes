package by.siarhei.shapes.validation;

import by.siarhei.shapes.exception.NotValidDataInLineException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InputDataValidationTest {
    private String line;
    private InputDataValidator testValidator;

    @BeforeClass
    void setUp() {
        testValidator = new InputDataValidator();
    }

    @AfterClass
    void setDown() {
        line = null;
        testValidator = null;
    }


    @Test
    void validateTestPositive() throws NotValidDataInLineException {
        line = "01 1.0 2.0 3.0 20";
        testValidator.validate(line);
    }

    @Test(expectedExceptions = NotValidDataInLineException.class)
    void validateTestWrongSymbol() throws NotValidDataInLineException {
        line = "01s 1.0 2.0 3.0 20";
        testValidator.validate(line);
    }

    @Test(expectedExceptions = NotValidDataInLineException.class)
    void validateTestWrongData() throws NotValidDataInLineException {
        line = "01 2.0 3.0 20";
        testValidator.validate(line);
    }

    @Test(expectedExceptions = NotValidDataInLineException.class)
    void validateTestWrongRadius() throws NotValidDataInLineException {
        line = "01 1.0 2.0 3.0 -20";
        testValidator.validate(line);
    }
}
