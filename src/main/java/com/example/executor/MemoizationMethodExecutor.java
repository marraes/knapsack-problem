package com.example.executor;

import com.example.dto.Item;
import com.example.dto.Knapsack;

public class MemoizationMethodExecutor implements Executor {
    @Override
    public boolean supports(final ExecutorType type) {
        return type == ExecutorType.MEMOIZATION;
    }

    @Override
    public int execute(final Knapsack knapsack, final int n) {
        final int[][] memoize = new int[knapsack.itemsSize() + 1][knapsack.capacity() + 1];

        for (int i = 0; i < knapsack.itemsSize() + 1; i++) {
            for (int j = 0; j < knapsack.capacity() + 1; j++) {
                memoize[i][j] = -1;
            }
        }

        return executeRecursive(knapsack, knapsack.itemsSize(), memoize);
    }

    private int executeRecursive(final Knapsack knapsack, final int n, final int[][] memoize) {
        if (n == 0 || knapsack.capacity() == 0) {
            return 0;
        }

        if (memoize[n][knapsack.capacity()] != -1) {
            return memoize[n][knapsack.capacity()];
        }

        final int currentIndex = n - 1;
        final Item currentItem = knapsack.item(currentIndex);

        if (currentItem.weight() > knapsack.capacity()) {
            return memoize[n][knapsack.capacity()] = executeRecursive(knapsack, currentIndex, memoize);
        }

        return memoize[n][knapsack.capacity()] = Math.max(
                currentItem.value() + executeRecursive(new Knapsack(knapsack.capacity() - currentItem.weight(), knapsack.items()), currentIndex, memoize),
                executeRecursive(knapsack, currentIndex, memoize)
        );

    }

}
