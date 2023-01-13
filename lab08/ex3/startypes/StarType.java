package lab08.ex3.startypes;
import java.awt.*;

public abstract class StarType {

    private int size;
    private Color color;
    protected String description;
    protected Float[] physicalProperties;
    private int x;
    private int y;

    public StarType(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y , size, size);
    }

    public void setStarPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return this.color;
    }

    public int getSize() {
        return this.size;
    }
}
