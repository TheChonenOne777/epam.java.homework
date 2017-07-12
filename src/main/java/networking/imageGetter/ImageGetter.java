package networking.imageGetter;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageGetter {

    private Pattern imagePathPattern;
    private Matcher matcher;
    private String urlString;
    public Set<String> imagePaths;
    public StringBuilder urlContent;

    public ImageGetter(String urlString){
        this.urlString = urlString;
        imagePathPattern = Pattern.compile("<img.*?src=\"(([^\\/\"]+\\/)*[^\\/\".]+\\.\\w+)\"");
        urlContent = new StringBuilder();
        imagePaths = new HashSet<>();
    }

    public void downloadImages(String folderName){
        try {
            getImages();
            new File(folderName).mkdir();

            URLConnection imageUrlConnection;
            for(String imagePath : imagePaths){
                String imageName = getImageName(imagePath);
                imageUrlConnection = makeConnection(imagePath);
                try(InputStream inputStream = imageUrlConnection.getInputStream()){
                    Files.copy(inputStream, Paths.get(folderName + "/" + imageName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getImageName(String imagePath) {
        return imagePath.replaceAll("\\/", "_");
    }

    private URLConnection makeConnection(String imagePath) throws IOException {
        URL url = new URL("http://" + urlString + "/" + imagePath);
        return url.openConnection();
    }

    private void getImages() throws IOException {
        URL url = new URL("http://" + urlString);
        URLConnection connection = url.openConnection();
        readContentFromURLConnection(connection);
        grabImagePaths();
    }

    private void grabImagePaths() {
        matcher = imagePathPattern.matcher(urlContent);
        while(matcher.find()){
            imagePaths.add(matcher.group(1));
        }
    }

    private void readContentFromURLConnection(URLConnection connection) throws IOException {
        try(InputStream is = connection.getInputStream()){
            Scanner sc = new Scanner(is);
            while(sc.hasNext()){
                urlContent.append(sc.nextLine());
            }
        }
    }
}
