package unit2.task5;


import java.util.Objects;

public class Mark<T extends Number> {

    private T mark;

    public Mark() {}

    public Mark(T mark) {
        this.mark = mark;
    }

    public T getMark() {
        return mark;
    }

    public void setMark(T mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return mark.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark<?> mark1 = (Mark<?>) o;
        return Objects.equals(mark, mark1.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark);
    }
}
