package helper;

public class Helper {
    private Helper() {} // Private constructor to prevent instantiation

    public static double ConvertMillisecondToSecond(long millisecond) {
        return millisecond / 1000.0;
    }
}