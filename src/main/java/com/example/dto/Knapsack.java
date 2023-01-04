package com.example.dto;

import java.util.List;

public record Knapsack(
        int capacity,
        List<Item> items
) {

    public int itemsSize() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public Item item(final int index) {
        return items.get(index);
    }

}
