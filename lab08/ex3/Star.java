package lab08.ex3;

import java.awt.*;
import lab08.ex3.startypes.StarType;

public class Star{
    private int x,y;
    private StarType starType;

    Star (int x, int y, StarType starType){
        this.x = x;
        this.y = y;
        this.starType = starType;
    }

    public void draw(Graphics graphics){
        graphics.setColor(this.starType.getColor());
        graphics.fillOval(this.x, this.y, this.starType.getSize(), this.starType.getSize());
    }

}
