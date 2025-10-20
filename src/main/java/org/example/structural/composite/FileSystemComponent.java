package org.example.structural.composite;

import org.example.behavioral.strategy.CompressionStrategy;

public interface FileSystemComponent {
    void showDetails();
    long getSize();
    Folder getParent();
    void setParent(Folder parent);
    void setCompressionStrategy(CompressionStrategy strategy);
}
