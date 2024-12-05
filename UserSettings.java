public class UserSettings extends Settings{

    private double monthlyIncome;
    private double yearlyIncome;

    public UserSettings()
    {
        super();
    }

    public UserSettings(double monthlyIncome, double yearlyIncome, String name)
    {
        super(name);
        this.monthlyIncome = monthlyIncome;
        this.yearlyIncome = yearlyIncome;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

}
