
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

    public ArrayList<Expense> getRecurringExpenses()
    {
        return recurringExpenses;
    }

    public ArrayList<Expense> getNonRecurringExpenses()
    {
        return nonRecurringExpenses;
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

    public Expense findExpense(ArrayList<Expense> recurringExpenses,  ArrayList<Expense> nonRecurringExpenses)
    {
        Iterator<Expense> rit = recurringExpenses.iterator();
        while(rit.hasNext())
        {
            Expense temp = rit.next();
            System.out.println(temp);
        }

        Iterator<Expense> nit = nonRecurringExpenses.iterator();
        while(nit.hasNext())
        {
            Expense temp = nit.next();
            System.out.println(temp);
        }

        return rit.next();
    }

    public void renameExpense()
    {
        //Might add this feature
    }

    public void deleteExpense(boolean recurring, int index)
    {
        //List elements in the array list
        if(recurring)
        {
            //delete recurring expense
            if(index > 0 && index <= recurringExpenses.size())
            {
                Expense removeExpense = recurringExpenses.remove(index - 1);
                System.out.println("Expense successfully removed");
            }
            else
            {
                System.out.println("Invalid choice");
            }
        }
        else
        {
            //delete non-recurring expense
            if(index > 0 && index <= nonRecurringExpenses.size())
            {
                Expense removeExpense = nonRecurringExpenses.remove(index - 1);
                System.out.println("Expense successfully removed");
            }
            else
            {
                System.out.println("Invalid choice");
            }
        }



    }

    public void editExpense()
    {
        //Search the array
        //findExpense();

        //Change data
    }

    public void displayRecurring()
    {
        int index = 1;
        Iterator<Expense> it = recurringExpenses.iterator();
        while(it.hasNext()) {
            Expense temp = it.next();
            System.out.println(index + ". " + temp);
            index++;
        }
    }

    public void displayNonRecurring()
    {
        int index = 1;
        Iterator<Expense> it = nonRecurringExpenses.iterator();
        while(it.hasNext())
        {
            Expense temp = it.next();
            System.out.println(index + ". " + temp);
            index++;
        }
    }
}
