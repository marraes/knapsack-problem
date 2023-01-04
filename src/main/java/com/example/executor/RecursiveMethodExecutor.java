package com.example.executor;

import com.example.dto.Item;
import com.example.dto.Knapsack;

public class RecursiveMethodExecutor implements Executor {
    @Override
    public boolean supports(final ExecutorType type) {
        return type == ExecutorType.RECURSIVE;
    }

    @Override
    public int execute(final Knapsack knapsack, final int n) {

        if (n == 0 || knapsack.capacity() == 0) {
            return 0;
        }

        final int currentIndex = n - 1;
        final Item currentItem = knapsack.item(currentIndex);

        if (currentItem.weight() > knapsack.capacity()) {
            return execute(knapsack, currentIndex);
        }

        return Math.max(
                currentItem.value() + execute(new Knapsack(knapsack.capacity() - currentItem.weight(), knapsack.items()), currentIndex),
                execute(knapsack, currentIndex)
        );

    }
}
