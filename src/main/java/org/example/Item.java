package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private String name;
    private String currLoc;
    private String[] allLocs;
    private int quantity;
    private String[] dateRec;
    private DateTimeFormatter formatter;

    /**
     * Construct the object with the object name, current location, where it was before, quantity
     * and the date it was received
     *
     * @param name -> Item name
     * @param currLoc -> Where it is currently
     * @param quantity -> How many of the item there are
     * @param dateRec -> The date it was received
     */
    public Item(String name, String currLoc, int quantity, String[] dateRec) {
        this.name = name;
        this.currLoc = currLoc;
        this.quantity = quantity;
        this.dateRec = dateRec;
        allLocs = new String[10];
    }

    private String getName() {
        return name;
    }

    private String getCurrLoc() {
        return currLoc;
    }

    private int getQuantity() {
        return quantity;
    }

    private String[] getAllLocs() {
        return allLocs;
    }

    public void addLocation(String currLoc, String[] allLocs) {
        for (int i = allLocs.length - 1; i > 0; i--) {
            allLocs[i] = allLocs[i - 1];
        }
        allLocs[0] = currLoc;
    }

}
