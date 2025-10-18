package org.example.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void add(FileSystemComponent component){
        children.add(component);
    }

    public void remove(FileSystemComponent component){
        children.remove(component);
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
        return totalSize;
    }
}
