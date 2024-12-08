import java.util.*;

/**
 * User class represents a user of the application and has attributes such as username, name, lastname,
 * password and income
 *
 */
public class User {

    private String username;
    private String name;
    private String lastName;
    private String password;
    private double annualIncome;
    private double monthlyIncome;

    private UserSettings userSettings = new UserSettings(monthlyIncome, annualIncome, "User");

    ArrayList<Expense> recurringExpenses = new ArrayList<>();
    ArrayList<Expense> nonRecurringExpenses = new ArrayList<>();

    /**
     * Default constructor for User.
     */
    User() {

    }

    /**
     * Parameterized constructor for User.
     *
     * @param username      The username of the user
     * @param name          The name of the user
     * @param lastName      The last name of the user
     * @param password      The password of the user
     * @param annualIncome  The annual income of the user
     * @param monthlyIncome The monthly income of the user
     */
    User(String username, String name, String lastName, String password, int annualIncome, int monthlyIncome) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.annualIncome = annualIncome;
        this.monthlyIncome = monthlyIncome;

        this.userSettings = new UserSettings(monthlyIncome, annualIncome, "User settings");
    }

    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the username of the user.
     *
     * @return username The username of the user
     */

    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the last name of the user.
     *
     * @return lastName The last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the password of the user.
     *
     * @return password The password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the yearly income of the user.
     *
     * @return annualIncome The yearly income of the user
     */
    public double getYearlyIncome() {
        return annualIncome;
    }

    /**
     * Sets the annual income of the user.
     *
     * @param annualIncome the annual income to set
     */
    public void setYearlyIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    /**
     * Gets the monthly of the user.
     *
     * @return monthlyIncome The monthly income of the user
     */
    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    /**
     * Sets the monthly income of the user.
     *
     * @param monthlyIncome the monthly income to set
     */
    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    /**
     * Returns the list of recurring expenses.
     *
     * @return the list of recurring expenses
     */
    public ArrayList<Expense> getRecurringExpenses() {
        return recurringExpenses;
    }

    /**
     * Returns the list of non-recurring expenses.
     *
     * @return the list of non-recurring expenses
     */
    public ArrayList<Expense> getNonRecurringExpenses() {
        return nonRecurringExpenses;
    }

    /**
     * Gets the settings associated with the user profile
     *
     * @return username The username of the user
     */
    public UserSettings getUserSettings() {
        return userSettings;
    }

    /**
     * Adds an expense to the appropriate list (recurring or non-recurring).
     *
     * @param recurringExpenses    The list of recurring expenses
     * @param nonRecurringExpenses The list of non-recurring expenses
     * @param currentExpense       The expense to add
     */
    public void addExpense(ArrayList<Expense> recurringExpenses, ArrayList<Expense> nonRecurringExpenses, Expense currentExpense) {
        if (currentExpense.getIsRecurring()) {
            recurringExpenses.add(currentExpense);
        } else {
            nonRecurringExpenses.add(currentExpense);
        }
    }

    /**
     * Finds expenses by name and recurrence type (recurring or non-recurring).
     *
     * @param name      The name to search for
     * @param recurring Whether to search in recurring expenses or non-recurring expenses
     * @return A list of matching expenses
     */
    public ArrayList<Expense> findExpenses(String name, boolean recurring) {
        ArrayList<Expense> matchingExpenses = new ArrayList<>();
        String lowerCaseName = name.toLowerCase();

        // Search in recurring expenses
        for (Expense temp : recurringExpenses) {
            if (temp.getName().toLowerCase().contains(lowerCaseName) && recurring) {
                matchingExpenses.add(temp);
            }
        }

        // Search in non-recurring expenses
        for (Expense temp : nonRecurringExpenses) {
            if (temp.getName().toLowerCase().contains(lowerCaseName) && !recurring) {
                matchingExpenses.add(temp);
            }
        }

        return matchingExpenses;
    }

    /**
     * Deletes an expense by its index and recurrence type.
     * Index is determined by user input
     *
     * @param recurring Whether the expense is recurring
     * @param index     The index of the expense to delete
     */
    public void deleteExpense(boolean recurring, int index) {
        if (recurring) {
            if (index > 0 && index <= recurringExpenses.size()) {
                recurringExpenses.remove(index - 1);
                System.out.println("Expense successfully removed");
            } else {
                System.out.println("Invalid choice");
            }
        } else {
            if (index > 0 && index <= nonRecurringExpenses.size()) {
                nonRecurringExpenses.remove(index - 1);
                System.out.println("Expense successfully removed");
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Edits an expense by its index and updates its details.
     * Details are determined by user input
     * An expense will be moved to the correct list if the "recurring" property changes
     *
     * @param recurring      Whether the expense is recurring
     * @param index          The index of the expense to edit
     * @param name           The new name of the expense
     * @param amount         The new amount of the expense
     * @param category       The new category of the expense
     * @param stillRecurring Whether the expense is still recurring after the edit
     */
    public void editExpense(boolean recurring, int index, String name, Double amount, String category, boolean stillRecurring) {
        if (recurring) {
            Expense tempExpense = recurringExpenses.get(index);
            tempExpense.setName(name);
            tempExpense.setAmount(amount);
            tempExpense.setCategory(category);
            tempExpense.setRecurring(stillRecurring);

            if (stillRecurring) {
                return;
            } else {
                nonRecurringExpenses.add(tempExpense);
                recurringExpenses.remove(index);
            }
        } else {
            Expense tempExpense = nonRecurringExpenses.get(index);
            tempExpense.setName(name);
            tempExpense.setAmount(amount);
            tempExpense.setCategory(category);
            tempExpense.setRecurring(stillRecurring);

            if (!stillRecurring) {
                return;
            } else {
                recurringExpenses.add(tempExpense);
                nonRecurringExpenses.remove(index);
            }
        }
    }

    /**
     * Displays the list of recurring expenses.
     */
    public void displayRecurring() {
        int index = 1;
        for (Expense temp : recurringExpenses) {
            System.out.println(index + ". " + temp);
            index++;
        }
    }

    /**
     * Displays the list of non-recurring expenses.
     */
    public void displayNonRecurring() {
        int index = 1;
        for (Expense temp : nonRecurringExpenses) {
            System.out.println(index + ". " + temp);
            index++;
        }
    }

    /**
     * Displays the total expenses based on recurrence type (recurring or non-recurring).
     *
     * @param recurring Whether to display totals for recurring or non-recurring expenses
     */
    public void displayTotals(boolean recurring) {
        if (recurring) {
            System.out.println("Recurring expenses: ");
            displayRecurring();
            calcTotals(recurring);
        } else {
            System.out.println("Non-recurring expenses: ");
            displayNonRecurring();
            calcTotals(recurring);
        }
    }

    /**
     * Calculates the total expense amount based on recurrence type.
     *
     * @param recurring Whether to calculate for recurring expenses or non-recurring expenses
     * @return the total expense amount
     */
    public double calcTotals(boolean recurring) {
        double total = 0;
        if (recurring) {
            for (Expense temp : recurringExpenses) {
                total += temp.getAmount();
            }
        } else {
            for (Expense temp : nonRecurringExpenses) {
                total += temp.getAmount();
            }
        }

        return total;
    }

    /**
     * Calculates the total remaining income after deducting all expenses.
     *
     * @return the remaining income
     */
    public double totalRemaining() {
        double recurringTotal = calcTotals(true);
        double nonRecurringTotal = calcTotals(false);
        return monthlyIncome - (recurringTotal + nonRecurringTotal);
    }

    /**
     * Provides a string representation of the user object.
     * This method was mostly used for internal testing to ensure information updated correctly
     *
     * @return a string representation of the user
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", annualIncome=" + annualIncome +
                ", monthlyIncome=" + monthlyIncome +
                ", userSettings=" + userSettings;
    }

}