package org.example.behavioral.strategy.backup;

import org.example.structural.composite.FileSystemComponent;

public class Ext4Backup implements BackupStrategy{
    @Override
    public String getName() {
        return "EXT4 Rsync Backup";
    }

    @Override
    public void backup(FileSystemComponent component) {
        System.out.println("💾 Backing up " + component.getName() + " using Rsync...");
    }
}
