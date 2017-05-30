package unit5;


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    File pathToFile;
    File file;

    public FileManager(){
        pathToFile = new File(System.getProperty("user.dir"));
    }

    public File getPathToFile() {
        return pathToFile;
    }

    public File getFile() {
        return file;
    }

    public void showDirectories(){
        if(pathToFile.isDirectory()) {
            for (File f : pathToFile.listFiles()) {
                System.out.println(f.getName());
            }
        }
    }

    public void showFiles(){
        if(pathToFile.isFile()) {
            for (File f : pathToFile.listFiles()) {
                System.out.println(f.getName());
            }
        }
    }

    public void showAll(){
        for (File f : pathToFile.listFiles()) {
            System.out.println(f.getName());
        }
    }

    public String[] getFolderNames(){
        String[] list = {};
        if(pathToFile.isDirectory()) list = pathToFile.list();
        return list;
    }

    public String[] getFileNames(){
        String[] list = {};
        if(pathToFile.isFile()) list = pathToFile.list();
        return list;
    }

    public boolean moveBack(){
        if(pathToFile.getParentFile() == null){
            return false;
        } else {
            pathToFile = new File(pathToFile.getParentFile().getPath());        //I might make it oneliner one day :)
            return true;
        }
    }

    public boolean moveToDirectory(String directory){
        File checkFile = new File("");
        if(directory.indexOf(':') == 1){
            checkFile = new File(directory);
        } else if(directory.indexOf('/') != 0){
            directory = '/' + directory;
            checkFile = new File(pathToFile.getPath() + directory);
        }
        if(checkFile.exists() && checkFile.isDirectory()){
            pathToFile = checkFile;           //ugly, but works
            return true;
        } else {
            return false;
        }
    }

    public boolean checkFile(String fileName){
        file = new File(fileName);
        return file.exists() && file.isFile();
    }

    public List<String> getFileContent() throws IOException {
        if(file.canRead()) {
            return Files.readAllLines(file.toPath());
        } else {
            return new ArrayList<>();
        }
    }

    public void writeToFile(String content) throws IOException {
        if(file.canWrite()) {
            try (BufferedWriter bw = Files.newBufferedWriter(file.toPath())) {
                bw.write(content);
            }
        }
    }

    public boolean delete(String item){
        return new File(item).delete();
    }

}
