package org.example.structural.composite;

import org.example.behavioral.strategy.CompressionStrategy;
import org.example.behavioral.strategy.NoCompression;

public class File implements FileSystemComponent{
    private String name;
    private long size;
    private Folder parent;
    private CompressionStrategy compressionStrategy = new NoCompression();

    public File(String name, long size){
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File: "+ this.name + " Compression: " +this.compressionStrategy.getName() + " ("+ this.size + " KB)");
    }

    @Override
    public long getSize() {
        return this.compressionStrategy.compress(this.size);
    }

    @Override
    public Folder getParent() {
        return parent;
    }

    @Override
    public void setParent(Folder parent) {
        this.parent = parent;
    }

    @Override
    public void setCompressionStrategy(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }
}
