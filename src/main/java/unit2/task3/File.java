package unit2.task3;


import java.util.List;
import java.util.Objects;

public class File extends Stationary implements storable {

    private List<Paper> containingPapers;
    protected String format;

    public File(){
        name = "file";
        price = 3;
        color = "transparent";
        format = "a4";
    }

    public File(String name, int price, String color, List<Paper> containingPapers, String format) {
        super(name, price, color);
        this.containingPapers = containingPapers;
        this.format = format;
    }

    public void toStore(Object object) {
        containingPapers.add((Paper)object);
    }

    public List<Paper> getContainingPapers() {
        return containingPapers;
    }

    public void setContainingPapers(List<Paper> containingPapers) {
        this.containingPapers = containingPapers;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "File{" +
                "containingPapers=" + containingPapers +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        File file = (File) o;
        return Objects.equals(containingPapers, file.containingPapers) &&
                Objects.equals(format, file.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), containingPapers, format);
    }
}
