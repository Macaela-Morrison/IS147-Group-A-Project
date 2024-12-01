
import java.util.*;
public class User {

    private String username;
    private String name;
    private String lastName;
    private String password;
    private int annualIncome;
    private int monthlyIncome;

    private Expense expenses;

    ArrayList<Expense> recurringExpenses = new ArrayList<>();
    ArrayList<Expense> nonRecurringExpenses = new ArrayList<>();

    User()
    {

    }

    User(String username, String name, String lastName, String password, int annualIncome, int monthlyIncome)
    {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.annualIncome = annualIncome;
        this.monthlyIncome = monthlyIncome;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Expense getExpenses() {
        return expenses;
    }

    public void setExpenses(Expense expenses) {
        this.expenses = expenses;
    }

    public void addExpense(ArrayList<Expense> recurringExpenses,  ArrayList<Expense> nonRecurringExpenses, Expense currentExpense)
    {
        //Add expense to array list
        if(currentExpense.getIsRecurring())
        {
            recurringExpenses.add(currentExpense);
        }
        else
        {
            nonRecurringExpenses.add(currentExpense);
        }

    }

    public void findExpense()
    {

    }

    public void renameExpense()
    {
        //Might add this feature
    }

    public void deleteExpense()
    {
        //Search the array
        findExpense();

        //Remove the expense
        //Move the other expenses over to avoid gaps
    }

    public void editExpense()
    {
        //Search the array
        findExpense();

        //Change data
    }

    public void displayRecurring()
    {
        Iterator<Expense> it = recurringExpenses.iterator();
        while(it.hasNext())
        {
            Expense temp = it.next();
            System.out.println(temp);
        }
    }
}
