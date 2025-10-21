package org.example.creational.abstractFactory;

import org.example.behavioral.strategy.backup.BackupStrategy;
import org.example.structural.composite.File;
import org.example.structural.composite.FileSystemComponent;
import org.example.structural.composite.Folder;

public interface FileSystemFactory {
    File createFile(String file, int size);
    Folder createFolder(String name);
    BackupStrategy createBackupStrategy();
}
