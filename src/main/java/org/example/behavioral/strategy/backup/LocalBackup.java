package org.example.behavioral.strategy.backup;

import org.example.structural.composite.FileSystemComponent;

public class LocalBackup implements BackupStrategy{
    @Override
    public String getName() {
        return "Local Backup";
    }

    @Override
    public void backup(FileSystemComponent component) {
        System.out.println("💾 Backing up " + component.getName() + " to local disk...");
    }
}
