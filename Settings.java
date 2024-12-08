/**
 * Abstract class representing a generic Settings object.
 */
public abstract class Settings {
    /**
     * The type of the setting.
     */
    private String type;

    /**
     * Default constructor.
     */
    public Settings() {
        // No initialization required
    }

    /**
     * Constructor to initialize the settings type.
     *
     * @param type The type of settings.
     */
    public Settings(String type) {
        this.type = type;
    }

    /**
     * Gets the type of settings.
     *
     * @return The type of settings.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of settings.
     *
     * @param type The type of settings.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Abstract method to edit settings.
     *
     * @param currentUser The user currently editing the settings.
     * @param applicationSettings The application settings to be edited.
     */
    public abstract void editSettings(User currentUser, AppSettings applicationSettings);
}

