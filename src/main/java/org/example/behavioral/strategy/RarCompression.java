package org.example.behavioral.strategy;

public class RarCompression implements CompressionStrategy{
    @Override
    public long compress(long originalSize) {
        return (long) (0.5*originalSize);
    }

    @Override
    public String getName() {
        return "Rar Compression";
    }
}
