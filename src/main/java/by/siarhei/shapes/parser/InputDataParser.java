package by.siarhei.shapes.parser;

public class InputDataParser {

    private static final int ID_INDEX = 0;
    private static final int X_INDEX = 1;
    private static final int Y_INDEX = 2;
    private static final int Z_INDEX = 3;
    private static final int RADIUS_INDEX = 4;

    public long parseId(String line) {
        long figureId;
        String[] subLines = line.split(" ");
        figureId = Long.valueOf(subLines[ID_INDEX]);
        return figureId;
    }

    public double parseX(String line) {
        double x;
        String[] subLines = line.split(" ");
        x = Double.valueOf(subLines[X_INDEX]);
        return x;
    }

    public double parseY(String line) {
        double y;
        String[] subLines = line.split(" ");
        y = Double.valueOf(subLines[Y_INDEX]);
        return y;
    }

    public double parseZ(String line) {
        double z;
        String[] subLines = line.split(" ");
        z = Double.valueOf(subLines[Z_INDEX]);
        return z;
    }

    public double parseRadius(String line) {
        double radius;
        String[] subLines = line.split(" ");
        radius = Double.valueOf(subLines[RADIUS_INDEX]);
        return radius;
    }
}
