package org.example.behavioral.strategy;

public interface CompressionStrategy {
    long compress(long originalSize);
    String getName();
}
