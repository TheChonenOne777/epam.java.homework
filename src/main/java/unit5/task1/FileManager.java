package unit5.task1;


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

    public List<String> getFolderNames(){
        List<String> list = new ArrayList<>();
        for(File f : pathToFile.listFiles()){
            if(f.isDirectory()) list.add(f.getName());
        }
        return list;
    }

    public List<String> getFileNames(){
        List<String> list = new ArrayList<>();
        for(File f : pathToFile.listFiles()){
            if(f.isFile()) list.add(f.getName());
        }
        return list;
    }

    public String[] getAllFileNames(){
        return pathToFile.list();
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
            throw new IllegalArgumentException();
        }
    }

    public void writeToFile(String content) throws IOException {
        if(file.canWrite()) {
            try (BufferedWriter bw = Files.newBufferedWriter(file.toPath())) {
                bw.write(content);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void createFile(String fileName) throws IOException {
        new File(fileName).createNewFile();
    }

    public void createFolder(String folderName){
        new File(folderName).mkdir();
    }

    public boolean delete(String item){
        return new File(item).delete();
    }

}
