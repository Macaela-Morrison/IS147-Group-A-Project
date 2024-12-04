
import java.util.*;
public class User {

    private String username;
    private String name;
    private String lastName;
    private String password;
    private int annualIncome;
    private int monthlyIncome;

    private AppSettings settings;

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

    public ArrayList<Expense> getRecurringExpenses()
    {
        return recurringExpenses;
    }

    public ArrayList<Expense> getNonRecurringExpenses()
    {
        return nonRecurringExpenses;
    }

    public AppSettings getSettings() {
        return settings;
    }

    public void addExpense(ArrayList<Expense> recurringExpenses, ArrayList<Expense> nonRecurringExpenses, Expense currentExpense)
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

    public double calcTotals(boolean recurring)
    {
        if(recurring)
        {
            //Return the recurring totals
            //Iterate through the array list and create a running total of the amounts.
            //You can use a for-loop to iterate through the array list

            for(int i = 0; i < recurringExpenses.size(); i++)
            {
                //get a running total
                //you have something like total += temp; to get a running total
            }
            //There are other ways to iterate through an array list, but we have to have a for-loop in the project 
        }

        //Return the non-recurring totals
        //Do the same thing as above
        return 0;
    }

    public void displayTotals(boolean recurring)
    {
        if(recurring)
        {
            displayRecurring();
            calcTotals(recurring);
            //Then print out the totals
            System.out.println("Recurring expenses: ");

        }
       else
        {
            displayNonRecurring();
            calcTotals(recurring);
            //Print out the non-recurring totals
            System.out.println("Non-recurring expenses: ");
        }


    }

    public double calcTotals(boolean recurring)
    {   
        double total = 0;
        if (recurring)
        {
            // calculate total for recurring expense
            for (int i = 0; i < recurringExpenses.size(); i++)
            {
                total += recurringExpenses.get(i).getAmount();
            }
        }
        else
        {
            // Calculate total for non-recurring expenses
            for (int i = 0; i < nonRecurringExpenses.size(); i++)
            {
                total += nonRecurringExpenses.get(i).getAmount();
            }
        }

        return total;
    }
    public void totalRemaining(double monthlyIncome)
    {
        // Get totals for recurring and non-recurring expenses
        double recurringTotal = calcTotals(true);
        double nonRecurringTotal = calcTotals(false);

        // Calculate remaining incme
        double remainingIncome = monthlyIncome - (recurringTotal + nonRecurringTotal);

        // Print the total remaining
        System.out.printf("Total remaining income: %.2f\n", remainingIncome);
    }      

}
