public class Expense {
    private String name;
    private double amount;
    private String category;

    //Default constructor
    public Expense()
    {
        super();
    }

    //Parameterized constructor
    public Expense(String name, double amount, String category)
    {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public String getName()
    {
        return name;
    }

    public double getAmount()
    {
        return amount;
    }
    public String getCategory()
    {
        return category;
    }

    public void addExpense()
    {
        //Add expense to array
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

    public void displayExpense()
    {
        //Search the array
        findExpense();
    }



}