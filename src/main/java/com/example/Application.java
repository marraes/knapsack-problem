package com.example;

import java.util.List;
import java.util.Map;

import com.example.dto.Item;
import com.example.dto.Knapsack;
import com.example.executor.DynamicProgrammingMethodExecutor;
import com.example.executor.Executor;
import com.example.executor.ExecutorType;
import com.example.executor.MemoizationMethodExecutor;
import com.example.executor.RecursiveMethodExecutor;

public class Application {

    private static final Map<ExecutorType, Executor> EXECUTOR_MAP = Map.of(
            ExecutorType.RECURSIVE, new RecursiveMethodExecutor(),
            ExecutorType.MEMOIZATION, new MemoizationMethodExecutor(),
            ExecutorType.DYNAMIC_PROGRAMMING, new DynamicProgrammingMethodExecutor()
    );

    public static void main(String[] args) {
        final List<Item> items = List.of(
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        );
        final Knapsack knapsack = new Knapsack(50, items);
        final Executor executor = EXECUTOR_MAP.get(ExecutorType.DYNAMIC_PROGRAMMING);
        final int result = executor.execute(knapsack, knapsack.itemsSize());

        System.out.printf("Max total value: %d", result);
    }

}
