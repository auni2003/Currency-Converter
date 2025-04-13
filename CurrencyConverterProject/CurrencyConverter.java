import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class CurrencyConverter extends JFrame {
    JComboBox<String> fromCurrency, toCurrency;
    JTextField amountField;
    JLabel resultLabel;
    HashMap<String, Double> rates = new HashMap<>();

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(450, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Load the background image
        JLabel background = new JLabel(new ImageIcon("currency_background.jpg"));
        background.setLayout(null);
        setContentPane(background);

        // Title
        JLabel titleLabel = new JLabel("Currency Converter");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(120, 30, 250, 40);
        background.add(titleLabel);

        int centerX = 225; 

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(centerX - 150, 100, 80, 25);
        background.add(fromLabel);

        fromCurrency = new JComboBox<>(new String[]{"USD", "EUR", "INR", "JPY"});
        fromCurrency.setBounds(centerX - 60, 100, 120, 25);
        background.add(fromCurrency);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(centerX - 150, 140, 80, 25);
        background.add(toLabel);

        toCurrency = new JComboBox<>(new String[]{"USD", "EUR", "INR", "JPY"});
        toCurrency.setBounds(centerX - 60, 140, 120, 25);
        background.add(toCurrency);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(centerX - 150, 180, 80, 25);
        background.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(centerX - 60, 180, 120, 25);
        background.add(amountField);

        JButton convertBtn = new JButton("Convert");
        convertBtn.setBounds(centerX - 60, 220, 120, 30);
        background.add(convertBtn);

        resultLabel = new JLabel("Converted: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 30));
        resultLabel.setBounds(centerX - 100, 270, 320, 280);
        background.add(resultLabel);

        rates.put("USD", 1.0);
        rates.put("EUR", 0.91);
        rates.put("INR", 83.25);
        rates.put("JPY", 151.30);

        convertBtn.addActionListener(e -> convertCurrency());

        setVisible(true);
    }

    private void convertCurrency() {
        try {
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();
            double amount = Double.parseDouble(amountField.getText());
            double baseAmount = amount / rates.get(from);
            double converted = baseAmount * rates.get(to);
            resultLabel.setText("Converted: " + String.format("%.2f", converted) + " " + to);
        } catch (Exception ex) {
            resultLabel.setText("Invalid input.");
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}