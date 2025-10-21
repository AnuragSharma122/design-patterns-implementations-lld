package org.example;

import org.example.behavioral.strategy.backup.CloudBackup;
import org.example.behavioral.strategy.backup.LocalBackup;
import org.example.behavioral.strategy.compression.NoCompression;
import org.example.behavioral.strategy.compression.RarCompression;
import org.example.behavioral.strategy.compression.ZipCompression;
import org.example.creational.abstractFactory.*;
import org.example.structural.composite.File;
import org.example.structural.composite.FileSystemComponent;
import org.example.structural.composite.Folder;
import org.example.structural.decorator.EncryptedFolderDecorator;

public class Client {
    public static void main(String[] args) {

        System.out.println("***********************Abstract*Factory*****************************");
        //Abstract factory pattern
        FileSystemFactory fileSystemFactory = FileSystemFactoryProvider.getFileSystemFactory();
        System.out.println("***********************Composition***********************************");
        // Composition pattern
        File file1 = fileSystemFactory.createFile("resume.pdf", 100);
        File file2 = fileSystemFactory.createFile("photo.png", 200);
        File file3 = fileSystemFactory.createFile("song.mp3", 5000);

        Folder pictures = fileSystemFactory.createFolder("Pictures");
        pictures.add(file2);

        Folder music = fileSystemFactory.createFolder("Music");
        music.add(file3);

        Folder root = fileSystemFactory.createFolder("Root");
        root.add(pictures);
        root.add(music);

        root.showDetails();
        System.out.println("Total size: " + root.getSize() + "KB");
        System.out.println("Parent of Pictures: " + pictures.getParent().getName());
        System.out.println("Parent of Music: " + music.getParent().getName());

        System.out.println("***********************STRATEGY*****************************");
        // Strategy pattern
        System.out.println("Documents folder size before compression: " + pictures.getSize() + "KB");
        pictures.setCompressionStrategy(new ZipCompression());
        System.out.println("Documents folder size after ZIP compression: " + pictures.getSize() + "KB");
        pictures.setCompressionStrategy(new RarCompression());
        System.out.println("Documents folder size after RAR compression: " + pictures.getSize() + "KB");

        // Strategy pattern
        pictures.setBackupStrategy(new LocalBackup());
        pictures.backup();
        pictures.setBackupStrategy(new CloudBackup());
        pictures.backup();

        System.out.println("***********************DECORATOR*****************************");

        // Decorator pattern
        Folder documents = fileSystemFactory.createFolder("Documents");
        documents.add(file1);
        FileSystemComponent encryptedDocumentsFolder = new EncryptedFolderDecorator(documents);
        encryptedDocumentsFolder.showDetails();
        encryptedDocumentsFolder.backup();
        System.out.println("Encrypted documents folder size before RAR compression: " + encryptedDocumentsFolder.getSize() + "KB");
        encryptedDocumentsFolder.setCompressionStrategy(new NoCompression());
        System.out.println("Encrypted documents folder size after No compression: " + encryptedDocumentsFolder.getSize() + "KB");

    }
}
