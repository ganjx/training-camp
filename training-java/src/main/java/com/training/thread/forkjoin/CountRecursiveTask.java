package com.training.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * fork join
 */
public class CountRecursiveTask extends RecursiveTask<Integer> {
    //达到子任务直接计算的阈值
    private int Th = 15;

    private int start;
    private int end;

    public CountRecursiveTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (this.end - this.start < Th) {
            //如果小于阈值，直接调用最小任务的计算方法
            return count();
        } else {
            //fork 2 tasks:Th = 15
            //如果仍大于阈值，则继续拆分为2个子任务，分别调用fork方法。
            //这里可以根据情况拆成n个子任务
            int middle = (end + start) / 2;
            CountRecursiveTask left = new CountRecursiveTask(start, middle);
            System.out.println("start:" + start + ";middle:" + middle + ";end:" + end);
            left.fork();
            CountRecursiveTask right = new CountRecursiveTask(middle + 1, end);
            right.fork();
            //最后一定要记得fork()结果(如果需要结果的话)
            return left.join() + right.join();
        }
    }

    private int count() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        Integer sum = forkJoinPool.invoke(new CountRecursiveTask(1, 100));
        System.out.println(sum);
    }

}
