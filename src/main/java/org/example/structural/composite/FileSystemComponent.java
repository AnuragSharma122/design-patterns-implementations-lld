package org.example.structural.composite;

import org.example.behavioral.strategy.backup.BackupStrategy;
import org.example.behavioral.strategy.compression.CompressionStrategy;

public interface FileSystemComponent {
    void showDetails();
    long getSize();
    Folder getParent();
    void setParent(Folder parent);
    void setCompressionStrategy(CompressionStrategy strategy);
    void setBackupStrategy(BackupStrategy strategy);
    void backup();
    String getName();
}
