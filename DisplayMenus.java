import java.util.Scanner;

public class DisplayMenus {

    public void mainMenu(Scanner input){
        while (true) {
            System.out.println("Welcome to Personal Budgeting Program! Please see menu options below:");
            System.out.println("1. Recurring Expenses");
            System.out.println("2. Non-Recurring Expenses");
            System.out.println("3. Overall Total");
            System.out.println("4. Yearly Overview");
            System.out.println("5. Settings");
            System.out.println("0. Quit");
            System.out.print("Enter a choice: ");
            int number = input.nextInt();

            switch (number) {
                case 1:
                    recurringExpensesMenu(input);
                    break;
                case 2:
                    nonRecurringExpensesMenu(input);
                    break;
                case 3:
                    displayOverallTotal();
                    break;
                case 4:
                    displayYearlyOverview();
                    break;
                case 5:
                    settingsMenu(input);
                    break;
                case 0:
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    public void recurringExpensesMenu(Scanner input) {
        boolean exitRecurringMenu = false;

        while (!exitRecurringMenu) {
            System.out.println("1. Add Expense");
            System.out.println("2. Delete Expense");
            System.out.println("3. View Totals");
            System.out.println("4. Search For An Expense");
            System.out.println("5. Back to Main Menu");
            System.out.println("0. Quit");
            System.out.print("Enter a choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting the program");
                    break;
                case 1:
                    System.out.println("Add Expense: ");
                    break;
                case 2:
                    System.out.println("Delete Expense: ");
                    break;
                case 3:
                    System.out.println("View Total Expenses: ");
                    break;
                case 4:
                    System.out.println("Search for Expense: ");
                    break;
                case 5:
                    exitRecurringMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    public void nonRecurringExpensesMenu(Scanner input) {
        boolean exitNonRecurringMenu = false;

        while (!exitNonRecurringMenu) {
            System.out.println("Non-Recurring Expenses Menu:");
            System.out.println("1. Add Non-Recurring Expense");
            System.out.println("2. Delete Non-Recurring Expense");
            System.out.println("3. View Non-Recurring Expense Total");
            System.out.println("4. Search for a Non-Recurring expense");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter a choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting the program");
                    break;
                case 1:
                    System.out.println("Add Expense: ");
                    break;
                case 2:
                    System.out.println("Delete Expense: ");
                    break;
                case 3:
                    System.out.println("View Total: ");
                    break;
                case 4:
                    System.out.println("Search for an Expense: ");
                    break;
                case 5:
                    exitNonRecurringMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }


    public void displayOverallTotal() {
        System.out.println("Displaying overall total: ");
    }

    public static void displayYearlyOverview() {
        System.out.println("Displaying yearly overview: ");
    }

    public static void settingsMenu(Scanner input) {
        boolean exitSettingsMenu = false;

        while (!exitSettingsMenu) {
            System.out.println("Settings Menu:");
            System.out.print("Enter a choice: ");
            int choice = input.nextInt();
            System.out.println();
        }
    }

    
}
