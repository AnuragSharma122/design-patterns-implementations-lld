package org.example;

import org.example.behavioral.strategy.RarCompression;
import org.example.behavioral.strategy.ZipCompression;
import org.example.structural.composite.File;
import org.example.structural.composite.Folder;

public class Client {
    public static void main(String[] args) {
        File file1 = new File("resume.pdf", 100);
        File file2 = new File("photo.png", 200);
        File file3 = new File("song.mp3", 5000);

        Folder documents = new Folder("Documents");
        documents.add(file1);

        Folder pictures = new Folder("Pictures");
        pictures.add(file2);

        Folder music = new Folder("Music");
        music.add(file3);

        Folder root = new Folder("Root");
        root.add(documents);
        root.add(pictures);
        root.add(music);

        root.showDetails();
        System.out.println("Total size: " + root.getSize() + "KB");
        System.out.println("Parent of Pictures: " + pictures.getParent().getName());
        System.out.println("Parent of Music: " + music.getParent().getName());

        // Strategy pattern
        System.out.println("Documents folder size before compression: " + documents.getSize() + "KB");
        documents.setCompressionStrategy(new ZipCompression());
        System.out.println("Documents folder size after ZIP compression: " + documents.getSize() + "KB");
        documents.setCompressionStrategy(new RarCompression());
        System.out.println("Documents folder size after RAR compression: " + documents.getSize() + "KB");
    }
}
