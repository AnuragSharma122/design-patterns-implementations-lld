package org.example.behavioral.strategy.compression;

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
