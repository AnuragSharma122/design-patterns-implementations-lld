package org.example.behavioral.strategy.compression;

public class ZipCompression implements CompressionStrategy{
    @Override
    public long compress(long originalSize) {
        return (long) (0.6*originalSize);
    }

    @Override
    public String getName() {
        return "Zip Compression";
    }
}
