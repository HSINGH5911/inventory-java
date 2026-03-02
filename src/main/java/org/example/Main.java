package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800,800);
        frame.setLayout(null);

        setUp(frame);
        getItemName(frame);
        getCurrLoc(frame);
        getQuantity(frame);

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
    private static int getQuantity(JFrame frame) {
        JTextField quantField = new JTextField();
        quantField.setBounds(250, 200, 150, 25);
        String quant = quantField.getText();
        frame.add(quantField);

        return Integer.parseInt(quant);
    }
}