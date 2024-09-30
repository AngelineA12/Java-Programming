package com.prediction.util;

@FunctionalInterface
public interface CSVMapper<T> {
    T map(String[] data);
}
