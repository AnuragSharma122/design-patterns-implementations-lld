package org.example.creational.abstractFactory;

import org.example.behavioral.strategy.backup.BackupStrategy;
import org.example.behavioral.strategy.backup.NTFSBackup;
import org.example.structural.composite.File;
import org.example.structural.composite.FileSystemComponent;
import org.example.structural.composite.Folder;

public class LinxFileSystemFactory implements FileSystemFactory {
    @Override
    public File createFile(String filename, int size) {
        return new File(filename+".bin", size);
    }

    @Override
    public Folder createFolder(String name) {
        return new Folder("/home/"+name);
    }


    @Override
    public BackupStrategy createBackupStrategy() {
        return new NTFSBackup();
    }
}
