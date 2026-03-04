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
        selectDate(entryFrame);
        submitButtonForEntry(entryFrame);
        clearButtonForEntry(entryFrame);

        entryFrame.setVisible(true);
    }

    /**
     * Sets up the labels for the entry of the items
     * @param frame -> The frame being used
     */
    private static void setUpForEntry(JFrame frame) {

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

    /**
     * Creates the fields for entering the info of the item
     * @param frame -> The frame being used
     */
    private static void createFieldsForEntry(JFrame frame) {

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

    /**
     * Selects the date of the entry of the item
     * @param frame -> The frame being used
     */
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

    /**
     * Creates the button that submits info of item
     * @param frame -> The frame being used
     */
    private static void submitButtonForEntry(JFrame frame) {

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

    /**
     * Clears all the info in the text fields
     * @param frame -> The frame being used
     */
    private static void clearButtonForEntry(JFrame frame) {
        JButton clear = new JButton("Clear");
        clear.setBounds(300,300,100,30);

        clear.addActionListener(e -> {
            nameField.setText("");
            locField.setText("");
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

        JButton submitSearch = new JButton("submit");
        submitSearch.setBounds(200,200, 100, 30);

        submitSearch.addActionListener(e -> {
            System.out.println();
        });

        frame.add(searchLabel);
        frame.add(search);
        frame.add(submitSearch);
    }

}