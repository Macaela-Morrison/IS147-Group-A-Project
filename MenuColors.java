public class MenuColors {

    //This class provides the code needed to use ANSI escape sequences to change menu text color
    //Code to reset color to default
    //ANSI codes were pulled from this website : https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
    public static final String RESET = "\u001B[0m";

    //ANSI codes for string colors
    public static final String RED_TEXT = "\u001B[31m";
    public static final String GREEN_TEXT = "\u001B[32m";
    public static final String YELLOW_TEXT = "\u001B[33m";
    public static final String BLUE_TEXT = "\u001B[34m";
    public static final String PURPLE_TEXT = "\u001B[35m";
    public static final String CYAN_TEXT = "\u001B[36m";
    public static final String WHITE_TEXT = "\u001B[37m";

    // ANSI codes for background colors
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    // Additional style options
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";

    //As this is a utility class, no instantiation is used
    private MenuColors() {
        throw new UnsupportedOperationException("ANSIColors is a utility class and should not be instantiated.");
    }
}
