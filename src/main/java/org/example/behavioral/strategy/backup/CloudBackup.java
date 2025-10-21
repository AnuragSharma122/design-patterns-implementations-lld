package org.example.behavioral.strategy.backup;

import org.example.structural.composite.FileSystemComponent;

public class CloudBackup implements BackupStrategy{
    @Override
    public String getName() {
        return "Cloud Backup";
    }

    @Override
    public void backup(FileSystemComponent component) {
        System.out.println("💾 Backing up " + component.getName() + " to cloud...");
    }
}
