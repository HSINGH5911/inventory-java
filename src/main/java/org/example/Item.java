package org.example;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private String name;
    private Map<String, Integer> quantityPerLoc;

    /**
     * Construct the object with the object name, current location, where it was before, quantity
     * and the date it was received
     *
     * @param name -> Item name
     */
    public Item(String name) {
        this.name = name;
        this.quantityPerLoc = new HashMap<>();
    }

    public void addItem(String item, String address, int amount) {
        quantityPerLoc.put(address, quantityPerLoc.getOrDefault(address, 0) + amount);
    }

    public int getQuantity(String address) {
        return quantityPerLoc.getOrDefault(address, 0);
    }

    public String getName() {
        return name;
    }

}
