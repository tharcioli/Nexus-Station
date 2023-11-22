package model;

import java.awt.*;

public class SquaresVO {

    public int x;
    public int y;
    public int width;
    public int height;
    public int quicknessX;
    public int quicknessY;
    public Color color;

    public SquaresVO(int x, int y, int width, int height, int quicknessX, int quicknessY, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.quicknessX = quicknessX;
        this.quicknessY = quicknessY;
        this.color = color;
    }
}
