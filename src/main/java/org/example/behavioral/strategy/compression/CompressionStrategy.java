package org.example.behavioral.strategy.compression;

public interface CompressionStrategy {
    long compress(long originalSize);
    String getName();
}
