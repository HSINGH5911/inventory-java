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
     * @param location -> where it is
     * @param quantity -> how much is at location
     */
    public void addItem(String name, String location, int quantity) {
        Item item = inventory.getOrDefault(name, new Item(name));
        item.addItem(location, quantity);
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

    public boolean contains(String name) {
        return inventory.containsKey(name);
    }

}
