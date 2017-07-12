package networking.imageGetter;

public class ImageGetterMain {

    public static void main(String[] args) {
        ImageGetter imageGetter = new ImageGetter("horstmann.com");
        imageGetter.downloadImages("images");
    }

}
