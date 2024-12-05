import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Expense {
    private String name;
    private double amount;
    private String category;
    private boolean isRecurring;
    private String timestamp;

    //Default constructor
    public Expense()
    {
        this.timestamp = getTimestamp();
    }

    //Parameterized constructor
    public Expense(String name, double amount, String category, boolean isRecurring)
    {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.isRecurring = isRecurring;
        this.timestamp = getTimestamp();
    }

    public String getTimestamp() {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return currentDate.format(format);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean getIsRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    public Expense createExpense(String name, double amount, String category, boolean isRecurring)
    {
        Expense tempExpense = new Expense(name, amount, category, isRecurring);
        tempExpense.timestamp = getTimestamp();

        return tempExpense;
    }

    @Override
    public String toString()
    {
        return "Expense: " + name + ", Amount: $" + amount + ", Date: " + timestamp + ", Category: " + category;
    }



}
