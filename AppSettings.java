import java.util.*;

/**
 *
 */

public class AppSettings extends Settings{

    //Possible feature
    public String colorScheme;
    public String language; //Just an extra example of an app setting

    public AppSettings()
    {
        super();
    }

    public AppSettings(String colorScheme, String language, String name)
    {
        super(name);
        this.colorScheme = colorScheme;
        this.language = language;
    }




}
