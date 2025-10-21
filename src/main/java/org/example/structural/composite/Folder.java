package org.example.structural.composite;

import org.example.behavioral.strategy.backup.BackupStrategy;
import org.example.behavioral.strategy.backup.LocalBackup;
import org.example.behavioral.strategy.compression.CompressionStrategy;
import org.example.behavioral.strategy.compression.NoCompression;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();
    private Folder parent;
    private CompressionStrategy compressionStrategy = new NoCompression();
    private BackupStrategy backupStrategy = new LocalBackup();

    public Folder(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(FileSystemComponent component){
        children.add(component);
        component.setParent(this);
    }

    public void remove(FileSystemComponent component){
        if(children.remove(component)){
            component.setParent(null);
        }
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: "+ name);
        for(FileSystemComponent child: children){
            child.showDetails();
        }
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for(FileSystemComponent child : children){
            totalSize += child.getSize();
        }
        return this.compressionStrategy.compress(totalSize);
    }

    @Override
    public Folder getParent() {
        return parent;
    }

    @Override
    public void setParent(Folder parent) {
        this.parent = parent;
    }

    @Override
    public void setCompressionStrategy(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }

    @Override
    public void setBackupStrategy(BackupStrategy backupStrategy) {
        this.backupStrategy = backupStrategy;
    }

    @Override
    public void backup() {
        this.backupStrategy.backup(this);
    }
}
