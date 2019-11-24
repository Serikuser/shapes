package by.siarhei.shapes.validation;

import by.siarhei.shapes.exception.NotValidDataInLineException;
import by.siarhei.shapes.parser.InputDataParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDataValidator {

    private static final int AMOUNT_OF_INPUT_DATA = 5;
    private static final String REGEX_NON_NUMERIC = "[^\\d. +-]+";
    private InputDataParser parser = new InputDataParser();

    public void validate(String line) throws NotValidDataInLineException {
        if (!infoInLineValidation(line)) {
            throw new NotValidDataInLineException(String.format("Data in current line is not valid: %s", line));
        }
        if (isNotNumeric(line)) {
            throw new NotValidDataInLineException(String.format("Non numeric symbol found in line: %s", line));
        }
        if (radiusValueValidation(line)) {
            throw new NotValidDataInLineException(String.format("The radius value must be non-negative and not equal to zero in line: %s", line));
        }
    }

    private boolean infoInLineValidation(String line) {
        String[] subLine = line.split(" ");
        return (subLine.length == AMOUNT_OF_INPUT_DATA);
    }

    private boolean radiusValueValidation(String line) {
        return (parser.parseRadius(line) <= 0);
    }

    private boolean isNotNumeric(String line) {
        Pattern pattern = Pattern.compile(REGEX_NON_NUMERIC);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
