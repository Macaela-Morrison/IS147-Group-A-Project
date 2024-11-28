
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Expense testExpense = new Expense("Groceries", 100, "Groceries");
        User tempUser = new User("Test", "Test", "Test", "Test", 10000, 500, testExpense);
        User tempUser2 = new User("Test2", "Test2", "Test2", "Test2", 10000, 500, testExpense);
        User tempUser3 = new User("Test3", "Test3", "Test3", "Test3", 10000, 500, testExpense);
        //For testing purposes I will use an array and array lists to store data
        User[] users = {tempUser, tempUser2, tempUser3};
        Scanner input = new Scanner(System.in);
        DisplayMenus menu = new DisplayMenus();

        menu.mainMenu(input);
    }




            }

