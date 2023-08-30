public class Main {

    /*JFrame f;
    Main() {
        f = new JFrame("Currency Converter");
        String currencies[] = {"AUD","CAD","GBP","USD","YEN"};
        JComboBox currencyCombo = new JComboBox(currencies);
        currencyCombo.setBounds(50,50,90,20);
        f.add(currencyCombo);
        f.setLayout(null);
        f.setSize(600,600);
        f.setVisible(true);
    }*/
    static ConverterGUI gui = new ConverterGUI();
    public static void main(String[] args) {
        // local variables
        /*double conversionResult = 0.00;
        String firstName;
        String convFrom;
        String convTo;
        // Our instance of the "Converter" object
        Converter converter;*/
        //new Main();

        gui.mainWindow();

        /*// Initialize the scanner
        Scanner in = new Scanner(System.in);
        // System greeting
        System.out.println("Welcome to the USD Currency Converter.");
        System.out.print("Please enter your first name: ");
        firstName = in.nextLine();
        System.out.printf("Welcome, %s!\n", firstName);

        // Main application loop start
        while (true) {
            System.out.println("The currently available conversion rates are: ");
            System.out.println(" AUD\n CAD\n GBP\n USD\n YEN");
            System.out.println("You can always type EXIT to leave.");

            // Ask for currency to convert FROM/TO
            System.out.println();
            System.out.print("Convert FROM currency: ");
            convFrom = in.nextLine();
            // Check exit condition
            if (convFrom.equalsIgnoreCase("EXIT")) {
                //isRunning = false;
                break;
            }
            System.out.print("Convert TO currency: ");
            convTo = in.nextLine();
            // Check exit condition
            if (convTo.equalsIgnoreCase("EXIT")) {
                //isRunning = false;
                break;
            }

            // Construct our "Converter" object with the information we just got from the user.
            converter = new Converter(convFrom, convTo);
            // Print a nice little message to confirm details are correct.
            System.out.println(converter.getConversionDetails());

            System.out.print("Amount of " + converter.getStartingCurrency() + ": ");
            double curr1Amount = Double.parseDouble(in.nextLine());

            System.out.println("You want to convert " + curr1Amount + converter.getStartingCurrency() + " to " + converter.getEndingCurrency() + "?[Y/N]");
            String confirmation = in.nextLine().toUpperCase().substring(0, 1);

            if (confirmation.equals("Y")) {
                switch (converter.getStartingCurrency()) {
                    case "USD" -> conversionResult = converter.getConvertedAmount(curr1Amount, "USD");
                    case "AUD" -> conversionResult = converter.getConvertedAmount(curr1Amount, "AUD");
                    case "CAD" -> conversionResult = converter.getConvertedAmount(curr1Amount, "CAD");
                    case "GBP" -> conversionResult = converter.getConvertedAmount(curr1Amount, "GBP");
                    case "YEN" -> conversionResult = converter.getConvertedAmount(curr1Amount, "YEN");
                    default -> {
                        System.out.printf("%s is not yet implemented.", converter.getStartingCurrency());
                        System.exit(98);
                    }
                }
            } else {
                System.out.println("User terminated session. Thank you. Goodbye.");
                System.exit(99);
            }

            System.out.printf("%2.2f%s is worth %2.2f%s\n", curr1Amount, converter.getStartingCurrency(),
                    conversionResult, converter.getEndingCurrency());
        }


        System.out.println("Goodbye.");
        in.close();*/
    }
}