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
     * @param username      the username of the user
     * @param name          the name of the user
     * @param lastName      the last name of the user
     * @param password      the password of the user
     * @param annualIncome  the annual income of the user
     * @param monthlyIncome the monthly income of the user
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
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

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

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public UserSettings getUserSettings() {
        return userSettings;
    }

    /**
     * Adds an expense to the appropriate list (recurring or non-recurring).
     *
     * @param recurringExpenses    the list of recurring expenses
     * @param nonRecurringExpenses the list of non-recurring expenses
     * @param currentExpense       the expense to add
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
     * @param name      the name to search for
     * @param recurring whether to search in recurring expenses
     * @return a list of matching expenses
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
     *
     * @param recurring whether the expense is recurring
     * @param index     the index of the expense to delete
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
     *
     * @param recurring      whether the expense is recurring
     * @param index          the index of the expense to edit
     * @param name           the new name of the expense
     * @param amount         the new amount of the expense
     * @param category       the new category of the expense
     * @param stillRecurring whether the expense is still recurring after the edit
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
     * @param recurring whether to calculate for recurring expenses
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
     * @param recurring whether to calculate for recurring expenses
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