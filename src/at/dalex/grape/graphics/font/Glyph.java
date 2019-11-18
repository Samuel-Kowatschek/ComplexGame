package at.dalex.grape.graphics.font;

public class Glyph {

    public final int width;
    public final int height;
    public final int x, y;
    public final float advance;

    public Glyph(int width, int height, int x, int y, float advance) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.advance = advance;
    }
}