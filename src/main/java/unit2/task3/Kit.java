package unit2.task3;


public class Kit {

    public Pen pen;
    public Pencil pencil;
    public Erasure erasure;
    public Ruler ruler;
    public Scissors scissors;
    public Sharpener sharpener;

    private Kit(Pen pen, Pencil pencil, Erasure erasure, Ruler ruler, Scissors scissors, Sharpener sharpener) {
        this.pen = pen;
        this.pencil = pencil;
        this.erasure = erasure;
        this.ruler = ruler;
        this.scissors = scissors;
        this.sharpener = sharpener;
    }

    public static Kit noviceKit(){
        return new Kit(new Pen(), new Pencil(), new Erasure(), new Ruler(), new Scissors(), new Sharpener());
    }

    @Override
    public String toString() {
        return "Kit{" +
                "\npen=" + pen +
                "\npencil=" + pencil +
                "\nerasure=" + erasure +
                "\nruler=" + ruler +
                "\nscissors=" + scissors +
                "\nsharpener=" + sharpener +
                '}';
    }
}
