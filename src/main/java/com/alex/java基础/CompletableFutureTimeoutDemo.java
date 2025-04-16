package com.alex.java基础;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 描述
 *
 * @auth shufei
 * @date 2025/4/15
 */
public class CompletableFutureTimeoutDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture<String> taskA = CompletableFuture.supplyAsync(() -> {
            sleep(1500); // 模拟任务耗时
            return "Result A";
        }, executor);

        CompletableFuture<String> taskB = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Result B";
        }, executor);

        CompletableFuture<String> taskC = CompletableFuture.supplyAsync(() -> {
            sleep(500);
            return "Result C";
        }, executor);

        List<CompletableFuture<String>> tasks = new ArrayList<>(Arrays.asList(taskA, taskB, taskC));


        // 获取每个结果
        for (CompletableFuture<String> future : tasks) {
            try {
                System.out.println("结果: " + future.get(1, TimeUnit.SECONDS));
            } catch (Exception e) {
                System.out.println("任务异常: " + e.getMessage());
            }
        }

        executor.shutdown();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

    private static String timeout() {
        return "Alex";
    }
}
