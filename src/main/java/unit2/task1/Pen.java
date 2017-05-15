package unit2.task1;

/**
 * Specification for class Pen.
 */

public class Pen {

    private final String type;
    private String inkColor;
    private String bodyColor;
    private boolean attachable;
    private int inkLevel;
    private String material;
    private float thickness;

    Pen(){
        type = "ball";
    }

    Pen(String type, String inkColor){
        this.type = type;
        this.inkColor = inkColor;
    }

    public String getType() {
        return type;
    }

    public String getInkColor() {
        return inkColor;
    }

    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public boolean isAttachable() {
        return attachable;
    }

    public void setAttachable(boolean attachable) {
        this.attachable = attachable;
    }

    public int getInklevel() {
        return inkLevel;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public void setInklevel(int inklevel) {
        if(inklevel < 0) {
            inklevel = 0;
            System.out.println("ink level can only be between 0 and 100");
        }
        if(inklevel > 100){
            inklevel = 100;
            System.out.println("ink level can only be between 0 and 100");
        }
        this.inkLevel = inklevel;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    Pen(String type,
        String inkColor,
        String bodyColor,
        boolean attachable,
        int inklevel,
        String material,
        float thickness){

        this(type, inkColor);
        this.bodyColor = bodyColor;
        this.attachable = attachable;
        this.setInklevel(inklevel);
        this.material = material;
        this.thickness = thickness;
    }



    public void toWrite(String str){
        System.out.println(str);
    }

    public void recharge(){
        inkLevel = 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (attachable != pen.attachable) return false;
        if (inkLevel != pen.inkLevel) return false;
        if (Float.compare(pen.thickness, thickness) != 0) return false;
        if (type != null ? !type.equals(pen.type) : pen.type != null) return false;
        if (inkColor != null ? !inkColor.equals(pen.inkColor) : pen.inkColor != null) return false;
        if (bodyColor != null ? !bodyColor.equals(pen.bodyColor) : pen.bodyColor != null) return false;
        return material != null ? material.equals(pen.material) : pen.material == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (inkColor != null ? inkColor.hashCode() : 0);
        result = 31 * result + (bodyColor != null ? bodyColor.hashCode() : 0);
        result = 31 * result + (attachable ? 1 : 0);
        result = 31 * result + inkLevel;
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (thickness != +0.0f ? Float.floatToIntBits(thickness) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "type='" + type + '\'' +
                ", inkColor='" + inkColor + '\'' +
                ", bodyColor='" + bodyColor + '\'' +
                ", attachable=" + attachable +
                ", writingResorceLevel=" + inkLevel +
                ", material='" + material + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
