import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterGUI implements ActionListener {
    static final int WIDTH = 500;
    static final int HEIGHT = 300;
    static final Color bgColor = new Color(245, 213, 118);
    ImageIcon icon;
    JFrame f;
    JMenu menu;
    JMenuItem exit;
    JMenuBar mb;
    JLabel currencyFromLabel, currencyToLabel;
    JComboBox<String> currencyFromCB, currencyToCB;
    JTextField dollarAmount;
    JButton convert;
    Converter converter;
    public void mainWindow(){

        // Initialize our window
        f = new JFrame("Currency Converter");

        // Setup menu items.
        mb = new JMenuBar();
        menu = new JMenu("File");
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        menu.add(exit);
        mb.add(menu);

        // Setup the text area's for the title's of the combo boxes.
        currencyFromLabel = new JLabel("From:");
        currencyFromLabel.setBounds(50,10,90,30);

        currencyToLabel = new JLabel("To:");
        currencyToLabel.setBounds(200,10,90,30);

        // Setup the currency combo boxes and add them to the frame.
        String[] currencies = {"AUD", "CAD", "GBP", "USD", "YEN"};
        currencyFromCB= new JComboBox<>(currencies);
        currencyToCB = new JComboBox<>(currencies);
        currencyFromCB.setBounds(50,50,90,20);
        currencyToCB.setBounds(200,50,90,20);

        // Setup text area for user to enter dollar amount.
        dollarAmount = new JTextField("$$$");
        dollarAmount.setBounds(50,75,90,20);

        // Setup the Convert Button
        convert = new JButton("Convert");
        convert.setBounds(200,75,90,20);
        convert.addActionListener(this);

        // Add our icon to the frame
        try {
            icon = new ImageIcon("resources/salary.png");
            f.setIconImage(icon.getImage());
        } catch (Exception e) {
            System.out.println(e);
        }

        // Frame settings
        f.setJMenuBar(mb);
        f.add(currencyFromLabel);
        f.add(currencyToLabel);
        f.add(currencyFromCB);
        f.add(currencyToCB);
        f.add(dollarAmount);
        f.add(convert);
        f.setLayout(null);
        f.setSize(WIDTH,HEIGHT);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(bgColor);
        f.setResizable(false);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            // Exit the application
            f.dispose();
            System.exit(5);
        }
        if (ae.getSource() == convert) {
            try {
                // Setup our converter
                converter = new Converter(currencyFromCB.getItemAt(currencyFromCB.getSelectedIndex()),
                        currencyToCB.getItemAt(currencyToCB.getSelectedIndex()));

                // Set up local variables to handle the conversion calculation
                double amount = Double.parseDouble(dollarAmount.getText());
                String selectedCurrency = converter.getStartingCurrency();
                double convertedAmount = converter.getConvertedAmount(amount, selectedCurrency);
                String message = amount + " " + selectedCurrency + " is equal to " + convertedAmount +
                        " " + converter.getEndingCurrency();

                JOptionPane.showMessageDialog(f, message);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(f, e + "\nPlease enter a valid number.");
            }
        }
    }

}
