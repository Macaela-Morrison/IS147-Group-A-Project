import java.util.Scanner;

/**
 * Main class to run the budgeting application.
 * Provides a demonstration of the application's functionality and allows interaction via menus.
 */
public class Main {

    /**
     * The main entry point of the application.
     * Sets up test data and initializes the main menu for user interaction.
     *
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Testing data
        Expense testExpense = new Expense("Groceries1", 100, "Groceries", false);
        Expense testExpense2 = new Expense("Rent", 1500, "Housing", true);
        Expense testExpense3 = new Expense("Insurance", 800, "Housing", true);
        Expense testExpense4 = new Expense("Fix microwave", 150, "Household", false);

        // Create a temporary user and add test expenses
        User tempUser = new User("FriendsFan", "Phoebe", "Buffay", "password", 65000, 5417);
        tempUser.addExpense(tempUser.recurringExpenses, tempUser.nonRecurringExpenses, testExpense);
        tempUser.addExpense(tempUser.recurringExpenses, tempUser.nonRecurringExpenses, testExpense2);
        tempUser.addExpense(tempUser.recurringExpenses, tempUser.nonRecurringExpenses, testExpense3);
        tempUser.addExpense(tempUser.recurringExpenses, tempUser.nonRecurringExpenses, testExpense4);

        // Scanner for user input
        Scanner input = new Scanner(System.in);

        // Initialize the menu and application settings
        DisplayMenus menu = new DisplayMenus();
        AppSettings applicationSettings = new AppSettings("Default", "English", "App");

        // Launch the main menu
        menu.mainMenu(input, tempUser, applicationSettings);

        // Display recurring expenses as a test
        tempUser.displayRecurring();
    }
}







