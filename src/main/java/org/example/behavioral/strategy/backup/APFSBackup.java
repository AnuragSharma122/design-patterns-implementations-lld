package org.example.behavioral.strategy.backup;

import org.example.structural.composite.FileSystemComponent;

public class APFSBackup implements BackupStrategy{
    @Override
    public String getName() {
        return "APFS Time Machine Backup";
    }

    @Override
    public void backup(FileSystemComponent component) {
        System.out.println("💾 Backing up " + component.getName() + " using APFS Time Machine...");
    }
}
