package org.example;

import javax.swing.*;

public class Main {

    private static JTextField nameField;
    private static JTextField currLocField;
    private static JTextField prevLocField;
    private static JTextField quantField;
    private static ItemManager item;

    public static void main(String[] args) {
        item = new ItemManager();
        setUpLanding();
    }

    /**
     * Sets up the landing page
     */
    private static void setUpLanding() {
        JFrame landingFrame = new JFrame("Home Page");
        landingFrame.setSize(500,500);
        landingFrame.setLayout(null);
        landingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        directToEntry(landingFrame);
        directToLookup(landingFrame);

        landingFrame.setVisible(true);
    }

    /**
     * Direct user to enter an item
     * @param frame -> The landing frame
     */
    private static void directToEntry(JFrame frame) {
        JButton dirEntry = new JButton("Add a new entry");
        dirEntry.setBounds(100,200,100, 30);

        dirEntry.addActionListener( e -> {
            entryPage();
        });

        frame.add(dirEntry);
    }

    /**
     * Directs user to the lookup frame
     * @param frame -> The landing frame
     */
    private static void directToLookup(JFrame frame) {
        JButton dirLookup = new JButton("Look up an item");
        dirLookup.setBounds(250,200,100,30);

        dirLookup.addActionListener(e -> {
            lookUp();
        });

        frame.add(dirLookup);
    }

    /**
     * Show the methods associated with entering info of an item
     */
    private static void entryPage() {
        JFrame entryFrame = new JFrame("Inventory Input");
        entryFrame.setSize(800, 800);
        entryFrame.setLayout(null);
        entryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setUpForEntry(entryFrame);
        createFieldsForEntry(entryFrame);
        submitButtonForEntry(entryFrame);
        clearButtonForEntry(entryFrame);
        closeEntry(entryFrame);

        entryFrame.setVisible(true);
    }

    /**
     * Sets up the labels for the entry of the items
     * @param frame -> The frame being used
     */
    private static void setUpForEntry(JFrame frame) {
        // Gets item name
        JLabel itemLabel = new JLabel("Enter item name:");
        itemLabel.setBounds(100, 100, 150, 25);
        frame.add(itemLabel);

        // Gets the address it is at
        JLabel currLabel = new JLabel("Enter current address:");
        currLabel.setBounds(100, 150, 150, 25);
        frame.add(currLabel);

        // Gets the address it came from
        JLabel dateLabel = new JLabel("Enter previous address:");
        dateLabel.setBounds(100, 200, 150, 25);
        frame.add(dateLabel);

        // Gets the quantity
        JLabel quantLabel = new JLabel("Enter quantity:");
        quantLabel.setBounds(100, 250, 150, 25);
        frame.add(quantLabel);
    }

    /**
     * Creates the fields for entering the info of the item
     * @param frame -> The frame being used
     */
    private static void createFieldsForEntry(JFrame frame) {
        // Creates field for entering item name
        nameField = new JTextField();
        nameField.setBounds(250, 100, 150, 25);
        frame.add(nameField);

        // Creates a field for entering the current address
        currLocField = new JTextField();
        currLocField.setBounds(250, 150, 150, 25);
        frame.add(currLocField);

        // Creates a field for entering where it came from
        prevLocField = new JTextField();
        prevLocField.setBounds(250,200,150,25);
        frame.add(prevLocField);

        // Creates a field for entering the quantity
        quantField = new JTextField();
        quantField.setBounds(250, 250, 150, 25);
        frame.add(quantField);
    }

    /**
     * Creates the button that submits info of item
     * @param frame -> The frame being used
     */
    private static void submitButtonForEntry(JFrame frame) {
        JButton submit = new JButton("Submit");
        submit.setBounds(150, 300, 100, 30);

        JLabel confirm = new JLabel();
        confirm.setBounds(150,300,150,100);

        submit.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String currLocation = currLocField.getText();
                String prevLocation = prevLocField.getText().isBlank() ? " " : prevLocField.getText();
                int quantity = Integer.parseInt(quantField.getText());

                item.addItem(name, currLocation, prevLocation, quantity);

                confirm.setText("<html>Item added: " + name + "<br>Quantity: " + quantity + "</html>");
                frame.revalidate();
                frame.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid quantity.");
            }
        });
        frame.add(confirm);
        frame.add(submit);
    }

    /**
     * Method to close the entry page
     *
     * @param frame -> The frame being worked in
     */
    private static void closeEntry(JFrame frame) {
        JButton close = new JButton("close");
        close.setBounds(350,300,100,30);

        close.addActionListener(e -> {
            frame.setVisible(false);
        });
        frame.add(close);
    }

    /**
     * Clears all the info in the text fields
     * @param frame -> The frame being used
     */
    private static void clearButtonForEntry(JFrame frame) {
        JButton clear = new JButton("Clear");
        clear.setBounds(250,300,100,30);

        clear.addActionListener(e -> {
            nameField.setText("");
            currLocField.setText("");
            quantField.setText("");
        });

        frame.add(clear);
    }

    /**
     * Creates a new frame to look up an item
     */
    private static void lookUp() {
        JFrame lookup = new JFrame("Look Up");
        lookup.setSize(800,800);
        lookup.setLayout(null);
        lookup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchBar(lookup);

        lookup.setVisible(true);
    }

    /**
     * Adds a search bar to the frame for lookup
     * @param frame -> The lookup frame
     */
    private static void searchBar(JFrame frame) {
        JLabel searchLabel = new JLabel("Enter item name: ");
        searchLabel.setBounds(150,150,100,30);

        JTextField search = new JTextField();
        search.setBounds(250,150,200,30);

        submitSearch(frame, search);
        closeSearch(frame);

        frame.add(searchLabel);
        frame.add(search);
    }

    /**
     * Method that creates the button for submitting the search
     *
     * @param frame -> The frame being worked in
     * @param search -> The search bar of the text being passed in
     */
    private static void submitSearch(JFrame frame, JTextField search) {
        JButton submitSearch = new JButton("submit");
        submitSearch.setBounds(200,200, 100, 30);

        submitSearch.addActionListener(e -> {
            String find = search.getText();
            if (item.contains(find)) {
                showMatches(frame);
            } else {
                JOptionPane.showMessageDialog(frame, "Item does not exist");
            }
        });

        frame.add(submitSearch);
    }

    /**
     * Method that makes a button for closing the search frame
     *
     * @param frame -> The frame being worked in
     */
    private static void closeSearch(JFrame frame) {
        JButton closeSearch = new JButton("Close");
        closeSearch.setBounds(350,200, 100,30);

        closeSearch.addActionListener(e -> {
            frame.setVisible(false);
        });

        frame.add(closeSearch);
    }

    private static void showMatches(JFrame frame) {
        JLabel quantity = new JLabel("Quantity");
        quantity.setBounds(200,250,100,30);

        JLabel address = new JLabel("Address");
        address.setBounds(300,250,100,30);

        JLabel disp = new JLabel();
        disp.setBounds(200,250,300,100);
        disp.setText(item.toString());

        frame.add(quantity);
        frame.add(address);
        frame.add(disp);
        frame.revalidate();
        frame.repaint();
    }

}