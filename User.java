
import java.util.*;
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

        this.userSettings = new UserSettings(monthlyIncome, annualIncome, "User settings");
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

    public double getYearlyIncome() {
        return annualIncome;
    }

    public void setYearlyIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
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

    public UserSettings getUserSettings() {
        return userSettings;
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

    public ArrayList<Expense> findExpenses(String name, boolean recurring) {
        ArrayList<Expense> matchingExpenses = new ArrayList<>();
        //Convert name to lowercase to make matching more accurate
        String lowerCaseName = name.toLowerCase();

        // Search in recurring expenses using an iterator and add any partial matches to the temporary array list
        Iterator<Expense> rit = recurringExpenses.iterator();
        while (rit.hasNext()) {
            Expense temp = rit.next();
            if (temp.getName().toLowerCase().contains(lowerCaseName) && recurring) {
                matchingExpenses.add(temp);
            }
        }

        // Search in non-recurring expenses using an iterator
        Iterator<Expense> nit = nonRecurringExpenses.iterator();
        while (nit.hasNext()) {
            Expense temp = nit.next();
            if (temp.getName().toLowerCase().contains(lowerCaseName) && !recurring) {
                matchingExpenses.add(temp);
            }
        }

        return matchingExpenses;
    }


    public void deleteExpense(boolean recurring, int index)
    {
        //List elements in the array list
        if(recurring)
        {
            //delete recurring expense
            if(index > 0 && index <= recurringExpenses.size())
            {
                recurringExpenses.remove(index - 1);
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
                nonRecurringExpenses.remove(index - 1);
                System.out.println("Expense successfully removed");
            }
            else
            {
                System.out.println("Invalid choice");
            }
        }



    }


    public void editExpense(boolean recurring, int index, String name, Double amount, String category, boolean stillRecurring)
    {
        if(recurring) {
            Expense tempExpense = recurringExpenses.get(index);
            tempExpense.setName(name);
            tempExpense.setAmount(amount);
            tempExpense.setCategory(category);
            tempExpense.setRecurring(stillRecurring);

            if (stillRecurring)
            {
                return;
            }
            else
            {
                nonRecurringExpenses.add(tempExpense);
                recurringExpenses.remove(index);
            }
        }
        else
        {
            Expense tempExpense = nonRecurringExpenses.get(index);
            tempExpense.setName(name);
            tempExpense.setAmount(amount);
            tempExpense.setCategory(category);
            tempExpense.setRecurring(stillRecurring);

            if (!stillRecurring)
            {
                return;
            }
            else
            {
                recurringExpenses.add(tempExpense);
                recurringExpenses.remove(index);
            }
        }
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

    public void displayTotals(boolean recurring)
    {
        if(recurring)
        {
            //Print out recurring expenses
            System.out.println("Recurring expenses: ");
            displayRecurring();
            calcTotals(recurring);



        }
       else
        {
            //Print out non-recurring expenses
            System.out.println("Non-recurring expenses: ");
            displayNonRecurring();
            calcTotals(recurring);


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

    public double totalRemaining()
    {
        // Get totals for recurring and non-recurring expenses
        double recurringTotal = calcTotals(true);
        double nonRecurringTotal = calcTotals(false);

        // Calculate remaining income
        double remainingIncome = monthlyIncome - (recurringTotal + nonRecurringTotal);

        // Return the total remaining
        return remainingIncome;
    }      

    //To possibly display user information
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", annualIncome=" + annualIncome +
                ", monthlyIncome=" + monthlyIncome +
                ", userSettings=" + userSettings +
                '}';
    }

}
