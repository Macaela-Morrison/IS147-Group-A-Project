import java.util.*;

public class AppSettings {

    private double monthlyIncome;
    private double yearlyIncome;

    //Possible feature
    //public String textColor;

    public AppSettings(double monthlyIncome, double yearlyIncome)
    {
        this.monthlyIncome = monthlyIncome;
        this.yearlyIncome = yearlyIncome;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public double getYearlyIncome() {
        return yearlyIncome;
    }

    public void editSettings()
    {
        Scanner userInput = new Scanner(System.in);
        byte option;
        do {
            System.out.println("Please choose the setting you would like to change: ");
            System.out.println("1. Monthly income ");
            System.out.println("2. Yearly income");
            //Might add an option to change text color
            System.out.println("0. Cancel");

            option = userInput.nextByte();

            switch (option)
            {
                case 0:
                    System.out.println("This way to the exit");
                    System.exit(0);
                    break;
                case 1:
                    //Prompt user to enter new monthly income
                    //Set monthly income to the new value
                    System.out.println("Option 1 chosen");
                    break;
                case 2:
                    //Prompt user to enter new yearly income
                    //Set yearly income to the new value
                    System.out.println("Option 2 chosen");
                    break;
            }
        } while (option != 0);

    }
}
