package unit2.task3;


import java.util.List;
import java.util.Objects;

public class Folder extends File {

    private List<File> containingFiles;

    public Folder(){
        name = "folder for files";
        price = 20;
        color = "yellow";
    }

    public Folder(String name, int price, String color, List<Paper> containingPapers, String format, List<File> containingFiles) {
        super(name, price, color, containingPapers, format);
        this.containingFiles = containingFiles;
    }

    public List<File> getContainingFiles() {
        return containingFiles;
    }

    public void setContainingFiles(List<File> containingFiles) {
        this.containingFiles = containingFiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Folder folder = (Folder) o;
        return Objects.equals(containingFiles, folder.containingFiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), containingFiles);
    }

    @Override
    public String toString() {
        return "Folder{" +
                "containingFiles=" + containingFiles +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
