package com.example.executor;

import com.example.dto.Item;
import com.example.dto.Knapsack;

public class DynamicProgrammingMethodExecutor implements Executor {

    @Override
    public boolean supports(final ExecutorType type) {
        return type == ExecutorType.DYNAMIC_PROGRAMMING;
    }

    @Override
    public int execute(final Knapsack knapsack, final int n) {
        System.out.println("Dynamic Programming");

        final int[] dp = new int[knapsack.capacity() + 1];

        for (int currentIterationIndex = 0; currentIterationIndex < n; currentIterationIndex++) {
            final Item currentItem = knapsack.item(currentIterationIndex);
            for (int currentIterationWeight = knapsack.capacity(); currentIterationWeight >= 0; currentIterationWeight--) {
                if (currentItem.weight() <= currentIterationWeight) {
                    dp[currentIterationWeight] = Math.max(
                            dp[currentIterationWeight],
                            dp[currentIterationWeight - currentItem.weight()] + currentItem.value()
                    );
                }
            }
        }

        return dp[knapsack.capacity()];
    }

}
