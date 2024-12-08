import java.util.*;

/**
 * Class representing AppSettings.
 * A child class of Settings
 * It manages settings related to the application
 */
public class AppSettings extends Settings {
    // Possible feature
    public String colorScheme;
    public String language; // Just an extra example of an app setting

    /**
     * Default constructor that calls the superclass constructor.
     */
    public AppSettings() {
        super();
    }

    /**
     * Constructor to initialize the AppSettings with specific settings values and type.
     *
     * @param colorScheme The color scheme for the application.
     * @param language The language for the application.
     * @param name The type of settings.
     */
    public AppSettings(String colorScheme, String language, String name) {
        super(name);
        this.colorScheme = colorScheme;
        this.language = language;
    }

    /**
     * Edits the settings for the current user.
     * Provides a menu to change the color scheme or language settings.
     *
     * @param currentUser The user whose settings are being edited.
     * @param applicationSettings The application settings object.
     */
    @Override
    public void editSettings(User currentUser, AppSettings applicationSettings) {
        Scanner userInput = new Scanner(System.in);
        DisplayMenus mainMenu = new DisplayMenus();
        int option;
        boolean closeMenu = false;
        while (!closeMenu) {
            System.out.println("Please choose the setting you would like to change: ");
            System.out.println("1. Color ");
            System.out.println("2. Language");
            System.out.println("0. Cancel");

            option = userInput.nextByte();

            switch (option) {
                case 0:
                    closeMenu = true;
                    break;
                case 1:
                    // Prompt user to enter new color scheme
                    // Set the new color scheme value
                    System.out.println("Option 1 chosen");
                    break;
                case 2:
                    // Prompt user to enter new language
                    // Set the new language value
                    System.out.println("Option 2 chosen");
                    break;
            }
        }
    }
}
