import java.util.Scanner;

/**
 * Class representing userSettings.
 * A child class of Settings
 * It manages settings related to the user's profile
 */
public class UserSettings extends Settings {
    private double monthlyIncome;
    private double yearlyIncome;

    /**
     * Default constructor that calls the superclass constructor.
     */
    public UserSettings() {
        super();
    }

    /**
     * Constructor to initialize the UserSettings with specific income values and type.
     *
     * @param monthlyIncome The monthly income.
     * @param yearlyIncome The yearly income.
     * @param name The type of settings.
     */
    public UserSettings(double monthlyIncome, double yearlyIncome, String name) {
        super(name);
        this.monthlyIncome = monthlyIncome;
        this.yearlyIncome = yearlyIncome;
    }

    /**
     * Gets the monthly income.
     *
     * @return The monthly income.
     */
    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    /**
     * Sets the monthly income.
     *
     * @param monthlyIncome The new monthly income.
     */
    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    /**
     * Gets the yearly income.
     *
     * @return The yearly income.
     */
    public double getYearlyIncome() {
        return yearlyIncome;
    }

    /**
     * Sets the yearly income.
     *
     * @param yearlyIncome The new yearly income.
     */
    public void setYearlyIncome(double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    /**
     * Edits the settings for the current user.
     * Provides a menu to change the monthly or yearly income.
     *
     * @param currentUser The user whose settings are being edited.
     * @param applicationSettings The application settings object.
     */
    @Override
    public void editSettings(User currentUser, AppSettings applicationSettings) {
        Scanner userInput = new Scanner(System.in);
        DisplayMenus mainMenu = new DisplayMenus();
        int option;
        double newIncome = 0.0;
        boolean closeMenu = false;
        while (!closeMenu) {
            System.out.println("Please choose the setting you would like to change: ");
            System.out.println("1. Monthly income ");
            System.out.println("2. Yearly income");
            // Might add an option to change text color
            System.out.println("0. Cancel");

            option = userInput.nextInt();

            switch (option) {
                case 0:
                    closeMenu = true;
                    break;
                case 1:
                    // Prompt user to enter new monthly income
                    // Set monthly income to the new value
                    System.out.println("What is your new monthly income?");
                    newIncome = userInput.nextDouble();
                    currentUser.setMonthlyIncome(newIncome);
                    System.out.println(currentUser.getMonthlyIncome());
                    break;
                case 2:
                    // Prompt user to enter new yearly income
                    // Set yearly income to the new value
                    System.out.println("What is your new yearly income?");
                    newIncome = userInput.nextDouble();
                    currentUser.setYearlyIncome(newIncome);
                    System.out.println(currentUser.getYearlyIncome());
                    break;
            }
        }
    }
}
