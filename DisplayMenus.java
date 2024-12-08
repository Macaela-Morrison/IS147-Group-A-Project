import java.awt.*;
import java.util.*;


/**
 * Display menu's class contains all the code needed for the program menu's.
 */
public class DisplayMenus {

    /**
     * Default constructor for DisplayMenus.
     */
    public DisplayMenus()
    {

    }
    /**
     * Displays the main menu and handles user input for selecting different options.
     *
     * @param input               The Scanner object for reading user input.
     * @param currentUser         The current user object containing user details.
     * @param applicationSettings The application settings object.
     */
    public static void mainMenu(Scanner input, User currentUser, AppSettings applicationSettings){
        while (true) {

            String color = applicationSettings.getColorScheme();
            System.out.println("\n" + color + "Welcome to Personal Budgeting Program! Please see menu options below:");
            if(currentUser.totalRemaining() < 0)
            {
                System.out.printf("You have overspent by " + MenuColors.RED_TEXT + " %.2f " + color + " for this month\n", (currentUser.totalRemaining())*-1);
            }
            else
            {
                System.out.printf("You have %.2f remaining for this month\n", currentUser.totalRemaining());
            }

            System.out.println("1. Recurring Expenses");
            System.out.println("2. Non-Recurring Expenses");
            System.out.println("3. Overall Totals");
            System.out.println("4. Yearly Overview");
            System.out.println("5. Settings");
            System.out.println("0. Quit");
            System.out.print("Enter a choice: ");
            int number = input.nextInt();

            switch (number) {
                case 1:
                    recurringExpensesMenu(input, currentUser);
                    break;
                case 2:
                    nonRecurringExpensesMenu(input,currentUser);
                    break;
                case 3:
                    displayOverallTotal(currentUser);
                    break;
                case 4:
                    displayYearlyOverview(currentUser);
                    break;
                case 5:
                    settingsMenu(input, currentUser, applicationSettings);
                    break;
                case 0:
                    System.out.println("Exiting the program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    /**
     * Displays the menu for managing recurring expenses.
     *
     * @param input      The Scanner object for reading user input.
     * @param currentUser The current user object containing user details.
     */
    public static void recurringExpensesMenu(Scanner input, User currentUser) {
        boolean exitRecurringMenu = false;

        while (!exitRecurringMenu) {
            System.out.println("1. Add Expense");
            System.out.println("2. Delete Expense");
            System.out.println("3. View Recurring Expenses");
            System.out.println("4. Search for a Recurring Expense");
            System.out.println("5. Edit Existing Expense");
            System.out.println("6. Back to Main Menu");
            System.out.println("0. Quit");
            System.out.print("Enter a choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting the program");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("You chose to add an expense");
                    addExpenseMenu(currentUser);
                    break;
                case 2:
                    System.out.println("You chose to delete an expense");
                    deleteExpenseMenu(currentUser, true);
                    break;
                case 3:
                    System.out.println("View Totals: ");
                    currentUser.displayTotals(true);
                    break;
                case 4:
                    System.out.println("Search for a recurring expense: ");
                    searchMenu(input, currentUser, true);
                    break;
                case 5:
                    System.out.println("You chose to edit an expense: ");
                    editExpenseMenu(currentUser, true);
                    break;
                case 6:
                    exitRecurringMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    /**
     * Displays the menu for managing non-recurring expenses.
     *
     * @param input      The Scanner object for reading user input.
     * @param currentUser The current user object containing user details.
     */
    public static void nonRecurringExpensesMenu(Scanner input, User currentUser) {
        boolean exitNonRecurringMenu = false;

        while (!exitNonRecurringMenu) {
            System.out.println("Non-Recurring Expenses Menu:");
            System.out.println("1. Add Non-Recurring Expense");
            System.out.println("2. Delete Non-Recurring Expense");
            System.out.println("3. View Non-Recurring Expenses");
            System.out.println("4. Search for a Non-Recurring Expense");
            System.out.println("5. Edit Existing Expense");
            System.out.println("6. Back to Main Menu");
            System.out.println("0. Quit");
            System.out.print("Enter a choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting the program");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("You chose to add an expense");
                    addExpenseMenu(currentUser);
                    break;
                case 2:
                    System.out.println("You chose to delete an expense");
                    deleteExpenseMenu(currentUser, false);
                    break;
                case 3:
                    System.out.println("View Totals: ");
                    currentUser.displayTotals(false);
                    break;
                case 4:
                    System.out.println("Search for a non-recurring expense: ");
                    searchMenu(input, currentUser, false);
                    break;
                case 5:
                    System.out.println("You chose to edit an expense: ");
                    editExpenseMenu(currentUser, false);
                    break;
                case 6:
                    exitNonRecurringMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    /**
     * Displays the overall total of both recurring and non-recurring expenses.
     *
     * @param currentUser The current user object containing user details.
     */
    public static void displayOverallTotal(User currentUser) {
        double totalRecurring = currentUser.calcTotals(true);
        double totalNonRecurring = currentUser.calcTotals(false);
        double overallTotal = totalRecurring + totalNonRecurring;
        System.out.println("Total recurring expenses: $" + totalRecurring);
        System.out.println("Total non-recurring expenses: $" + totalNonRecurring);
        System.out.println("Your total expenses for this month so far is: $" + overallTotal);

    }

    /**
     * Displays the yearly overview (currently a placeholder for future implementation).
     */
    public static void displayYearlyOverview(User currentUser) {
        System.out.println("Here is your overview:");
        System.out.printf("Your yearly income is: $%.2f\n", currentUser.getYearlyIncome());
        System.out.printf("Your monthly income is: $%.2f\n", currentUser.getMonthlyIncome());
        displayOverallTotal(currentUser);
        //Would like to expand this summary
    }

    /**
     * Allows the user to search for an expense (either recurring or non-recurring).
     *
     * @param input          The Scanner object for reading user input.
     * @param currentUser    The current user object containing user details.
     * @param recurring      Whether the search is for a recurring expense.
     */
    public static void searchMenu(Scanner input, User currentUser, boolean recurring) {
        boolean searchAgain = true;
        input.nextLine(); // Clear the buffer
        do {
            ArrayList<Expense> tempList = new ArrayList<>();

            System.out.print("Please enter the name of the expense: ");
            String searchExpense = input.nextLine();

            tempList = currentUser.findExpenses(searchExpense, recurring);

            if (!tempList.isEmpty()) {
                int index = 1;
                Iterator<Expense> it = tempList.iterator();
                while (it.hasNext()) {
                    Expense temp = it.next();
                    System.out.println(index + ". " + temp);
                    index++;
                }
            } else {
                System.out.println("No matching expenses found.");
            }

            System.out.print("Would you like to search again? Enter Y for yes and N for no: ");
            String response = input.nextLine();
            if(response.equalsIgnoreCase("N"))
            {
                searchAgain = false;
            }
        } while (searchAgain);
    }


    /**
     * Displays the settings menu and allows the user to modify user and application settings.
     *
     * @param input             The Scanner object for reading user input.
     * @param currentUser       The current user object containing user details.
     * @param applicationSettings The application settings object.
     */
    public static void settingsMenu(Scanner input, User currentUser, AppSettings applicationSettings) {
        boolean exitSettingsMenu = false;

        while (!exitSettingsMenu) {
            System.out.println("Settings Menu:");
            System.out.print("Enter a choice: ");
            System.out.println("\n1. Edit user settings");
            System.out.println("2. Edit application settings");
            System.out.println("0. Exit to main menu");
            int choice = input.nextInt();

            switch(choice)
            {
                case 0:
                    exitSettingsMenu = true;
                    break;
                case 1:
                    currentUser.getUserSettings().editSettings(currentUser, applicationSettings);
                    break;
                case 2:
                    applicationSettings.editSettings(currentUser, applicationSettings);
                    break;
                default:
                    System.out.println("Invalid input. Please try again");
            }
            System.out.println();
        }
    }

    /**
     * Displays the menu to add a new expense.
     *
     * @param currentUser The current user object containing user details.
     */
    public static void addExpenseMenu(User currentUser)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please provide the details of your expense.");
        System.out.print("Enter a name for your expense: ");
        String name = input.nextLine();
        double amount = 0;
        boolean validAmount = false;
        while (!validAmount) {
            System.out.print("Enter the amount: $");
            if (input.hasNextDouble()) {
                amount = input.nextDouble();
                validAmount = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next(); // Clear the invalid input
            }
        }
        input.nextLine();//Clear the buffer
        System.out.print("Enter the category: ");
        String category = input.nextLine();
        System.out.print("Is this a recurring expense? Type Y for yes and N for no: ");
        String answer = input.nextLine();
        boolean recurring = false;
        if(answer.equalsIgnoreCase("Y"))
        {
            recurring = true;
        }

        Expense expense = new Expense();

        expense = expense.createExpense(name, amount, category, recurring);

        currentUser.addExpense(currentUser.recurringExpenses, currentUser.nonRecurringExpenses, expense);

    }

    /**
     * Displays the menu to delete an existing expense.
     *
     * @param currentUser The current user object containing user details.
     * @param recurring   Whether the expense is recurring or not.
     */
    public static void deleteExpenseMenu(User currentUser, boolean recurring)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose an expense to delete:");
        int size = 0;
        int index = 0;
        if(recurring)
        {
            currentUser.displayRecurring();
            size = currentUser.getRecurringExpenses().size();
        }
        else
        {
            currentUser.displayNonRecurring();
            size = currentUser.getNonRecurringExpenses().size();
        }

        index = input.nextInt();
        currentUser.deleteExpense(recurring, index);
    }

    /**
     * Displays the menu to edit an existing expense.
     *
     * @param currentUser The current user object containing user details.
     * @param recurring   Whether the expense is recurring or not.
     */
    public static void editExpenseMenu(User currentUser, boolean recurring)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose an expense to edit: ");
        int size = 0;
        int index = 0;
        if(recurring)
        {
            currentUser.displayRecurring();
            size = currentUser.getRecurringExpenses().size();
        }
        else
        {
            currentUser.displayNonRecurring();
            size = currentUser.getNonRecurringExpenses().size();
        }

        index = input.nextInt();
        input.nextLine();

        System.out.println("Please provide the details of your expense.");
        System.out.print("Enter a name for your expense: ");
        String name = input.nextLine();
        double amount = 0;
        boolean validAmount = false;
        while (!validAmount) {
            System.out.print("Enter the amount: $");
            if (input.hasNextDouble()) {
                amount = input.nextDouble();
                validAmount = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next(); // Clear the invalid input
            }
        }
        input.nextLine(); //Clear the leftover newline character
        System.out.print("Enter the category: ");
        String category = input.nextLine();
        System.out.print("Is this a recurring expense? Type Y for yes and N for no: ");
        String answer = input.nextLine();
        boolean stillRecurring = false;
        if(answer.equalsIgnoreCase("Y"))
        {
            stillRecurring = true;
        }
        currentUser.editExpense(recurring, index - 1, name, amount, category, stillRecurring);
    }



}
