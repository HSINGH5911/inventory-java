package org.example;

import javax.security.auth.kerberos.KerberosCredMessage;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800,800);
        frame.setLayout(null);

        setUp(frame);
        getItemName(frame);
        getCurrLoc(frame);
        getQuantity(frame);
        submitInfo(frame);
        getDate(frame);

        frame.setVisible(true);
    }

    /**
     * Setup the GUI
     */
    private static void setUp(JFrame frame) {
        JLabel itemLabel = new JLabel("Enter item name: ");
        itemLabel.setBounds(100,100, 150,25);
        frame.add(itemLabel);

        JLabel currLabel = new JLabel("Enter current address: ");
        currLabel.setBounds(100, 150, 150, 25);
        frame.add(currLabel);

        JLabel quantLabel = new JLabel("Enter quantity: ");
        quantLabel.setBounds(100, 200, 150, 25);
        frame.add(quantLabel);

        JLabel dateLabel = new JLabel("Enter date");
        dateLabel.setBounds(100,250,150,25);
        frame.add(dateLabel);
    }

    /**
     * Get the name of the item
     * @param frame -> JFrame object to add items onto
     * @return -> The item name
     */
    private static String getItemName(JFrame frame) {
        JTextField nameField = new JTextField();
        nameField.setBounds(250, 100, 150, 25);
        String name = nameField.getText();
        frame.add(nameField);

        return name;
    }

    /**
     * Get the current location of the item
     * @param frame -> JFrame object to add items onto
     * @return -> The current location
     */
    private static String getCurrLoc(JFrame frame) {
        JTextField locField = new JTextField();
        locField.setBounds(250, 150, 150, 25);
        String currLoc = locField.getText();
        frame.add(locField);

        return currLoc;
    }

    /**
     * Get the quantity of the item
     * @param frame -> JFrame object to add items onto
     * @return -> The quantity
     */
    private static String getQuantity(JFrame frame) {
        JTextField quantField = new JTextField();
        quantField.setBounds(250, 200, 150, 25);
        String quant = quantField.getText();
        frame.add(quantField);

        return quant;
    }

    private static void getDate(JFrame frame) {
        JComboBox<String> months = new JComboBox<>();
        JComboBox<String> days = new JComboBox<>();
        JComboBox<String> years = new JComboBox<>();

        months.setBounds(250,250,50,25);
        days.setBounds(300,250,50,25);
        years.setBounds(350,250,100,25);

        for (int i = 1; i < 13; i++) {
            months.addItem(String.valueOf(i));
        }

        for (int i = 1; i < 32; i++) {
            days.addItem(String.valueOf(i));
        }

        for (int i = 0; i < 5; i++) {
            years.addItem(String.valueOf(i + 2023));
        }

        years.setSelectedIndex(3);

        frame.add(months); frame.add(days); frame.add(years);

    }


    private static void submitInfo(JFrame frame) {
        JButton submit = new JButton("Submit");
        submit.setBounds(250,400,100,25);

        submit.addActionListener(e ->
        {
            String name = getItemName(frame);
            String location = getCurrLoc(frame);
            int quantity = Integer.parseInt(getQuantity(frame));
            //String[] date = getDate(frame);
            //Item item = new Item(name, location, quantity, date);
        });
        frame.add(submit);
    }


}