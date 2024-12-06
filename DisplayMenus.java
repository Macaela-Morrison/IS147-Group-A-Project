import java.util.*;

public class DisplayMenus {

    public void mainMenu(Scanner input, User currrentUser, AppSettings applicationSettings){
        while (true) {


            System.out.println("Welcome to Personal Budgeting Program! Please see menu options below:");
            System.out.printf("You have %.2f remaining for this month\n", currrentUser.totalRemaining());
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
                    recurringExpensesMenu(input, currrentUser);
                    break;
                case 2:
                    nonRecurringExpensesMenu(input,currrentUser);
                    break;
                case 3:
                    displayOverallTotal(currrentUser);
                    break;
                case 4:
                    displayYearlyOverview();
                    break;
                case 5:
                    settingsMenu(input, currrentUser, applicationSettings);
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

    public void recurringExpensesMenu(Scanner input, User currentUser) {
        boolean exitRecurringMenu = false;

        while (!exitRecurringMenu) {
            System.out.println("1. Add Expense");
            System.out.println("2. Delete Expense");
            System.out.println("3. View Totals");
            System.out.println("4. Search For An Expense");
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

                    //Testing
                    //currentUser.displayRecurring();

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
                    System.out.println("Search for Expense: ");
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

    public void nonRecurringExpensesMenu(Scanner input, User currentUser) {
        boolean exitNonRecurringMenu = false;

        while (!exitNonRecurringMenu) {
            System.out.println("Non-Recurring Expenses Menu:");
            System.out.println("1. Add Non-Recurring Expense");
            System.out.println("2. Delete Non-Recurring Expense");
            System.out.println("3. View Non-Recurring Expense Total");
            System.out.println("4. Search for a Non-Recurring expense");
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
                    System.out.println("Search for an Expense: ");
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


    public void displayOverallTotal(User currentUser) {
        double totalRecurring = currentUser.calcTotals(true);
        double totalNonRecurring = currentUser.calcTotals(false);
        double overallTotal = totalRecurring + totalNonRecurring;
        System.out.println("Total recurring expenses: $" + totalRecurring);
        System.out.println("Total non-recurring expenses: $" + totalNonRecurring);
        System.out.println("Your total expenses for this month so far is: $" + overallTotal);



    }

    public static void displayYearlyOverview() {
        System.out.println("Displaying yearly overview: ");
    }

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

    public static void addExpenseMenu(User currentUser)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please provide the details of your expense.");
        System.out.print("Enter a name for your expense: ");
        String name = input.nextLine();
        System.out.print("Enter the amount: $");
        double amount = input.nextDouble();
        input.nextLine(); //Clear the leftover newline character
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
        System.out.print("Enter the amount: $");
        double amount = input.nextDouble();
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
