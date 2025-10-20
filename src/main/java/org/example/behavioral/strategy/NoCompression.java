package org.example.behavioral.strategy;

public class NoCompression implements CompressionStrategy{
    @Override
    public long compress(long originalSize) {
        return originalSize;
    }

    @Override
    public String getName() {
        return "No Compression";
    }
}
