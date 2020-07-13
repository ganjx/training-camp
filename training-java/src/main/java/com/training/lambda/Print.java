package com.training.lambda;

@FunctionalInterface
interface Print<T> {
    public void print(T x);
}