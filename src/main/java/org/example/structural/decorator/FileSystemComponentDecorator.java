package org.example.structural.decorator;

import org.example.behavioral.strategy.backup.BackupStrategy;
import org.example.behavioral.strategy.compression.CompressionStrategy;
import org.example.structural.composite.FileSystemComponent;
import org.example.structural.composite.Folder;

public abstract class FileSystemComponentDecorator implements FileSystemComponent {

    protected FileSystemComponent fileSystemComponent;

    public FileSystemComponentDecorator(FileSystemComponent fileSystemComponent) {
        this.fileSystemComponent = fileSystemComponent;
    }

    @Override
    public void showDetails() {
        this.fileSystemComponent.showDetails();
    }

    @Override
    public long getSize() {
        return this.fileSystemComponent.getSize();
    }

    @Override
    public Folder getParent() {
        return this.fileSystemComponent.getParent();
    }

    @Override
    public void setParent(Folder parent) {
        this.fileSystemComponent.setParent(parent);
    }

    @Override
    public void setCompressionStrategy(CompressionStrategy strategy) {
        this.fileSystemComponent.setCompressionStrategy(strategy);
    }

    @Override
    public void setBackupStrategy(BackupStrategy strategy) {
        this.fileSystemComponent.setBackupStrategy(strategy);
    }

    @Override
    public void backup() {
        this.fileSystemComponent.backup();
    }

    @Override
    public String getName() {
        return fileSystemComponent.getName();
    }
}
