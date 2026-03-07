package org.example;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private String address;
    private Map<String, Integer> quantityPerLoc;

    /**
     * Construct the object with the object address
     * and the date it was received
     *
     * @param name -> Item address
     */
    public Item(String name) {
        this.address = name;
        this.quantityPerLoc = new HashMap<>();
    }

    /**
     * Adds the adress and the amount present
     *
     * @param address -> The address of the user
     * @param amount -> The amount of the item present
     */
    public void addItem(String address, int amount) {
        quantityPerLoc.put(address, quantityPerLoc.getOrDefault(address, 0) + amount);
    }

    /**
     * Gets the quantity of the item present at the address given
     *
     * @param address -> The address the user wants to know
     * @return -> number of item present at that location
     */
    public int getQuantity(String address) {
        return quantityPerLoc.getOrDefault(address, 0);
    }

    /**
     * Get the address
     * @return -> address
     */
    public String getAddress() {
        return address;
    }

   public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String s : quantityPerLoc.keySet()) {
            sb.append(s + " ");
            sb.append(quantityPerLoc.get(s));
        }

        return sb.toString();
   }
}
