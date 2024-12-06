import java.util.Scanner;

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

    @Override
    public void editSettings(User currentUser, AppSettings applicationSettings)
    {
        Scanner userInput = new Scanner(System.in);
        DisplayMenus mainMenu = new DisplayMenus();
        int option;
        double newIncome = 0.0;
        boolean closeMenu = false;
        while(!closeMenu)
        {
            System.out.println("Please choose the setting you would like to change: ");
            System.out.println("1. Monthly income ");
            System.out.println("2. Yearly income");
            //Might add an option to change text color
            System.out.println("0. Cancel");

            option = userInput.nextInt();

            switch (option)
            {
                case 0:
                    closeMenu = true;
                    break;
                case 1:
                    //Prompt user to enter new monthly income
                    //Set monthly income to the new value
                    System.out.println("What is your new monthly income?");
                    newIncome = userInput.nextDouble();
                    currentUser.setMonthlyIncome(newIncome);
                    System.out.println(currentUser.getMonthlyIncome());
                    break;
                case 2:
                    //Prompt user to enter new yearly income
                    //Set yearly income to the new value
                    System.out.println("What is your new yearly income?");
                    newIncome = userInput.nextDouble();
                    currentUser.setYearlyIncome(newIncome);
                    System.out.println(currentUser.getYearlyIncome());
                    break;
            }
        }

    }

}
