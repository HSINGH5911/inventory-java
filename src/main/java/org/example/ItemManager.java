package org.example;

import java.util.*;

public class ItemManager {
    private Map<String, Item> inventory;

    /**
     * Constructor for creating a new map
     */
    public ItemManager() {
        inventory = new HashMap<>();
    }

    /**
     * Adds an item object to the map and the name of the item
     *
     * @param name -> name of the object
     * @param currLocation -> where it is right now
     * @param prevLocation -> where it came from
     * @param quantity -> how much is at location
     */
    public void addItem(String name, String currLocation, String prevLocation, int quantity) {
        Item item = inventory.getOrDefault(name, new Item(name));

        if (prevLocation != null && !prevLocation.equals(currLocation)) {
            item.removeLocation(prevLocation); // remove old location
        }

        item.addItem(currLocation, quantity); // add/update new location
        inventory.put(name, item);
    }

    /**
     * Gets the location and quant. of specified location
     *
     * @param name -> Name of item
     * @return -> locs. + quants.
     */
    public Item getItem(String name) {
        return inventory.get(name);
    }

    /**
     * Checks if the inventory has this item
     */
    public boolean contains(String name) {
        return inventory.containsKey(name);
    }

    /**
     * Print out the items
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Item item : inventory.values()) {
            sb.append(item);
            sb.append("\n");
        }

        return sb.toString();
    }
}
