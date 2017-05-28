package unit5;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileManager {

    File file;

    public FileManager(){
        file = new File(System.getProperty("user.dir"));
    }

    public File getFile() {
        return file;
    }

    public void showDirectories(){
        if(file.isDirectory()) {
            for (File f : file.listFiles()) {
                System.out.println(f.getName());
            }
        }
    }

    public void showFiles(){
        if(file.isFile()) {
            for (File f : file.listFiles()) {
                System.out.println(f.getName());
            }
        }
    }

    public void showAll(){
        for (File f : file.listFiles()) {
            System.out.println(f.getName());
        }
    }

    public String[] getAllFileNamesInCurrentDirectory(){
        String[] list = {};
        if(file.isDirectory()) list = file.list();
        return list;
    }

    public boolean moveBack(){
        if(file.getParentFile() == null){
            return false;
        } else {
            file = new File(file.getParentFile().getPath());        //I might make it oneliner one day :)
            return true;
        }
    }

    public boolean moveToDirectory(String directory){
        File checkFile = new File("");
        if(directory.indexOf(':') == 1){
            checkFile = new File(directory);
        } else if(directory.indexOf('/') != 0){
            directory = '/' + directory;
            checkFile = new File(file.getPath() + directory);
        }
        if(checkFile.exists() && checkFile.isDirectory()){
            file = checkFile;           //ugly, but works
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {

        FileManager fm = new FileManager();

        for(String s : fm.getAllFileNamesInCurrentDirectory()){
            System.out.println(s);
        }

        System.out.println(fm.getFile().getAbsolutePath());

        System.out.println(fm.moveToDirectory("pom.xml"));

        System.out.println(fm.getFile().getAbsolutePath());

        System.out.println(fm.moveToDirectory("c:/program files"));

        System.out.println(fm.getFile().getAbsolutePath());

        fm.showAll();


//        File file = new File("c:/users");
//        System.out.println(file.exists());
//        for(File f : file.listFiles()){
//            System.out.println(f.getName());
//        }
//
//        file = new File(file.getParentFile().getPath());
//        System.out.println(file.exists());
//        for(File f : file.listFiles()){
//            System.out.println(f);
//        }
//
//        file = new File(file.getPath() + "/chertvl/Documents/GitHub/epam.java.homework/pom.xml");
//        System.out.println(file.isDirectory());
//        System.out.println(file.exists());
//        System.out.println(file.isFile());
//        System.out.println(file.getPath());
//        System.out.println(file.list());
//        file.mkdir();
//        System.out.println(file.exists());

    }

}
