
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Expense testExpense = new Expense("Groceries", 100, "Groceries", false);
        Expense testExpense2 = new Expense("Rent", 1000, "Rent", true);
        User tempUser = new User("Test", "Test", "Test", "Test", 10000, 500);
        User tempUser2 = new User("Test2", "Test2", "Test2", "Test2", 10000, 500);
        User tempUser3 = new User("Test3", "Test3", "Test3", "Test3", 10000, 500);
        tempUser.addExpense(tempUser.recurringExpenses, tempUser.nonRecurringExpenses, testExpense);
        tempUser.addExpense(tempUser.recurringExpenses, tempUser.nonRecurringExpenses, testExpense2);
        //For testing purposes I will use an array and array lists to store data
        User[] users = {tempUser, tempUser2, tempUser3};
        Scanner input = new Scanner(System.in);
        DisplayMenus menu = new DisplayMenus();
        //tempUser.displayRecurring();
        menu.mainMenu(input, tempUser);
        tempUser.displayRecurring();
    }




            }

