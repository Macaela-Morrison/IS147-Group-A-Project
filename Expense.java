import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Expense class represents an expense with attributes such as name, amount, category,
 * whether it is recurring, and the timestamp of creation.
 */
public class Expense {
    private String name;
    private double amount;
    private String category;
    private boolean isRecurring;
    private String timestamp;

    /**
     * Default constructor for Expense class.
     * Initializes the expense with the current timestamp.
     */
    public Expense() {
        this.timestamp = getTimestamp();
    }

    /**
     * Parameterized constructor for Expense.
     *
     * @param name        the name of the expense
     * @param amount      the amount of the expense
     * @param category    the category of the expense
     * @param isRecurring whether the expense is recurring
     */
    public Expense(String name, double amount, String category, boolean isRecurring) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.isRecurring = isRecurring;
        this.timestamp = getTimestamp();
    }

    /**
     * Generates a timestamp in the format MM-dd-yyyy HH:mm, example 12-03-2024 23:56
     *
     * @return the formatted timestamp as a String
     */
    public String getTimestamp() {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        return currentDate.format(format);
    }

    /**
     * Gets the name of the expense.
     *
     * @return the name of the expense
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the expense.
     *
     * @param name the name of the expense
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the amount of the expense.
     *
     * @return the amount entered for the expense
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the expense.
     *
     * @param amount the amount to set for the expense
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the category of the expense.
     *
     * @return the category of the expense
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the expense.
     *
     * @param category the category the expense is set to be in
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Checks if the expense is recurring or non-recurring.
     *
     * @return true if the expense is recurring, false otherwise
     */
    public boolean getIsRecurring() {
        return isRecurring;
    }

    /**
     * Sets whether the expense is recurring.
     *
     * @param recurring true if the expense is recurring, false otherwise
     */
    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    /**
     * Creates a new Expense instance when called. Used in User class to add a new expense
     * and for initial setup of project demo
     *
     * @param name        the name of the expense
     * @param amount      the amount of the expense
     * @param category    the category of the expense
     * @param isRecurring whether the expense is recurring
     * @return the newly created Expense
     */
    public Expense createExpense(String name, double amount, String category, boolean isRecurring) {
        Expense tempExpense = new Expense(name, amount, category, isRecurring);
        tempExpense.timestamp = getTimestamp();
        return tempExpense;
    }

    /**
     * Override of toString methods which returns a formatted string representing the expense
     *
     * @return a formatted string with expense details
     */
    @Override
    public String toString() {
        return "Expense: " + name + ", Amount: $" + amount + ", Date: " + timestamp + ", Category: " + category;
    }
}
