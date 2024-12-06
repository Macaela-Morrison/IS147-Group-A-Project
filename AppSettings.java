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

    @Override
    public void editSettings(User currentUser, AppSettings applicationSettings)
    {
        Scanner userInput = new Scanner(System.in);
        DisplayMenus mainMenu = new DisplayMenus();
        int option;
        boolean closeMenu = false;
        while(!closeMenu)
        {
            System.out.println("Please choose the setting you would like to change: ");
            System.out.println("1. Color ");
            System.out.println("2. Language");
            System.out.println("0. Cancel");

            option = userInput.nextByte();

            switch (option)
            {
                case 0:
                    closeMenu = true;
                    break;
                case 1:
                    //Prompt user to enter new monthly income
                    //Set monthly income to the new value
                    System.out.println("Option 1 chosen");
                    break;
                case 2:
                    //Prompt user to enter new yearly income
                    //Set yearly income to the new value
                    System.out.println("Option 2 chosen");
                    break;
            }
        }

    }



}
