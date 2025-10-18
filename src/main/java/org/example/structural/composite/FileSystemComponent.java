package org.example.structural.composite;

public interface FileSystemComponent {
    void showDetails();
    long getSize();
    Folder getParent();
    void setParent(Folder parent);
}
