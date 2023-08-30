import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // local variables
        boolean isRunning = true;
        double conversionResult = 0.00;
        // Our instance of the "Converter" object
        Converter converter;

        // Initialize the scanner
        Scanner in = new Scanner(System.in);
        // System greeting
        System.out.println("Welcome to the USD Currency Converter.");
        System.out.print("Please enter your first name: ");
        String firstName = in.nextLine();
        System.out.printf("Welcome, %s!\n", firstName);

        System.out.println("The currently available conversion rates are: ");
        System.out.println(" AUD\n CAD\n GBP\n USD\n YEN");

        // Ask for currency to convert FROM/TO
        System.out.println();
        System.out.print("Convert FROM currency: ");
        String convFrom = in.nextLine();
        System.out.print("Convert TO currency: ");
        String convTo = in.nextLine();

        // Construct our "Converter" object with the information we just got from the user.
        converter = new Converter(convFrom, convTo);
        // Print a nice little message to confirm details are correct.
        System.out.println(converter.getConversionDetails());

        System.out.print("Amount of " + converter.getStartingCurrency() + ": ");
        double curr1Amount = Double.parseDouble(in.nextLine());

        System.out.println("You want to convert " + curr1Amount + converter.getStartingCurrency() + " to " + converter.getEndingCurrency() + "?");
        String confirmation = in.nextLine().toUpperCase().substring(0,1);

        if (confirmation.equals("Y")) {
            if (converter.getStartingCurrency().equals("USD")) {
                conversionResult = converter.getConvertedAmount(curr1Amount, "USD");
            }
            else if (converter.getStartingCurrency().equals("AUD")) {
                conversionResult = converter.getConvertedAmount(curr1Amount, "AUD");
            }
            else if (converter.getStartingCurrency().equals("CAD")) {
                conversionResult = converter.getConvertedAmount(curr1Amount, "CAD");
            }
            else if (converter.getStartingCurrency().equals("GBP")) {
                conversionResult = converter.getConvertedAmount(curr1Amount, "GBP");
            }
            else if (converter.getStartingCurrency().equals("YEN")) {
                conversionResult = converter.getConvertedAmount(curr1Amount, "YEN");
            }
            else
            {
                System.out.printf("%s is not yet implemented.", converter.getStartingCurrency());
                System.exit(98);
            }
        }
        else {
            System.out.println("User terminated session. Thank you.");
            System.exit(99);
        }

        System.out.printf("%2.2f%s is worth %2.2f%s\n", curr1Amount, converter.getStartingCurrency(),
                conversionResult, converter.getEndingCurrency());
        System.out.println("Goodbye.");
        in.close();
    }
}