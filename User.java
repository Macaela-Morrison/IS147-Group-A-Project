public class User {

    private String username;
    private String name;
    private String lastName;
    private String password;
    private int annualIncome;
    private int monthlyIncome;

    private Expense expenses;

    User()
    {

    }

    User(String username, String name, String lastName, String password, int annualIncome, int monthlyIncome, Expense expenses)
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


}
