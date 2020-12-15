import java.awt.*;

public class Square extends Rectangle {
    public Square() {
        int red = rd.nextInt(256);
        int green = rd.nextInt(256);
        int blue = rd.nextInt(256);
        rgbColor = new Color(red, green, blue);

        int side = (rd.nextInt(16) + 5) * 10;
        speed = (rd.nextInt(4) + 1) * 5;
        this.setSide(side);

        topLeft = new Point(rd.nextInt(frameWidth - 2 * side), rd.nextInt(frameHeight - 2 * side));
        moveUp = rd.nextBoolean();
        moveRight = rd.nextBoolean();
    }

    public Square(int side, int speed) {
        this.width = side;
        this.length = side;
        this.speed = speed;
    }

    public Square(int side, int speed, String color, boolean filled) {
        this(side, speed);
        this.color = color;
        this.filled = filled;
    }

    public Square(Point topLeft, int speed, int side, String color, boolean filled) {
        this(side, speed);
        this.topLeft = topLeft;
        this.color = color;
        this.filled = filled;
    }


    public int getSide() {
        return this.width;
    }

    public void setSide(int side) {
        this.width = side;
        this.length = side;
    }

    public void setWidth(int side) {
        this.width = side;
        this.length = side;
    }

    public void setLength(int side) {
        this.length = side;
        this.width = side;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Square) {
            Square other = (Square) obj;
            if (topLeft.equals(other.getTopLeft())) {
                if (getSide() == other.getSide()) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        setSide((int) Math.round(getSide() * 10) / 10);
        return "Square[topLeft=" + getTopLeft().toString() + ",side=" + getSide()
                + ",color=" + color + ",filled=" + filled + "]";
    }
}
