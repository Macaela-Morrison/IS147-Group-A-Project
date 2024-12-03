
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        //Testing data
        Expense testExpense = new Expense("Groceries1", 100, "Groceries", false);
        Expense testExpense2 = new Expense("Rent", 1500, "Housing", true);
        Expense testExpense3 = new Expense("Insurance", 800, "Housing", true);
        Expense testExpense4 = new Expense("Fix microwave", 150, "Household", false);
        User tempUser = new User("Test", "Test", "Test", "Test", 65000, 5417);

        tempUser.addExpense(tempUser.recurringExpenses, tempUser.nonRecurringExpenses, testExpense);
        tempUser.addExpense(tempUser.recurringExpenses, tempUser.nonRecurringExpenses, testExpense2);
        tempUser.addExpense(tempUser.recurringExpenses, tempUser.nonRecurringExpenses, testExpense3);
        tempUser.addExpense(tempUser.recurringExpenses, tempUser.nonRecurringExpenses, testExpense4);

        //Possible future implementation for multiple users --> For the demo
        //User[] users = {tempUser, tempUser2, tempUser3};

        Scanner input = new Scanner(System.in);
        DisplayMenus menu = new DisplayMenus();
        //tempUser.displayRecurring();
        menu.mainMenu(input, tempUser);
        tempUser.displayRecurring();
    }




            }

