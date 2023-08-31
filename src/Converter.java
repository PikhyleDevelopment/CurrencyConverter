import java.util.*;

public class Converter {
    // Private class variables
    private static String currency1;
    private static String currency2;

    private static final HashMap<String,Double> convRatesUSD = new HashMap<>();
    private static final HashMap<String,Double> convRatesAUD = new HashMap<>();
    private static final HashMap<String,Double> convRatesCAD = new HashMap<>();
    private static final HashMap<String,Double> convRatesGBP = new HashMap<>();
    private static final HashMap<String,Double> convRatesYEN = new HashMap<>();


    // Converter Constructor
    public Converter(String convertFrom, String convertTo) {
        currency1 = convertFrom.toUpperCase();
        currency2 = convertTo.toUpperCase();
        initConversionRates();
    }

    // Basic conversion rates to compare the USD to.
    // Sourced from https://www.federalreserve.gov/releases/h10/current/
    private static void initConversionRates() {
        // USD Conversion Rates
        convRatesUSD.put("AUD", 1.5443);
        convRatesUSD.put("USD", 1.0);
        convRatesUSD.put("CAD", 1.3626);
        convRatesUSD.put("GBP", 0.790);
        convRatesUSD.put("YEN", 146.3800);
        // AUD Conversion Rates
        convRatesAUD.put("USD", 0.65);
        convRatesAUD.put("AUD", 1.0);
        convRatesAUD.put("CAD", 0.88);
        convRatesAUD.put("GBP", 0.51);
        convRatesAUD.put("YEN", 94.63);
        // CAD Conversion Rates
        convRatesCAD.put("CAD", 1.0);
        convRatesCAD.put("AUD", 1.14);
        convRatesCAD.put("GBP", 0.58);
        convRatesCAD.put("USD", 0.74);
        convRatesCAD.put("YEN", 107.57);
        // GBP Conversion Rates
        convRatesGBP.put("GBP", 1.0000);
        convRatesGBP.put("AUD", 1.9511);
        convRatesGBP.put("CAD", 1.7134);
        convRatesGBP.put("USD", 1.2637);
        convRatesGBP.put("YEN", 184.4880);
        // YEN Conversion Rates
        convRatesYEN.put("YEN", 1.0000);
        convRatesYEN.put("AUD", 0.0110);
        convRatesYEN.put("CAD", 0.0093);
        convRatesYEN.put("GBP", 0.0054);
        convRatesYEN.put("USD", 0.0068);


    }

    // Utility methods for this class
    public String getStartingCurrency() {
        return currency1;
    }

    public String getEndingCurrency() {
        return currency2;
    }

    /*public String getConversionDetails() {
        return currency1 + " ==> " + currency2;
    }*/

    // "Generic" converter method so we don't have 1 each per different currency.

    public double getConvertedAmount(double amount, String currType) {
        double convertedAmount;

        if (amount <= 0) {
            convertedAmount = 0;
            System.out.println("Invalid number passed to converter.");
            return convertedAmount;
        }

        switch (currType) {
            case "USD" -> convertedAmount = amount * convRatesUSD.get(currency2);
            case "AUD" -> convertedAmount = amount * convRatesAUD.get(currency2);
            case "CAD" -> convertedAmount = amount * convRatesCAD.get(currency2);
            case "GBP" -> convertedAmount = amount * convRatesGBP.get(currency2);
            case "YEN" -> convertedAmount = amount * convRatesYEN.get(currency2);
            default -> convertedAmount = 0.0;
        }

        return convertedAmount;
    }
}
