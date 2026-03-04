package org.example;

import javax.swing.*;

public class Main {

    private static JTextField nameField;
    private static JTextField locField;
    private static JTextField quantField;
    private static JComboBox<String> months;
    private static JComboBox<String> days;
    private static JComboBox<String> years;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Inventory Input");
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setUp(frame);
        createFields(frame);
        selectDate(frame);
        submitButton(frame);
        clearButton(frame);

        frame.setVisible(true);
    }

    private static void setUp(JFrame frame) {

        JLabel itemLabel = new JLabel("Enter item name:");
        itemLabel.setBounds(100, 100, 150, 25);
        frame.add(itemLabel);

        JLabel currLabel = new JLabel("Enter current address:");
        currLabel.setBounds(100, 150, 150, 25);
        frame.add(currLabel);

        JLabel quantLabel = new JLabel("Enter quantity:");
        quantLabel.setBounds(100, 200, 150, 25);
        frame.add(quantLabel);

        JLabel dateLabel = new JLabel("Enter date:");
        dateLabel.setBounds(100, 250, 150, 25);
        frame.add(dateLabel);
    }

    private static void createFields(JFrame frame) {

        nameField = new JTextField();
        nameField.setBounds(250, 100, 150, 25);
        frame.add(nameField);

        locField = new JTextField();
        locField.setBounds(250, 150, 150, 25);
        frame.add(locField);

        quantField = new JTextField();
        quantField.setBounds(250, 200, 150, 25);
        frame.add(quantField);
    }

    private static void selectDate(JFrame frame) {

        months = new JComboBox<>();
        days = new JComboBox<>();
        years = new JComboBox<>();

        months.setBounds(250, 250, 50, 25);
        days.setBounds(310, 250, 50, 25);
        years.setBounds(370, 250, 80, 25);

        for (int i = 1; i <= 12; i++) {
            months.addItem(String.valueOf(i));
        }

        for (int i = 1; i <= 31; i++) {
            days.addItem(String.valueOf(i));
        }

        for (int i = 2023; i <= 2027; i++) {
            years.addItem(String.valueOf(i));
        }

        frame.add(months);
        frame.add(days);
        frame.add(years);
    }

    private static void submitButton(JFrame frame) {

        JButton submit = new JButton("Submit");
        submit.setBounds(150, 300, 100, 30);

        submit.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String location = locField.getText();
                int quantity = Integer.parseInt(quantField.getText());

                String month = (String) months.getSelectedItem();
                String day = (String) days.getSelectedItem();
                String year = (String) years.getSelectedItem();

                String[] date = {month, day, year};

                Item item = new Item(name, location, quantity, date);
                System.out.println(item);

                JOptionPane.showMessageDialog(frame, "Item submitted successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid quantity.");
            }
        });

        frame.add(submit);
    }

    private static void clearButton(JFrame frame) {
        JButton clear = new JButton("Clear");
        clear.setBounds(300,300,100,30);

        clear.addActionListener(e -> {
            nameField.setText("");
            locField.setText("");
            quantField.setText("");
        });

        frame.add(clear);
    }
}