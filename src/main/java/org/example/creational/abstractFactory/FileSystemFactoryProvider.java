package org.example.creational.abstractFactory;

public class FileSystemFactoryProvider {
    public static FileSystemFactory getFileSystemFactory(){
        //Choose factory based on os.
        String os = System.getProperty("os.name").toLowerCase();
        FileSystemFactory fileSystemFactory;
        if(os.contains("mac")){
            System.out.println("Detected macOS environment 🧑‍💻");
            fileSystemFactory = new MacFileSystemFactory();
        }else if(os.contains("linux")){
            System.out.println("Detected Linux environment 🐧");
            fileSystemFactory = new LinxFileSystemFactory();
        }else if (os.contains("win")) {
            System.out.println("Detected Windows environment 🪟");
            fileSystemFactory = new WindowsFileSystemFactory();
        }else{
            //default
            System.out.println("⚠️ Unknown OS: " + os + " — defaulting to Linux factory");
            fileSystemFactory = new LinxFileSystemFactory();
        }
        return fileSystemFactory;
    }
}
