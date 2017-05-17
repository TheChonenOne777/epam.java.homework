package unit2.task5;



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


}
