package org.example.structural.decorator;

import org.example.behavioral.strategy.backup.BackupStrategy;
import org.example.behavioral.strategy.compression.CompressionStrategy;
import org.example.structural.composite.FileSystemComponent;

public class EncryptedFolderDecorator extends FileSystemComponentDecorator{
    public EncryptedFolderDecorator(FileSystemComponent fileSystemComponent) {
        super(fileSystemComponent);
    }

    @Override
    public void backup() {
        System.out.println("🔒 Encrypting contents of " + fileSystemComponent.getName());
        fileSystemComponent.backup();
        System.out.println("🔓 Decrypting after backup: " + fileSystemComponent.getName());
    }

    @Override
    public void showDetails() {
        System.out.println("📁 (Encrypted Folder) " + fileSystemComponent.getName());
        fileSystemComponent.showDetails();
    }

    @Override
    public void setCompressionStrategy(CompressionStrategy strategy) {
        System.out.println("📁 (Encrypted Folder Compression)");
        fileSystemComponent.setCompressionStrategy(strategy);
    }
}
