package org.example.behavioral.strategy.backup;

import org.example.structural.composite.FileSystemComponent;

public class NTFSBackup implements BackupStrategy{
    @Override
    public String getName() {
        return "NTFS Backup";
    }

    @Override
    public void backup(FileSystemComponent component) {
        System.out.println("💾 Backing up " + component.getName() + " using NTFS backup strategy...");
    }
}
