package org.example.structural.composite;

public class File implements FileSystemComponent{
    private String name;
    private long size;
    private Folder parent;

    public File(String name, long size){
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File: "+ this.name + " ("+ this.size + " KB)");
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public Folder getParent() {
        return parent;
    }

    @Override
    public void setParent(Folder parent) {
        this.parent = parent;
    }
}
