package com.example.executor;

import com.example.dto.Knapsack;

public interface Executor {

    boolean supports(final ExecutorType type);

    int execute(final Knapsack knapsack, final int n);

}
