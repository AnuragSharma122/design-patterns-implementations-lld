package org.example.behavioral.strategy.backup;

import org.example.structural.composite.FileSystemComponent;

public interface BackupStrategy {
    String getName();
    void backup(FileSystemComponent component);
}
